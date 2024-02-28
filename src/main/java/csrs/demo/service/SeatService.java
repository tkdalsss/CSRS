package csrs.demo.service;

import csrs.demo.dto.Seat;
import csrs.demo.repository.SeatRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SeatService {
    private final SeatRepository seatRepository;

    public void save(Seat seat) {
        seatRepository.save(seat);
    }
}
