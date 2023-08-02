package csrs.demo.Repository.Student;

import csrs.demo.Dto.Student;

import java.util.Optional;

public interface StudentRepoCustom {
    Student findById(String studentId);
    Optional<Student> findByLoginId(String studentId);
}
