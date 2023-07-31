package csrs.demo.Service;

import csrs.demo.Repository.AdminRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AdminService {

    private final AdminRepository repository;

    public boolean findById(String id){
        return repository.findById(id);
    }
}
