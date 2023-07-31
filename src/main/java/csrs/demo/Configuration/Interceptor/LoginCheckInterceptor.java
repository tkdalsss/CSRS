package csrs.demo.Configuration.Interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;

import java.util.UUID;

@Slf4j
public class LoginCheckInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String requestURI = request.getRequestURI();
        log.info("인증 체크 인터셉터 실행 {}", requestURI);

        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute(SessionConst.LOGIN_MEMBER) == null){
            // 관리자 로그인 이면 PASS
            if (session.getAttribute(SessionConst.ADMIN) != null) {
                return true;
            }
            log.info("미인증 사용자 요청");
            response.sendRedirect("/home/login?redirectURL="+requestURI);
            return false;
        }

        return true;
    }
}
