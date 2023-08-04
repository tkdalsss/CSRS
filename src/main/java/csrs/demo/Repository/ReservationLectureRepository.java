package csrs.demo.Repository;

import csrs.demo.Dto.ReservationLecture;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationLectureRepository extends JpaRepository<ReservationLecture, Long> {
}
