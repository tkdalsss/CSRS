package csrs.demo.repository;

import csrs.demo.dto.StudentLecture;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentLectureRepository extends JpaRepository<StudentLecture, Long> {
}
