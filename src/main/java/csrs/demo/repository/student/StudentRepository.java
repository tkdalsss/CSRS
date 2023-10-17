package csrs.demo.repository.student;

import csrs.demo.dto.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long>, StudentRepoCustom {
}
