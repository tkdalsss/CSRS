package csrs.demo.dto;

import csrs.demo.dto.Enum.Day;
import csrs.demo.dto.Enum.Reservation;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Seat {

    @Id
    @GeneratedValue
    private Long seat_id;

//    @ManyToOne
//    @JoinColumn(name = "classroom_id")
//    private Classroom classroom;

    @ManyToOne
    @JoinColumn(name = "cl_id")
    private ClassroomLecture classroomLecture;

    private int seatNumber;
    private boolean isReserved;
    private Day day;

    // classroom 정보를 받으면
    // capacity 만큼 seat 생성
    public static Seat createSeat(ClassroomLecture classroomLecture, int num, Day day) {
        Seat seat = new Seat();
        seat.setClassroomLecture(classroomLecture);
        seat.setSeatNumber(num);
        seat.setReserved(false);
        seat.setDay(day);
        return seat;
    }
}
