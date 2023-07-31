package csrs.demo.Repository.Classroom;

import com.querydsl.jpa.impl.JPAQueryFactory;
import csrs.demo.Dto.Classroom;
import csrs.demo.Dto.QClassroom;
import csrs.demo.Repository.Classroom.ClassroomRepoCustom;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class ClassroomRepoCustomImpl implements ClassroomRepoCustom {

    private final JPAQueryFactory factory;

    @Override
    public List<Classroom> classrooms() {
        return factory.selectFrom(QClassroom.classroom)
                .fetch();
    }
}
