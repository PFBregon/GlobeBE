package dev.patriciafb.spring.student;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    // Aquí podrías añadir métodos personalizados, si los necesitas
}
