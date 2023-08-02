package csrs.demo.Dto;

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

    private String name;
    private String studentId; // 학번
    private String password;
    private Major major;
    private LocalDateTime createdAt;

    //    @OneToMany(mappedBy = "student", fetch = FetchType.LAZY)
//    private List<Lecture> lectures = new ArrayList<>();
    @ManyToMany
    @JoinTable(name = "StudentLecture", joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "lecture_id"))
    private List<Lecture> lectures = new ArrayList<Lecture>();

    public static Student createStudent(String name, String studentId, String password, Major major) {
        Student student = new Student();

        student.setName(name);
        student.setStudentId(studentId);
        student.setPassword(password);
        student.setMajor(major);
        student.setCreatedAt(LocalDateTime.now());

        return student;
    }

}