package csrs.demo.configuration.security;

import csrs.demo.dto.security.JwtToken;
import io.jsonwebtoken.*;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.stream.Collectors;

@Slf4j
@Component
public class JwtTokenProvider {
    private final Key key;

    // secret 값 가져와서 key 에 저장
    public JwtTokenProvider(@Value("${jwt.secret}") String secretKey) {
        byte[] keyBytes = Decoders.BASE64.decode(secretKey);
        this.key = Keys.hmacShaKeyFor(keyBytes);
    }

    // member 정보를 활용하여 token 생성
    public JwtToken generateToken(Authentication authentication) {
        // 권한 가져오기
        String authorities = authentication.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.joining(","));

        long now = (new Date()).getTime(); // 현재 시간

        // Access Token
        Date accessTokenExpiresIn = new Date(now + 86400000); // 만료 기한 설정
        String accessToken = Jwts.builder()
                .setSubject(authentication.getName())
                .claim("auth", authorities)
                .setExpiration(accessTokenExpiresIn)
                .signWith(key, SignatureAlgorithm.HS256)
                .compact();

        // Refresh Token
        String refreshToken = Jwts.builder()
                .setExpiration(new Date(now + 86400000))
                .signWith(key, SignatureAlgorithm.HS256)
                .compact();

        return JwtToken.builder()
                .grantType("Bearer")
                .accessToken(accessToken)
                .refreshToken(refreshToken)
                .build();
    }

    // 토큰 복호화 후 토큰에 들어있는 정보를 가져오는 메서드
    public Authentication getAuthentication(String accessToken) {
        // Access token 을 복호화하여 사용자의 인증 정보 생성
        // claims 에서 권한 정보를 추출하고 User 객체를 생성하여 Authentication 객체 생성
        Claims claims = parseClaims(accessToken);

        // 정보가 없을 때 처리
        if (claims.get("auth") == null) {
            throw new RuntimeException("권한 정보가 없는 토큰입니다.");
        }

        // 권한 수집 -> 권한 정보를 다양한 타입의 객체로 처리할 수 있고, 더 큰 유연성과 확장성을 가질 수 있음
        Collection<? extends GrantedAuthority> authorities = Arrays.stream(claims.get("auth") // 토큰의 클레임에서 권한 정보를 가져옴
                        .toString().split(","))
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());

        // UserDetails 객체를 만들어서 Authentication return
        // getSubject() -> 토큰의 주체 ex) 사용자의 식별자나 이메일 주소
        UserDetails principal = new User(claims.getSubject(), "", authorities);
        return new UsernamePasswordAuthenticationToken(principal, "", authorities);
    }

    public boolean validateToken(String token) {
        // parseClaimsJws -> jwt 토큰의 검증과 파싱 수행
        try {
            Jwts.parserBuilder().setSigningKey(key) // 서명키 설정 -> 예외 처리를 통해 유효성 여부 판단
                    .build().parseClaimsJws(token);
            return true;
        } catch (SecurityException | MalformedJwtException e) {
            log.info("invalid JWT Token", e);
        } catch (ExpiredJwtException e) {
            log.info("Expired JWT Token", e);
        } catch (UnsupportedJwtException e) {
            log.info("Unsupported JWT Token", e);
        } catch (IllegalArgumentException e) {
            log.info("JWT claims string is empty", e);
        }
        return false;
    }

    private Claims parseClaims(String accessToken) {
        // Claims -> 토큰에서 사용할 정보의 조각
        // 주어진 access token 을 복호화하고 만료된 토큰인 경우에도 claims 반환
        try {
            return Jwts.parserBuilder()
                    .setSigningKey(key)
                    .build()
                    // parseClaimsJws -> JWT 토큰의 검증과 파싱 수행
                    .parseClaimsJws(accessToken)
                    .getBody();
        } catch (ExpiredJwtException e) {
            return e.getClaims();
        }
    }

}
