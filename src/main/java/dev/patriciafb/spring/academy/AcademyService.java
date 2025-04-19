package dev.patriciafb.spring.academy;

import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AcademyService {
    private final AcademyRepository repository;

    public AcademyService(AcademyRepository repository) {
        this.repository = repository;
    }

    public List<Academy> findAll() {
        return repository.findAll();
    }

    public Academy save(Academy academy) {
        return repository.save(academy);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
