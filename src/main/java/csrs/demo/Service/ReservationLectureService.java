package csrs.demo.Service;

import csrs.demo.Dto.Enum.Reservation;
import csrs.demo.Dto.ReservationLecture;
import csrs.demo.Repository.ReservationLectureRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReservationLectureService {

    private final ReservationLectureRepository repository;

    public void save(ReservationLecture reservationLecture) {
        repository.save(reservationLecture);
    }

    public List<ReservationLecture> findAll() {
        return repository.findAll();
    }
}
