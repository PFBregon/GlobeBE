package dev.patriciafb.spring.student;

public class StudentDto {

    private Long id;
    private String name;
    private String surname;
    private String username;
    private String password;
    private String level; 
    private boolean hasAttendanceIssues;

    private Long academyId;
    private Long teacherId;
    private Long groupId;

    public StudentDto() {}

    public StudentDto(Long id, String name, String surname, String username, String password, String level, boolean hasAttendanceIssues,
    Long academyId, Long teacherId, Long groupId) {
    this.id = id;
    this.name = name;
    this.surname = surname;
    this.username = username;
    this.password = password;
    this.level = level;
    this.hasAttendanceIssues = hasAttendanceIssues;
    this.academyId = academyId;
    this.teacherId = teacherId;
    this.groupId = groupId;
    }

    public Long getId() { return id; }
    public String getName() { return name; }
    public String getSurname() { return surname; }
    public String getUsername() { return username; }
    public String getPassword() { return password; }
    public String getLevel() { return level; }
    public boolean isHasAttendanceIssues() { return hasAttendanceIssues; }
    public Long getAcademyId() { return academyId; }
    public Long getTeacherId() { return teacherId; }
    public Long getGroupId() { return groupId; }


    public void setId(Long id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setSurname(String surname) { this.surname = surname; }
    public void setUsername(String username) { this.username = username; }
    public void setPassword(String password) { this.password = password; }
    public void setLevel(String level) { this.level = level; }
    public void setHasAttendanceIssues(boolean hasAttendanceIssues) { this.hasAttendanceIssues = hasAttendanceIssues; }
    public void setAcademyId(Long academyId) { this.academyId = academyId; }
    public void setTeacherId(Long teacherId) { this.teacherId = teacherId; }
    public void setGroupId(Long groupId) { this.groupId = groupId;
}
}