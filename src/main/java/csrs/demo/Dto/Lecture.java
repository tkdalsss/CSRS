package csrs.demo.Dto;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Lecture {

    @Id
    @GeneratedValue
    private Long id;

    private String className;

    private int classroomNum;
    private int maximum;
    private Day day1;
    private Day day2;
    private LocalTime startTime;
    private LocalTime endTime;

    public static Lecture CreateLecture(String className, int num, int max, Day day1, Day day2, LocalTime st, LocalTime et) {
        Lecture lecture = new Lecture();
        lecture.setClassName(className);
        lecture.setClassroomNum(num);
        lecture.setMaximum(max);
        lecture.setDay1(day1);
        lecture.setDay2(day2);
        lecture.setStartTime(st);
        lecture.setEndTime(et);

        return lecture;
    }
}
