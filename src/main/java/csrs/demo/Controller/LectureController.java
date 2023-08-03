package csrs.demo.Controller;

import csrs.demo.Configuration.Interceptor.SessionConst;
import csrs.demo.Dto.*;
import csrs.demo.Service.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/lecture")
public class LectureController {

    private final StudentService ss;
    private final LectureService ls;
    private final ClassroomService cs;
    private final StudentLectureService sls;
    private final ClassroomLectureService cls;

    @GetMapping("/new")
    public String createLecture(Model model) {
        model.addAttribute("classroom", cs.classrooms());
        model.addAttribute("lecture", new Lecture());
        return "create/createLecture";
    }

    @PostMapping("/new")
    public String createLecture(Lecture lc, @RequestParam int crNum) {

        Lecture lecture = Lecture.CreateLecture(lc.getClassName(), crNum, lc.getMaximum(),
                lc.getDay1(), lc.getDay2(), lc.getStartTime(), lc.getEndTime());
        ls.save(lecture);

        ClassroomLecture cl = ClassroomLecture.createClassroomLecture(cs.findById(crNum), lecture);
        cls.save(cl);

        return "redirect:/home/admin";
    }
}
