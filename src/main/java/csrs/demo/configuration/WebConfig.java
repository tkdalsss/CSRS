package csrs.demo.configuration;

import csrs.demo.configuration.interceptor.AdminLoginCheckInterceptor;
import csrs.demo.configuration.interceptor.LogInterceptor;
import csrs.demo.configuration.interceptor.LoginCheckInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        registry.addInterceptor(new LogInterceptor())
                .order(1)
                .addPathPatterns("/**")
                .excludePathPatterns("/css/**", "/*.ico", "/error");

        registry.addInterceptor(new LoginCheckInterceptor())
                .order(2)
                .addPathPatterns("/**")
                .excludePathPatterns("/home", "/student/register", "/home/login",
                        "/css/**", "/*.ico", "/error");

        registry.addInterceptor(new AdminLoginCheckInterceptor())
                .order(3)
                .addPathPatterns("/home/admin/**", "/classroom/new", "/lecture/new")
                .excludePathPatterns("/home", "/student/register", "/home/login",
                        "/css/**", "*.ico", "/error");
    }
}
