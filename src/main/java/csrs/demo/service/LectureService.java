package csrs.demo.service;

import csrs.demo.dto.Lecture;
import csrs.demo.repository.LectureRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class LectureService {

    private final LectureRepository repository;

    @Transactional
    public void save(Lecture lr) {
        repository.save(lr);
    }

    public List<Lecture> getList() {
        return repository.findAll();
    }

    public Lecture findById(Long id) {
        return repository.findById(id).orElse(null);
    }
}
