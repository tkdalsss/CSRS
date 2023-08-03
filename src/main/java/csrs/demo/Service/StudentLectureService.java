package csrs.demo.Service;

import csrs.demo.Dto.StudentLecture;
import csrs.demo.Repository.Student.StudentLectureRepository;
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
