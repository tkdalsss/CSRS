package csrs.demo.repository.classroom;

import csrs.demo.dto.ClassroomLecture;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClassroomLectureRepository extends JpaRepository<ClassroomLecture, Long> {
}
