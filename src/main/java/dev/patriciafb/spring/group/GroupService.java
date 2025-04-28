package dev.patriciafb.spring.group;

import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class GroupService {
    private final GroupRepository repository;

    public GroupService(GroupRepository repository) {
        this.repository = repository;
    }

    public List<Group> findAll() {
        return repository.findAll();
    }

    public Group save(Group academy) {
        return repository.save(academy);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
