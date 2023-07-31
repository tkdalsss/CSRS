package csrs.demo.Controller;

import csrs.demo.Dto.Classroom;
import csrs.demo.Service.ClassroomService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/classroom")
public class ClassroomController {

    private final ClassroomService crService;

    @GetMapping("/new")
    public String createClassroom(Model model){
        model.addAttribute("classroom", new Classroom());
        return "/create/createClassroom";
    }

    @PostMapping("/new")
    public String createClassroom(Classroom classroom) {
        // 나중에 validation 추가
        Classroom cr = Classroom.createClassroom(classroom.getCrNum(), classroom.getCrName());
        crService.save(cr);

        return "redirect:/home/member";
    }
}
