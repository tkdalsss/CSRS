package csrs.demo.controller;

import csrs.demo.configuration.interceptor.SessionConst;
import csrs.demo.dto.*;
import csrs.demo.dto.Enum.Day;
import csrs.demo.service.*;
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
    private final ClassroomLectureService cls;
    private final StudentLectureService studentLectureService;
    private final SeatService seatService;

    @GetMapping("/new")
    public String createLecture(Model model) {
        model.addAttribute("classroom", cs.classrooms());
        model.addAttribute("lecture", new Lecture());
        return "create/createLecture";
    }

    @PostMapping("/new")
    public String createLecture(Lecture lc, @RequestParam String crName) {

        Classroom classroom = cs.findById(crName);

        Lecture lecture = Lecture.CreateLecture(lc.getLectureName(), lc.getInstructorName(), lc.getQuantity(),
                lc.getDay1(), lc.getDay2(), lc.getStartTime(), lc.getEndTime(), classroom);
        ls.save(lecture);

        ClassroomLecture cl = ClassroomLecture.createClassroomLecture(classroom, lecture);
        cls.save(cl);

        // 자리 추가 - classroom lecture, 수업-강의실 마다의 자리 생성
        // 요일별 수업의 강의실의 자리.. -> 날짜 + ClassroomLecture
        Day[] days = {lc.getDay1(), lc.getDay2()};
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < classroom.getCapacity(); j++) {
                // 자리 추가(ClassroomLecture, 자리번호, 날짜)
                Seat seat = Seat.createSeat(cl, j + 1, days[i]);
                seatService.save(seat);
                cl.addSeat(seat);
            }
        }

        return "redirect:/home/admin";
    }

    // 학생이 듣는 수업 등록
    @GetMapping("/register")
    public String studentRegister(Model model) {
        List<Lecture> lectureList = ls.getList();
        model.addAttribute("lectures", lectureList);
        return "lectureRegister";
    }

    @PostMapping("/register")
    public String studentRegister(@SessionAttribute(name = SessionConst.LOGIN_MEMBER, required = false) Student loginMember,
                                  @RequestParam Long lectureId) {
//        Student student = studentService.findById(loginMember.getStudentId());
        Lecture lecture = ls.findById(lectureId);
        // TODO
        // 1. 이미 있는 수업들과 시간이 겹쳐서는 안됨
        // loginMember.studentId, LectureId
//        if (!sls.findExists(loginMember.getStudentId())) {
//            return "redirect:@{/lecture/register}";
//        }

        // 2. 새로 추가할 때도 같은 시간대의 수업을 동시에 추가하려고 하면 에러 -> 일단은 나중에 추가하고 1개씩만 되게끔

        // 3. loginMember id 와 lectureId 로 StudentLecture 테이블에 저장
        StudentLecture sl = StudentLecture.createStudentLecture(loginMember, lecture);
        studentLectureService.save(sl);

        // error -> Student lectures에 lecture 추가
        loginMember.addLecture(lecture);

        return "redirect:/student/my-page";
    }
}
