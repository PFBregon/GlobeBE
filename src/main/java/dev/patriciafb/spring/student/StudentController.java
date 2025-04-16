package dev.patriciafb.spring.student;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/students")
@CrossOrigin(origins = "*")
public class StudentController {

    private final StudentService service;

    @Autowired
    public StudentController(StudentService service) {
        this.service = service;
    }

    @GetMapping
    public List<StudentDto> getAllStudents() {
        return service.getAllStudents()
                .stream()
                .map(StudentMapper::toDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public StudentDto getStudent(@PathVariable Long id) {
        return service.getStudentById(id)
                .map(StudentMapper::toDTO)
                .orElse(null);
    }

    @PostMapping
    public StudentDto createStudent(@RequestBody StudentDto dto) {
        Student saved = service.saveStudent(StudentMapper.toEntity(dto));
        return StudentMapper.toDTO(saved);
    }

    @PutMapping("/{id}")
    public StudentDto updateStudent(@PathVariable Long id, @RequestBody StudentDto dto) {
        Student updated = service.updateStudent(id, StudentMapper.toEntity(dto));
        return StudentMapper.toDTO(updated);
    }

    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable Long id) {
        service.deleteStudent(id);
    }
}
