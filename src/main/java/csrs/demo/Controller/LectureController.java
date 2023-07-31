package csrs.demo.Controller;

import csrs.demo.Dto.Classroom;
import csrs.demo.Dto.Lecture;
import csrs.demo.Service.ClassroomService;
import csrs.demo.Service.LectureService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
    public String createLecture(Lecture lc) {

        Lecture lecture = Lecture.CreateLecture(lc.getClassName(), lc.getClassroomNum(), lc.getMaximum(), lc.getStartTime(), lc.getEndTime());
        ls.save(lecture);

        return "redirect:/home/member";
    }
}
