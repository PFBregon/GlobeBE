package dev.patriciafb.spring.teacher;

import jakarta.persistence.*;
import java.util.List;
import dev.patriciafb.spring.student.Student;

@Entity
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String surname;

    @OneToMany(mappedBy = "teacher")
    private List<Student> students;

    public Teacher() {}

    public Teacher(Long id, String name, String surname) {
        this.id = id;
        this.name = name;
        this.surname = surname;
    }

    public Long getId() { return id; }
    public String getName() { return name; }
    public String getSurname() { return surname; }

    public void setId(Long id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setSurname(String surname) { this.surname = surname; }
}
