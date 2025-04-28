package dev.patriciafb.spring.teacher;

import jakarta.persistence.*;

@Entity
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    public Teacher() {}

    public Teacher(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() { return id;}

    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getFullName() { return this.name; }
    
    public void setFullName(String fullName) { this.name = fullName; }
}