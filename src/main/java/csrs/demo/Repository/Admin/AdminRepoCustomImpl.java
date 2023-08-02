package csrs.demo.Repository.Admin;

import com.querydsl.jpa.impl.JPAQueryFactory;
import csrs.demo.Dto.Admin;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

import static csrs.demo.Dto.QAdmin.*;

@Repository
@RequiredArgsConstructor
public class AdminRepoCustomImpl implements AdminRepoCustom {

    private final JPAQueryFactory factory;

    @Override
    public Optional<Admin> findById(String id) {
        return factory.selectFrom(admin).where(admin.adminId.eq(id)).stream().findAny();
    }
}
