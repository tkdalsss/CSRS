package csrs.demo.Repository.Classroom;

import csrs.demo.Dto.Classroom;
import csrs.demo.Repository.Classroom.ClassroomRepoCustom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClassroomRepository extends JpaRepository<Classroom, Long>, ClassroomRepoCustom {
}
