package csrs.demo.repository.student;

import com.querydsl.jpa.impl.JPAQueryFactory;
import csrs.demo.dto.StudentLecture;
import lombok.RequiredArgsConstructor;

import java.util.List;

import static csrs.demo.dto.QStudentLecture.studentLecture;

@RequiredArgsConstructor
public class StudentLectureCustomRepoImpl implements StudentLectureCustomRepo {

    private final JPAQueryFactory factory;

    @Override
    public List<StudentLecture> findEach(String studentId) {
        return factory.selectFrom(studentLecture)
                .where(studentLecture.student.studentId.eq(studentId))
                .fetch();
    }
}
