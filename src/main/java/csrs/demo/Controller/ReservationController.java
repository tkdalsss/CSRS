package csrs.demo.Controller;

import csrs.demo.Dto.Lecture;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/reservation")
public class ReservationController {

    @GetMapping("/home")
    public String reservationHome(Model model) {
        // TODO
        // 1. 강의실과 시간별 강의 매치해서 현황 표시
        // 2. 예약 인원 / 정원 표시
        // 강의명 링크 -> lecture id -> requestParam
        // 강의실 정보 -> classroom id -> requestParam
//        List<Lecture> lectures = ls.getList();
//        model.addAttribute("lectures", lectures);
        // 3. 클릭해서 들어가면 자리 배치도와 예약된 상태 표시

        return "reservation/home";
    }

//    @GetMapping("/{lectureId}/{pId}")
//    public String reservationLecture(@PathVariable("lectureId") String id, @PathVariable("pId") String pid) {
//
//    }

}
