package csrs.demo.Repository.Student;

import csrs.demo.Dto.StudentLecture;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentLectureRepository extends JpaRepository<StudentLecture, Long>, StudentLectureCustomRepo {
}
