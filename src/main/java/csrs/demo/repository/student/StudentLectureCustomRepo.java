package csrs.demo.repository.student;

import csrs.demo.dto.StudentLecture;

import java.util.List;

public interface StudentLectureCustomRepo {
    List<StudentLecture> findEach(String studentId);
}
