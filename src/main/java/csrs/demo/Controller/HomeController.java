package csrs.demo.Controller;

import csrs.demo.Configuration.Interceptor.SessionConst;
import csrs.demo.Dto.Admin;
import csrs.demo.Dto.Form.LoginForm;
import csrs.demo.Dto.Student;
import csrs.demo.Service.AdminService;
import csrs.demo.Service.StudentService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@Controller
@RequiredArgsConstructor
@RequestMapping("/home")
public class HomeController {

    private final StudentService studentService;
    private final AdminService adminService;

    @GetMapping
    public String home(){
        return "/home/home";
    }

    @GetMapping("/member")
    public String memberHome(@SessionAttribute(name = SessionConst.LOGIN_MEMBER, required = false)Student loginMember,
                             Model model){
        model.addAttribute("member", loginMember);
        return "home/memberHome";
    }

    @GetMapping("/admin")
    public String adminHome(@SessionAttribute(name = SessionConst.ADMIN, required = false) Admin admin,
                            Model model){
        model.addAttribute("admin", admin);
        return "/home/adminHome";
    }

    @GetMapping("/login")
    public String login(Model model){
        model.addAttribute("loginForm", new LoginForm());
        return "login";
    }

    @PostMapping("/login")
    public String login(@Valid @ModelAttribute LoginForm loginForm, BindingResult result,
                        @RequestParam(defaultValue = "/") String redirectURL,
                        HttpServletRequest request) {
        if (result.hasErrors()) {
            return "login";
        }

        HttpSession session = request.getSession();

        // Edit
        if (adminService.findById(loginForm.getStudentId())){
            Admin admin = Admin.createAdmin(loginForm.getStudentId(), loginForm.getPassword());
            session.setAttribute(SessionConst.ADMIN, admin);
            return "redirect:/home/admin";
        }

        Student loginMember = studentService.login(loginForm.getStudentId(), loginForm.getPassword());
        if (loginMember == null) {
            result.reject("loginFail", "아이디 또는 비밀번호가 맞지 않습니다.");
            return "login";
        }

        session.setAttribute(SessionConst.LOGIN_MEMBER, loginMember);

        return "redirect:/home/member";
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

    @GetMapping("/mypage")
    public String mypage(@SessionAttribute(name = SessionConst.LOGIN_MEMBER, required = false) Student loginMember,
                         Model model){
        model.addAttribute("member", loginMember);
        return "mypage";
    }
}
