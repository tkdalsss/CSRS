package csrs.demo.controller;

import csrs.demo.configuration.interceptor.SessionConst;
import csrs.demo.dto.form.CreateForm;
import csrs.demo.dto.Lecture;
import csrs.demo.dto.Student;
import csrs.demo.dto.StudentLecture;
import csrs.demo.service.LectureService;
import csrs.demo.service.StudentLectureService;
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
    private final StudentLectureService sls;

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

        return "redirect:/home/home";
    }

    @GetMapping("/lecture/register")
    public String studentRegister(Model model) {
        List<Lecture> lectureList = ls.getList();
        model.addAttribute("lectures", lectureList);
        return "lectureRegister";
    }

    @PostMapping("/lecture/register")
    public String studentRegister(@SessionAttribute(name = SessionConst.LOGIN_MEMBER, required = false) Student loginMember,
                                  @RequestParam Long lectureId) {
        // TODO
        // 1. 이미 있는 수업들과 시간이 겹쳐서는 안됨
        // loginMember.studentId, LectureId
        if (!sls.findExists(loginMember.getStudentId())) {
            return "redirect:@{/lecture/register}";
        }

        // 2. 새로 추가할 때도 같은 시간대의 수업을 동시에 추가하려고 하면 에러 -> 일단은 나중에 추가하고 1개씩만 되게끔

        // 3. loginMember id 와 lectureId 로 StudentLecture 테이블에 저장
        StudentLecture sl = StudentLecture.createStudentLecture(ss.findById(loginMember.getStudentId()),
                ls.findById(lectureId));
        sls.save(sl);

        return "redirect:/student/my-page";
    }

    @GetMapping("/my-page")
    public String myPage(@SessionAttribute(name = SessionConst.LOGIN_MEMBER, required = false) Student loginMember,
                         Model model) {
        model.addAttribute("member", loginMember);
        return "myPage";
    }

}
