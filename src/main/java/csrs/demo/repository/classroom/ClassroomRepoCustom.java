package csrs.demo.repository.classroom;

import csrs.demo.dto.Classroom;

import java.util.List;

public interface ClassroomRepoCustom {
    List<Classroom> classrooms();

    Classroom findById(String name);
}
