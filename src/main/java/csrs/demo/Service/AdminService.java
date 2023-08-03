package csrs.demo.Service;

import csrs.demo.Dto.Admin;
import csrs.demo.Repository.Admin.AdminRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class AdminService {

    private final AdminRepository repository;

//    public boolean findById(String id){
//        return repository.findById(id);
//    }

    public Admin loginAdmin(String id, String password) {
        return repository.findById(id)
                .filter(s -> s.getPassword().equals(password))
                .orElse(null);
    }
}
