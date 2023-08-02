package csrs.demo.Controller;

import csrs.demo.Configuration.Interceptor.SessionConst;
import csrs.demo.Dto.Classroom;
import csrs.demo.Dto.Lecture;
import csrs.demo.Dto.Student;
import csrs.demo.Service.ClassroomService;
import csrs.demo.Service.LectureService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/lecture")
public class LectureController {

    private final LectureService ls;
    private final ClassroomService cs;

    @GetMapping("/new")
    public String createLecture(Model model) {
        model.addAttribute("classroom", cs.classrooms());
        model.addAttribute("lecture", new Lecture());
        return "create/createLecture";
    }

    @PostMapping("/new")
    public String createLecture(Lecture lc, @RequestParam int crNum) {

        Lecture lecture = Lecture.CreateLecture(lc.getClassName(), crNum, lc.getMaximum(), lc.getStartTime(), lc.getEndTime());
        ls.save(lecture);

        return "redirect:/home/admin";
    }

    @GetMapping("/register")
    public String studentRegister(Model model) {
        List<Lecture> lectureList = ls.getList();
        model.addAttribute("lectures", lectureList);
        return "lectureRegister";
    }

    @PostMapping("/register")
    public String studentRegister(@SessionAttribute(name = SessionConst.LOGIN_MEMBER, required = false) Student loginMember,
                                  @RequestParam Long lectureId){
        // TODO
        // 1. 이미 있는 수업들과 시간이 겹쳐서는 안됨
        // 2. 새로 추가할 때도 같은 시간대의 수업을 동시에 추가하려고 하면 에러
        // 3.

        return "redirect:/student/my-page";
    }
}
