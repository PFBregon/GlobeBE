package dev.patriciafb.spring.teacher;

import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TeacherService {
    private final TeacherRepository repository;

    public TeacherService(TeacherRepository repository) {
        this.repository = repository;
    }

    public List<Teacher> findAll() {
        return repository.findAll();
    }

    public Teacher save(Teacher academy) {
        return repository.save(academy);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
