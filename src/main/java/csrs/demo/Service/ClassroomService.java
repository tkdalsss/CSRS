package csrs.demo.Service;

import csrs.demo.Dto.Classroom;
import csrs.demo.Repository.Classroom.ClassroomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ClassroomService {

    private final ClassroomRepository repository;

    @Transactional
    public void save(Classroom cr) {
        repository.save(cr);
    }

    public List<Classroom> classrooms() {
        return repository.classrooms();
    }

    public Classroom findById(int crNum) {
        return repository.findById(crNum);
    }
}
