package csrs.demo.Repository.Student;

import csrs.demo.Dto.StudentLecture;

import java.util.List;

public interface StudentLectureCustomRepo {
    List<StudentLecture> findEach(String studentId);
}
