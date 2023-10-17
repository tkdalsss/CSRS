package csrs.demo.service;

import csrs.demo.dto.StudentLecture;
import csrs.demo.repository.student.StudentLectureRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class StudentLectureService {

    private final StudentLectureRepository repository;

    @Transactional
    public void save(StudentLecture sl) {
        repository.save(sl);
    }

    public Boolean findExists(String studentId) {
        return repository.findEach(studentId) != null;
    }
}
