package csrs.demo.Dto;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
public class Lecture {

    @Id @GeneratedValue
    private Long id;

    private String className;

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "classroom_id")
//    private Classroom classroom;

    private int classroomNum;
    private int maximum;
    private LocalTime startTime;
    private LocalTime endTime;

//    @OneToMany(mappedBy = "lecture", fetch = FetchType.LAZY)
//    private List<Student> students = new ArrayList<>();

    public static Lecture CreateLecture(String className, int num, int max, LocalTime st, LocalTime et) {
        Lecture lecture = new Lecture();
        lecture.setClassName(className);
        lecture.setClassroomNum(num);
        lecture.setMaximum(max);
        lecture.setStartTime(st);
        lecture.setEndTime(et);

        return lecture;
    }
}
