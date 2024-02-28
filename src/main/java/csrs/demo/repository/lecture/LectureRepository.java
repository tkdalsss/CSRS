package csrs.demo.repository.lecture;

import csrs.demo.dto.Lecture;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LectureRepository extends JpaRepository<Lecture, Long> {
}
