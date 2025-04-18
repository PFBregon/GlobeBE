package dev.patriciafb.spring.student;

import dev.patriciafb.spring.academy.Academy;
import dev.patriciafb.spring.teacher.Teacher;
import dev.patriciafb.spring.group.Group;
import jakarta.persistence.*;

@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String surname;
    
    @Enumerated(EnumType.STRING)
    private EnglishLevel level;

    private boolean hasAttendanceIssues;

    @ManyToOne
    @JoinColumn(name = "academy_id")
    private Academy academy;

    @ManyToOne
    @JoinColumn(name = "teacher_id")
    private Teacher teacher;

    @ManyToOne
    @JoinColumn(name = "group_id")
    private Group group;

    public Student() {}

    public Student(Long id, String name, String surname, EnglishLevel level, boolean hasAttendanceIssues, Academy academy, Teacher teacher, Group group) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.level = level;
        this.hasAttendanceIssues = hasAttendanceIssues;
        this.academy = academy;
        this.teacher = teacher;
        this.group = group;
    }

    public Long getId() { return id; }
    public String getName() { return name; }
    public String getSurname() { return surname; }
    public EnglishLevel getLevel() { return level; }
    public boolean isHasAttendanceIssues() { return hasAttendanceIssues; }
    public Academy getAcademy() { return academy; }
    public Teacher getTeacher() { return teacher; }
    public Group getGroup() { return group; }

    public void setId(Long id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setSurname(String surname) { this.surname = surname; }
    public void setLevel(EnglishLevel level) { this.level = level; }
    public void setHasAttendanceIssues(boolean hasAttendanceIssues) { this.hasAttendanceIssues = hasAttendanceIssues; }
    public void setAcademy(Academy academy) { this.academy = academy; }
    public void setTeacher(Teacher teacher) { this.teacher = teacher; }
    public void setGroup(Group group) { this.group = group; }
}
