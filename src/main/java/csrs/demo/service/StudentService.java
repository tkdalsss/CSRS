package csrs.demo.service;

import csrs.demo.dto.Student;
import csrs.demo.repository.student.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class StudentService {

    private final StudentRepository repository;

    @Transactional
    public void save(Student student) {
        repository.save(student);
    }

    public Student login(String studentId, String password) {
        return repository.findByLoginId(studentId)
                .filter(s -> s.getPassword().equals(password))
                .orElse(null);
    }

    public Student findById(String studentId) {
        return repository.findById(studentId);
    }
}
