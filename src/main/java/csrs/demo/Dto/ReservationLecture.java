package csrs.demo.Dto;

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

    @OneToOne()
    @JoinColumn(name = "classroom_lecture_id")
    private ClassroomLecture cl;

    private Reservation rsv;

}
