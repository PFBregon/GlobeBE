package dev.patriciafb.spring.student;


public class StudentMapper {

    public static StudentDto toDTO(Student student) {
        return new StudentDto(
                student.getId(),
                student.getName(),
                student.getSurname(),
                student.getGroupName(),
                student.getAttendance(),
                student.getTeacher(),
                student.getAcademy()
        );
    }

    public static Student toEntity(StudentDto dto) {
        return new Student(
                dto.getId(),
                dto.getName(),
                dto.getSurname(),
                dto.getGroupName(),
                dto.getAttendance(),
                dto.getTeacher(),
                dto.getAcademy()
        );
    }
}
