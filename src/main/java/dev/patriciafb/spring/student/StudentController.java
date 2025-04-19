package dev.patriciafb.spring.student;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import dev.patriciafb.spring.academy.AcademyRepository;
import dev.patriciafb.spring.group.GroupRepository;
import dev.patriciafb.spring.teacher.TeacherRepository;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/students")
@CrossOrigin(origins = "*")
public class StudentController {

    @Autowired private StudentService service;
    @Autowired private AcademyRepository academyRepo;
    @Autowired private TeacherRepository teacherRepo;
    @Autowired private GroupRepository groupRepo;

    @GetMapping
    public List<StudentDto> getAll() {
        return service.getAllStudents()
                .stream()
                .map(StudentMapper::toDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public StudentDto getById(@PathVariable Long id) {
        return service.getStudentById(id)
                .map(StudentMapper::toDTO)
                .orElse(null);
    }

    @PostMapping
    public StudentDto create(@RequestBody StudentDto dto) {
        Student student = dtoToEntity(dto);
        return StudentMapper.toDTO(service.saveStudent(student));
    }

    @PutMapping("/{id}")
    public StudentDto update(@PathVariable Long id, @RequestBody StudentDto dto) {
        Student updated = dtoToEntity(dto);
        return StudentMapper.toDTO(service.updateStudent(id, updated));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.deleteStudent(id);
    }

    private Student dtoToEntity(StudentDto dto) {
        Student student = new Student();
        student.setId(dto.getId());
        student.setName(dto.getName());
        student.setSurname(dto.getSurname());
        if (dto.getLevel() == null || dto.getLevel().isBlank()) {
            throw new IllegalArgumentException("El campo 'level' no puede estar vacío");
        }
        
        try {
            student.setLevel(EnglishLevel.valueOf(dto.getLevel().toUpperCase()));
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("El valor '" + dto.getLevel() + "' no es un nivel válido. Usa: A1, A2, B1, B2, C1, C2.");
        }
        
        student.setHasAttendanceIssues(dto.isHasAttendanceIssues());

        student.setAcademy(dto.getAcademyId() != null ? academyRepo.findById(dto.getAcademyId()).orElse(null) : null);
        student.setTeacher(dto.getTeacherId() != null ? teacherRepo.findById(dto.getTeacherId()).orElse(null) : null);
        student.setGroup(dto.getGroupId() != null ? groupRepo.findById(dto.getGroupId()).orElse(null) : null);

        return student;
    }
}