package csrs.demo.Service;

import csrs.demo.Dto.Classroom;
import csrs.demo.Repository.Classroom.ClassroomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClassroomService {

    private final ClassroomRepository repository;

    public void save(Classroom cr){
        repository.save(cr);
    }

    public List<Classroom> classrooms(){
        return repository.classrooms();
    }
}
