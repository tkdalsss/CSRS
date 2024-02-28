package csrs.demo.service;

import csrs.demo.dto.Classroom;
import csrs.demo.repository.classroom.ClassroomRepository;
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

    public Classroom findById(String crName) {
        return repository.findById(crName);
    }
}
