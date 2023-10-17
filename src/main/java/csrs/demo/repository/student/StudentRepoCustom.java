package csrs.demo.repository.student;

import csrs.demo.dto.Student;

import java.util.Optional;

public interface StudentRepoCustom {
    Student findById(String studentId);

    Optional<Student> findByLoginId(String studentId);
}
