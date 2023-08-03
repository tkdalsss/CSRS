package csrs.demo.Dto;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class StudentLecture {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

    @ManyToOne
    @JoinColumn(name = "lecture_id")
    private Lecture lecture;

    public static StudentLecture createStudentLecture(Student student, Lecture lecture) {
        StudentLecture sl = new StudentLecture();
        sl.setStudent(student);
        sl.setLecture(lecture);
        return sl;
    }
}
