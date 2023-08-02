package csrs.demo.Dto;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Classroom {

    @Id
    @GeneratedValue
    private Long id;

    private int crNum; // 강의실 이름 ex) 3183
    private String crName; // 강의실 번호 ex) 401-3183

    // 자리
//    @OneToMany(mappedBy = "classroom", fetch = FetchType.LAZY)
//    private List<Seat> seats = new ArrayList<>();

    // 수업
//    @OneToMany(mappedBy = "classroom", fetch = FetchType.LAZY)
//    private List<Lecture> lectures = new ArrayList<>();

    public static Classroom createClassroom(int crNum, String crName) {
        Classroom cr = new Classroom();
        cr.setCrNum(crNum);
        cr.setCrName(crName);
        return cr;
    }

}
