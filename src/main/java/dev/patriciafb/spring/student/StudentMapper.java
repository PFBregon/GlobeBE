package dev.patriciafb.spring.student;

public class StudentMapper {
    public static StudentDto toDTO(Student student) {
        StudentDto dto = new StudentDto();
        dto.setId(student.getId());
        dto.setName(student.getName());
        dto.setSurname(student.getSurname());
        dto.setUsername(student.getUsername());
        dto.setPassword(student.getPassword());
        dto.setLevel(student.getLevel() != null ? student.getLevel().name() : null);
        dto.setHasAttendanceIssues(student.isHasAttendanceIssues());

        if (student.getAcademy() != null) {
            dto.setAcademyId(student.getAcademy().getId());
            dto.setAcademyName(student.getAcademy().getName());
        }

        if (student.getTeacher() != null) {
            dto.setTeacherId(student.getTeacher().getId());
            dto.setTeacherName(student.getTeacher().getName());
        }

        if (student.getGroup() != null) {
            dto.setGroupId(student.getGroup().getId());
            dto.setGroupName(student.getGroup().getName());
        }

        return dto;
    }
}