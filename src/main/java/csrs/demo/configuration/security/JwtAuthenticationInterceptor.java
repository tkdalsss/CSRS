package csrs.demo.configuration.security;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@RequiredArgsConstructor
public class JwtAuthenticationInterceptor implements HandlerInterceptor {

    private final JwtTokenProvider jwtTokenProvider;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        return HandlerInterceptor.super.preHandle(request, response, handler);
        // Request Header 에서 토큰 추출
        String token = resolveToken((HttpServletRequest) request);

        // token 유효성 검사 -> 유효하지 않으면 false
        if (token != null && jwtTokenProvider.validateToken(token)) {
            // 토큰이 유효할 경우에 토큰에서 Authentication 객체를 가지고 와서 Security Context 에 저장
            // token 을 복호화 후 권한들 탐색해서 저장
            Authentication authentication = jwtTokenProvider.getAuthentication(token);
            SecurityContextHolder.getContext().setAuthentication(authentication);
            return true;
        }

        //

        return false;
    }

    private String resolveToken(HttpServletRequest request) {
        String bearerToken = request.getHeader("Authorization");
        if (StringUtils.hasText(bearerToken) && bearerToken.startsWith("Bearer")) {
            return bearerToken.substring(7); // Bearer e343 -> Bearer 뒤에 토큰 값 가져오기
        }
        return null;
    }
}
