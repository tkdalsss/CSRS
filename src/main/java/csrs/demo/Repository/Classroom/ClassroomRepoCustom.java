package csrs.demo.Repository.Classroom;

import csrs.demo.Dto.Classroom;

import java.util.List;

public interface ClassroomRepoCustom {
    List<Classroom> classrooms();

    Classroom findById(int num);
}
