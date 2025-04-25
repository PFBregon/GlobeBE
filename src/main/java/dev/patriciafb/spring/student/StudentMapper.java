package dev.patriciafb.spring.student;

public class StudentMapper {
    public static StudentDto toDTO(Student student) {
        StudentDto dto = new StudentDto();
        dto.setId(student.getId());
        dto.setName(student.getName());
        dto.setSurname(student.getSurname());
        dto.setUsername(student.getUsername());
        dto.setPassword(student.getPassword());
        dto.setLevel(student.getLevel().name());
        dto.setHasAttendanceIssues(student.isHasAttendanceIssues());
        dto.setAcademyId(student.getAcademy() != null ? student.getAcademy().getId() : null);
        dto.setTeacherId(student.getTeacher() != null ? student.getTeacher().getId() : null);
        dto.setGroupId(student.getGroup() != null ? student.getGroup().getId() : null);
        return dto;
    }
}

