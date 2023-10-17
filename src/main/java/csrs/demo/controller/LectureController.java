package csrs.demo.controller;

import csrs.demo.dto.*;
import csrs.demo.service.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/lecture")
public class LectureController {

    private final LectureService ls;
    private final ClassroomService cs;
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
