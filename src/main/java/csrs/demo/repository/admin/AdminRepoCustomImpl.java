package csrs.demo.repository.admin;

import com.querydsl.jpa.impl.JPAQueryFactory;
import csrs.demo.dto.Admin;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

import static csrs.demo.dto.QAdmin.*;

@Repository
@RequiredArgsConstructor
public class AdminRepoCustomImpl implements AdminRepoCustom {

    private final JPAQueryFactory factory;

    @Override
    public Optional<Admin> findById(String id) {
        return factory.selectFrom(admin).where(admin.adminId.eq(id)).stream().findAny();
    }
}
