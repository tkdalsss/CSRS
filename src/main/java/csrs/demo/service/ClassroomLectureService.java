package csrs.demo.service;

import csrs.demo.dto.ClassroomLecture;
import csrs.demo.repository.classroom.ClassroomLectureRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClassroomLectureService {

    private final ClassroomLectureRepository repository;

    public void save(ClassroomLecture cl) {
        repository.save(cl);
    }

    public List<ClassroomLecture> findAll() {
        return repository.findAll();
    }
}
