package csrs.demo.service;

import csrs.demo.dto.StudentLecture;
import csrs.demo.repository.StudentLectureRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class StudentLectureService {
    private final StudentLectureRepository studentLectureRepository;

    @Transactional
    public void save(StudentLecture studentLecture) {
        studentLectureRepository.save(studentLecture);
    }
}
