package csrs.demo.Service;

import csrs.demo.Dto.Student;
import csrs.demo.Repository.Student.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository repository;

    public void save(Student student){
        repository.save(student);
    }

    public Student login(String studentId, String password){
        return repository.findByLoginId(studentId)
                .filter(s -> s.getPassword().equals(password))
                .orElse(null);
    }
}
