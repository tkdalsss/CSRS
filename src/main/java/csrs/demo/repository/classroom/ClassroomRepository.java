package csrs.demo.repository.classroom;

import csrs.demo.dto.Classroom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClassroomRepository extends JpaRepository<Classroom, Long>, ClassroomRepoCustom {
}
