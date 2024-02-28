package csrs.demo.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import csrs.demo.service.SeatService;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class ClassroomLecture {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "classroom_id")
    private Classroom cr;

    @ManyToOne
    @JoinColumn(name = "lecture_id")
    private Lecture lc;

    @JsonIgnore()
    @OneToOne(mappedBy = "classroomLecture") // 외래키 잡고있는 쪽에서 보내는쪽?으로 보내는쪽의 변수명과 같은 것으로 선언해야함
    private ReservationLecture reservationLecture;

    @JsonIgnore()
    @OneToMany(mappedBy = "classroomLecture")
    private List<Seat> seats = new ArrayList<>();

    public static ClassroomLecture createClassroomLecture(Classroom cr, Lecture lc) {
        ClassroomLecture cl = new ClassroomLecture();
        cl.setCr(cr);
        cl.setLc(lc);

        return cl;
    }

    public void addSeat(Seat seat) {
        seats.add(seat);
    }
}
