package dev.patriciafb.spring.group;

import jakarta.persistence.*;
import java.util.List; 
import dev.patriciafb.spring.student.Student;

@Entity
@Table(name = "groups") 
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String schedule;

    @OneToMany(mappedBy = "group")
    private List<Student> students;

    public Group() {}

    public Group(Long id, String name, String schedule) {
        this.id = id;
        this.name = name;
        this.schedule = schedule;
    }

    public Long getId() { return id; }
    public String getName() { return name; }
    public String getSchedule() { return schedule; }

    public void setId(Long id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setSchedule(String schedule) { this.schedule = schedule; }
}
