package dev.patriciafb.spring.student;

public class StudentMapper {

    public static StudentDto toDTO(Student student) {
        return new StudentDto(
                student.getId(),
                student.getName(),
                student.getSurname(),
                student.getLevel().name(),
                student.isHasAttendanceIssues(),
                student.getAcademy() != null ? student.getAcademy().getId() : null,
                student.getTeacher() != null ? student.getTeacher().getId() : null,
                student.getGroup() != null ? student.getGroup().getId() : null
        );
    }
}

