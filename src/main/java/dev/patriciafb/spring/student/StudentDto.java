package dev.patriciafb.spring.student;

public class StudentDto {

    private Long id;
    private String name;
    private String surname;
    private String groupName;
    private String attendance;
    private String teacher;
    private String academy;

    public StudentDto() {}

    public StudentDto(Long id, String name, String surname, String groupName, String attendance, String teacher, String academy) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.groupName = groupName;
        this.attendance = attendance;
        this.teacher = teacher;
        this.academy = academy;
    }

    public Long getId() { return id; }
    public String getName() { return name; }
    public String getSurname() { return surname; }
    public String getGroupName() { return groupName; }
    public String getAttendance() { return attendance; }
    public String getTeacher() { return teacher; }
    public String getAcademy() { return academy; }


    public void setId(Long id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setSurname(String surname) { this.surname = surname; }
    public void setGroupName(String groupName) { this.groupName = groupName; }
    public void setAttendance(String attendance) { this.attendance = attendance; }
    public void setTeacher(String teacher) { this.teacher = teacher; }
    public void setAcademy(String academy) { this.academy = academy; }
}
