package csrs.demo.Repository.Student;

import csrs.demo.Dto.Student;
import csrs.demo.Repository.Student.StudentRepoCustom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long>, StudentRepoCustom {
}
