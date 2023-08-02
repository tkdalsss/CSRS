package csrs.demo.Repository.Admin;

import csrs.demo.Dto.Admin;

import java.util.Optional;

public interface AdminRepoCustom {
    Optional<Admin> findById(String id);
}
