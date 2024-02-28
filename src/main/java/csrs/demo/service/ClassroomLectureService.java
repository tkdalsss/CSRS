package csrs.demo.service;

import csrs.demo.dto.ClassroomLecture;
import csrs.demo.repository.classroom.ClassroomLectureRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ClassroomLectureService {

    private final ClassroomLectureRepository clr;

    @Transactional
    public void save(ClassroomLecture cl) {
        clr.save(cl);
    }
}
