package csrs.demo.controller;

import csrs.demo.configuration.interceptor.SessionConst;
import csrs.demo.dto.form.CreateForm;
import csrs.demo.dto.Lecture;
import csrs.demo.dto.Student;
import csrs.demo.service.LectureService;
import csrs.demo.service.StudentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/student")
public class StudentController {

    private final StudentService ss;
    private final LectureService ls;
//    private final StudentLectureService sls;

    @GetMapping("/register")
    public String createMember(Model model) {
        model.addAttribute("createForm", new CreateForm());
        return "create/createMember";
    }

    @PostMapping("/register")
    public String createMember(@Valid CreateForm createForm, BindingResult result) {

        if (result.hasErrors()) {
            return "create/createMember";
        }

        Student student = Student.createStudent(
                createForm.getName(), createForm.getStudentId(), createForm.getPassword(),
                createForm.getMajor());
        ss.save(student);

        return "redirect:/home";
    }

    @GetMapping("/my-page")
    public String myPage(@SessionAttribute(name = SessionConst.LOGIN_MEMBER, required = false) Student loginMember,
                         Model model) {
        model.addAttribute("member", loginMember);
        return "myPage";
    }

}
