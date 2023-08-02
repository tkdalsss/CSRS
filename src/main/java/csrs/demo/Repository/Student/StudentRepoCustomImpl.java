package csrs.demo.Repository.Student;

import com.querydsl.jpa.impl.JPAQueryFactory;
import csrs.demo.Dto.Student;
import csrs.demo.Repository.Student.StudentRepoCustom;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

import static csrs.demo.Dto.QStudent.*;

@RequiredArgsConstructor
public class StudentRepoCustomImpl implements StudentRepoCustom {

    private final JPAQueryFactory factory;

    @Override
    public Student findById(String studentId) {
        return factory.selectFrom(student)
                .where(student.studentId.eq(studentId))
                .fetchOne();
    }

    @Override
    public Optional<Student> findByLoginId(String studentId) {
        return factory.selectFrom(student)
                .where(student.studentId.eq(studentId))
                .stream().findAny();
    }
}
