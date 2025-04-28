package dev.patriciafb.spring.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    @Autowired private StudentRepository repository;

    public List<Student> getAllStudents() {
        return repository.findAll();
    }

    public Optional<Student> getStudentById(Long id) {
        return repository.findById(id);
    }

    public Student saveStudent(Student student) {
        return repository.save(student);
    }

    public Student updateStudent(Long id, Student updated) {
        return repository.findById(id).map(student -> {
            student.setName(updated.getName());
            student.setSurname(updated.getSurname());
            student.setLevel(updated.getLevel());
            student.setHasAttendanceIssues(updated.isHasAttendanceIssues());
            student.setAcademy(updated.getAcademy());
            student.setTeacher(updated.getTeacher());
            student.setGroup(updated.getGroup());
            return repository.save(student);
        }).orElse(null);
    }

    public void deleteStudent(Long id) {
        repository.deleteById(id);
    }
}