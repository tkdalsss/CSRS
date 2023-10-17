package csrs.demo.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Admin {

    @Id
    @GeneratedValue
    private Long id;

    private String adminId;
    private String password;

    public static Admin createAdmin(String id, String password) {
        Admin admin = new Admin();
        admin.setAdminId(id);
        admin.setPassword(password);
        return admin;
    }
}
