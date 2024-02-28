package csrs.demo.dto.security;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
@AllArgsConstructor
public class JwtToken {
    // JWT 인증 타입 - Bearer
    private String grantType;
    private String accessToken;
    private String refreshToken;
}
