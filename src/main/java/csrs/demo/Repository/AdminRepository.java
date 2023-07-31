package csrs.demo.Repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import static csrs.demo.Dto.QAdmin.*;

@Repository
@RequiredArgsConstructor
public class AdminRepository {

    private final JPAQueryFactory factory;

    public boolean findById(String id) {
        return factory.selectFrom(admin).where(admin.adminId.eq(id)) != null;
    }
}
