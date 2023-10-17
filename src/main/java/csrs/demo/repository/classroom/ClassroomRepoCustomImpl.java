package csrs.demo.repository.classroom;

import com.querydsl.jpa.impl.JPAQueryFactory;
import csrs.demo.dto.Classroom;
import lombok.RequiredArgsConstructor;

import java.util.List;

import static csrs.demo.dto.QClassroom.*;

@RequiredArgsConstructor
public class ClassroomRepoCustomImpl implements ClassroomRepoCustom {

    private final JPAQueryFactory factory;

    @Override
    public List<Classroom> classrooms() {
        return factory.selectFrom(classroom)
                .fetch();
    }

    @Override
    public Classroom findById(int num) {
        return factory.selectFrom(classroom)
                .where(classroom.crNum.eq(num))
                .fetchOne();
    }
}
