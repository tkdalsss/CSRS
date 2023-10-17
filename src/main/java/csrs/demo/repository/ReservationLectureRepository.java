package csrs.demo.repository;

import csrs.demo.dto.ReservationLecture;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationLectureRepository extends JpaRepository<ReservationLecture, Long> {
}
