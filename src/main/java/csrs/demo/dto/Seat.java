package csrs.demo.dto;

import csrs.demo.dto.Enum.Reservation;
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
