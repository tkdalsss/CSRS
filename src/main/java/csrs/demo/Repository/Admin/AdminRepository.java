package csrs.demo.Repository.Admin;

import csrs.demo.Dto.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin, Long>, AdminRepoCustom {
}
