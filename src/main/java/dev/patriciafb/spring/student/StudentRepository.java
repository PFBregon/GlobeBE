package dev.patriciafb.spring.student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    Optional<Student> findByUsernameAndPassword(String username, String password);
    Optional<Student> findByUsername(String username); 
}
