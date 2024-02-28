package csrs.demo.controller;

import csrs.demo.dto.Classroom;
import csrs.demo.dto.Seat;
import csrs.demo.service.ClassroomService;
import csrs.demo.service.LectureService;
import csrs.demo.service.SeatService;
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

    //private final LectureService ls;
    private final ClassroomService cs;
    //private final SeatService seatService;

    @GetMapping("/new")
    public String createClassroom(Model model) {
        model.addAttribute("classroom", new Classroom());
        return "/create/createClassroom";
    }

    @PostMapping("/new")
    public String createClassroom(Classroom classroom) {

        int capacity = classroom.getCapacity();

        // 나중에 validation 추가
        Classroom cr = Classroom.createClassroom(classroom.getClassroomName(), capacity);
        cs.save(cr);

        return "redirect:/home/admin";
    }

}
