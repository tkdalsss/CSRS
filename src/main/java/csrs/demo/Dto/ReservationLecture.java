package csrs.demo.Dto;

import csrs.demo.Dto.Enum.Day;
import csrs.demo.Dto.Enum.Reservation;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
public class ReservationLecture {

    @Id
    @GeneratedValue
    private Long id;

    private Date rlDate;

    @OneToOne
    @JoinColumn(name = "classroom_lecture")
    private ClassroomLecture classroomLecture;

    private Day day;

    private Reservation rsv;

    public static ReservationLecture createReservationLecture(Date date, ClassroomLecture cl, Day day, Reservation rsv) {
        ReservationLecture rl = new ReservationLecture();
        rl.setRlDate(date);
        rl.setClassroomLecture(cl);
        rl.setDay(day);
        rl.setRsv(rsv);
        return rl;
    }

}
