package csrs.demo.controller;

import csrs.demo.configuration.interceptor.SessionConst;
import csrs.demo.dto.Admin;
import csrs.demo.dto.form.LoginForm;
import csrs.demo.dto.Student;
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
import org.springframework.web.bind.annotation.*;

import javax.naming.Binding;

@Controller
@RequiredArgsConstructor
@RequestMapping("/home")
@Slf4j
public class HomeController {

//    private final StudentService studentService;
//    private final AdminService adminService;

    @GetMapping
    public String home() {
        return "/home/home";
    }

    @GetMapping("/member")
    public String memberHome(@SessionAttribute(name = SessionConst.LOGIN_MEMBER, required = false) Student loginMember,
                             Model model) {
        model.addAttribute("member", loginMember);
        return "/home/memberHome";
    }

    @GetMapping("/admin")
    public String adminHome(@SessionAttribute(name = SessionConst.ADMIN, required = false) Admin admin,
                            Model model) {
        model.addAttribute("admin", admin);
        return "/home/adminHome";
    }

    // TODO
    // redirectURL Post mapping
//
//    @GetMapping("/login?redirectURL=/{redirectURL1}/{redirectURL2}")
//    public String redirectLogin(Model model, @PathVariable("redirectURL1") String redirectURL1,
//                                @PathVariable("redirectURL2") String redirectURL2) {
//        model.addAttribute("redirectURL1", redirectURL1);
//        model.addAttribute("redirectURL2", redirectURL2);
//        model.addAttribute("loginForm", new LoginForm());
//        return "redirectLogin";
//    }
//
//    @PostMapping("/login?redirectURL=/{redirectURL1}/{redirectURL2}")
//    public String redirectLogin(@Valid @ModelAttribute LoginForm loginForm, BindingResult result,
//                                @PathVariable("redirectURL1") String redirectURL1,
//                                @PathVariable("redirectURL2") String redirectURL2,
//                                HttpServletRequest request) {
//        if (result.hasErrors()) {
//            return "login";
//        }
//
//        HttpSession session = request.getSession();
//
//        // Admin login
//        Admin admin = adminService.loginAdmin(loginForm.getStudentId(), loginForm.getPassword());
//        if (admin != null) {
//            session.setAttribute(SessionConst.ADMIN, admin);
//            return "redirect:" + redirectURL1 + redirectURL2;
//        }
//
//        // Member login
//        Student loginMember = studentService.login(loginForm.getStudentId(), loginForm.getPassword());
//        if (loginMember == null) {
//            result.reject("loginFail", "아이디 또는 비밀번호가 맞지 않습니다.");
//            return "login";
//        }
//
//        session.setAttribute(SessionConst.LOGIN_MEMBER, loginMember);
//
//        return "redirect:" + redirectURL1 + redirectURL2;
//    }

}
