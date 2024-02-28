package csrs.demo.dto;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.nio.MappedByteBuffer;

@Entity
@Getter
@Setter
public class ReservationLecture {

    @Id
    @GeneratedValue
    private Long id;

    @OneToOne
    @JoinColumn(name = "ClassroomLecture")
    private ClassroomLecture classroomLecture;
}
