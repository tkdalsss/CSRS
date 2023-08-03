package csrs.demo.Dto;

import csrs.demo.Dto.Enum.Reservation;
import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Getter
public class Seat {

    @Id
    @GeneratedValue
    private Long id;

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "classroom_id")
//    private Classroom cr;

    private Reservation seat_rsv;

}
