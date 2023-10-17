package csrs.demo.repository.admin;

import csrs.demo.dto.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin, Long>, AdminRepoCustom {
}
