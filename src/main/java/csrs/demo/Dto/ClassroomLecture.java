package csrs.demo.Dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

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
    @OneToOne(mappedBy = "classroomLecture")
    private ReservationLecture reservationLecture;

    public static ClassroomLecture createClassroomLecture(Classroom cr, Lecture lc) {
        ClassroomLecture cl = new ClassroomLecture();
        cl.setCr(cr);
        cl.setLc(lc);
        return cl;
    }
}
