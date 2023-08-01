package csrs.demo.Controller;

import csrs.demo.Configuration.Interceptor.SessionConst;
import csrs.demo.Dto.Form.CreateForm;
import csrs.demo.Dto.Form.LoginForm;
import csrs.demo.Dto.Student;
import csrs.demo.Service.StudentService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/student")
public class StudentController {

    private final StudentService studentService;

    @GetMapping("/register")
    public String createMember(Model model){
        model.addAttribute("createForm", new CreateForm());
        return "create/createMember";
    }

    @PostMapping("/register")
    public String createMember(@Valid CreateForm createForm, BindingResult result) {

        if(result.hasErrors()){
            return "create/createMember";
        }

        Student student = Student.createStudent(createForm.getName(), createForm.getStudentId(), createForm.getPassword(), createForm.getMajor());
        studentService.save(student);

        return "redirect:/home/home";
    }

    @GetMapping("/my-page")
    public String myPage(@SessionAttribute(name = SessionConst.LOGIN_MEMBER, required = false) Student loginMember,
                         Model model){
//        model.addAttribute("student_lecture", loginMember.getLectures());
        model.addAttribute("member", loginMember);
        return "myPage";
    }

}
