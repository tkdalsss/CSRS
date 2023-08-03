package csrs.demo.Repository.Student;

import com.querydsl.jpa.impl.JPAQueryFactory;
import csrs.demo.Dto.QStudentLecture;
import csrs.demo.Dto.StudentLecture;
import lombok.RequiredArgsConstructor;

import java.util.List;

import static csrs.demo.Dto.QStudentLecture.studentLecture;

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
