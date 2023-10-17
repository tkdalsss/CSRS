package csrs.demo.service;

import csrs.demo.dto.ReservationLecture;
import csrs.demo.repository.ReservationLectureRepository;
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
