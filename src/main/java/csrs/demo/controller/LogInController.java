package csrs.demo.controller;

import csrs.demo.configuration.interceptor.SessionConst;
import csrs.demo.dto.Admin;
import csrs.demo.dto.Student;
import csrs.demo.dto.form.LoginForm;
import csrs.demo.service.AdminService;
import csrs.demo.service.StudentService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
@Slf4j
public class LogInController {

    // TODO
    // 강의실 좌석 생성하는 거
    // 예약 하는거
    // session 기반 로그인 -> jwt 기반 로그인으로 바꾸기
    // react랑 연동해서 프론트엔드 작업
    // gcp 배포

    // private final -> 의존성이 일관되게 유지됨, 스레드 안전성, 불변성
    private final AdminService adminService;
    private final StudentService studentService;

    @GetMapping("/login")
    public String login(Model model) {
        model.addAttribute("loginForm", new LoginForm());
        return "login";
    }

//    @GetMapping("/re-login")
//    public String reLogin(Model model) {
//        model.addAttribute("msg", "학번이나 비밀번호를 다시 확인해주세요");
//        model.addAttribute("url", "/login");
//        return "alert";
//    }

    @PostMapping("/login")
    public String login(@Valid @ModelAttribute LoginForm loginForm, BindingResult result,
                        HttpServletRequest request) {
        if (result.hasErrors()) {
            // TODO
            // 로그인 실패시 다시 로그인하도록 알려주는 alert 출력
            // result.reject("loginFail", "학번 혹은 비밀번호를 확인해주세요");
            return "login";
        }

        HttpSession session = request.getSession();

        // Admin login
        if (loginForm.getStudentId().startsWith("admin")) {
            Admin admin = adminService.loginAdmin(loginForm.getStudentId(), loginForm.getPassword());
            if (admin != null) {
                session.setAttribute(SessionConst.ADMIN, admin);
                return "redirect:/home/admin"; // 관리자 화면
            } else return "login";
        }

        // Member login
        Student loginMember = studentService.login(loginForm.getStudentId(), loginForm.getPassword());
        if (loginMember == null) {
            result.reject("loginFail", "아이디 또는 비밀번호가 맞지 않습니다.");
            return "login"; // 다시 로그인 화면
        }

        session.setAttribute(SessionConst.LOGIN_MEMBER, loginMember);

        return "redirect:/home/member"; // 로그인 된 멤버 화면
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request) {

        // 세션을 찾아서 사용하는 시점에는 'create:false' 옵션 사용
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate();
        }

        return "redirect:/home";
    }
}
