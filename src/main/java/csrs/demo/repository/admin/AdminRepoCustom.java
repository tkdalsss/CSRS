package csrs.demo.repository.admin;

import csrs.demo.dto.Admin;

import java.util.Optional;

public interface AdminRepoCustom {
    Optional<Admin> findById(String id);
}
