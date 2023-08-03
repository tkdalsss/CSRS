package csrs.demo.Service;

import csrs.demo.Dto.ClassroomLecture;
import csrs.demo.Repository.Classroom.ClassroomLectureRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ClassroomLectureService {

    private final ClassroomLectureRepository repository;

    public void save(ClassroomLecture cl) {
        repository.save(cl);
    }
}
