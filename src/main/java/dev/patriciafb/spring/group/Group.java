package dev.patriciafb.spring.group;

import jakarta.persistence.*;

@Entity
@Table(name = "groups") 
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String schedule;

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
