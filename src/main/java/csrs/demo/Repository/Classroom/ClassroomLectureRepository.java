package csrs.demo.Repository.Classroom;

import csrs.demo.Dto.ClassroomLecture;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClassroomLectureRepository extends JpaRepository<ClassroomLecture, Long> {
}
