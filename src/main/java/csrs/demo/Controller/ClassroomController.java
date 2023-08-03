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

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/classroom")
public class ClassroomController {

    private final LectureService ls;
    private final ClassroomService cs;

    @GetMapping("/new")
    public String createClassroom(Model model) {
        model.addAttribute("classroom", new Classroom());
        return "/create/createClassroom";
    }

    @PostMapping("/new")
    public String createClassroom(Classroom classroom) {
        // 나중에 validation 추가
        Classroom cr = Classroom.createClassroom(classroom.getCrNum(), classroom.getCrName());
        cs.save(cr);

        return "redirect:/home/admin";
    }

}
