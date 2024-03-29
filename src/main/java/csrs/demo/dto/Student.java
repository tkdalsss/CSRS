package csrs.demo.dto;

import csrs.demo.dto.Enum.Major;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Student {

    @Id
    @GeneratedValue
    private Long id;

    private String username;
    private String studentId; // 학번
    private String password;
    private Major major;
//    private LocalDateTime createdAt;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "StudentLecture", joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "lecture_id"))
    private List<Lecture> lectures = new ArrayList<>();

    public static Student createStudent(String name, String studentId, String password, Major major) {
        Student student = new Student();

        student.setUsername(name);
        student.setStudentId(studentId);
        student.setPassword(password);
        student.setMajor(major);
//        student.setCreatedAt(LocalDateTime.now());

        return student;
    }

    public void addLecture(Lecture lecture) {
        lectures.add(lecture);
    }

}