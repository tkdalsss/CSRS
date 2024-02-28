package csrs.demo.dto;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Classroom {

    @Id
    @GeneratedValue
    private Long classroom_id;

    private String classroomName;
    private int capacity;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "ClassroomLecture", joinColumns = @JoinColumn(name = "classroom_id"),
            inverseJoinColumns = @JoinColumn(name = "lecture_id"))
    private List<Lecture> lectures = new ArrayList<>();

    public static Classroom createClassroom(String crName, int crNum) {
        Classroom cr = new Classroom();
        cr.setClassroomName(crName);
        cr.setCapacity(crNum);
        return cr;
    }

}
