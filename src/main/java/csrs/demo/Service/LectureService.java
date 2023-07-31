package csrs.demo.Service;

import csrs.demo.Dto.Lecture;
import csrs.demo.Repository.LectureRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LectureService {

    private final LectureRepository repository;

    public void save(Lecture lr){
        repository.save(lr);
    }
}
