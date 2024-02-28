package csrs.demo.dto;

import csrs.demo.dto.Enum.Day;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalTime;

@Entity
@Getter
@Setter
public class Lecture {

    @Id
    @GeneratedValue
    private Long lecture_id;

    private String lectureName; // 강의 이름
    private String instructorName; // 교수
    private int quantity; // 수강 정원
    private Day day1;
    private Day day2;
    private LocalTime startTime;
    private LocalTime endTime;

    @ManyToOne
    @JoinColumn(name = "classroom_id")
    private Classroom classroom;

    public static Lecture CreateLecture(String lectureName, String instructorName,
                                        int quantity, Day day1, Day day2,
                                        LocalTime startTime, LocalTime endTime,
                                        Classroom cr) {
        Lecture lecture = new Lecture();
        lecture.setLectureName(lectureName);
        lecture.setInstructorName(instructorName);
        lecture.setQuantity(quantity);
        lecture.setDay1(day1);
        lecture.setDay2(day2);
        lecture.setStartTime(startTime);
        lecture.setEndTime(endTime);
        lecture.setClassroom(cr);
        return lecture;
    }
}
