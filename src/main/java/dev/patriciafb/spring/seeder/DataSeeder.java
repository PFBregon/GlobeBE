package dev.patriciafb.spring.seeder;

import dev.patriciafb.spring.academy.Academy;
import dev.patriciafb.spring.academy.AcademyRepository;
import dev.patriciafb.spring.group.Group;
import dev.patriciafb.spring.group.GroupRepository;
import dev.patriciafb.spring.student.EnglishLevel;
import dev.patriciafb.spring.student.Student;
import dev.patriciafb.spring.student.StudentRepository;
import dev.patriciafb.spring.teacher.Teacher;
import dev.patriciafb.spring.teacher.TeacherRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

@Component
public class DataSeeder {

    private final AcademyRepository academyRepo;
    private final TeacherRepository teacherRepo;
    private final GroupRepository groupRepo;
    private final StudentRepository studentRepo;

    public DataSeeder(AcademyRepository academyRepo,
                      TeacherRepository teacherRepo,
                      GroupRepository groupRepo,
                      StudentRepository studentRepo) {
        this.academyRepo = academyRepo;
        this.teacherRepo = teacherRepo;
        this.groupRepo = groupRepo;
        this.studentRepo = studentRepo;
    }

    @PostConstruct
public void seedData() {

    Academy a1 = academyRepo.save(new Academy(null, "La Calzada"));
    Academy a2 = academyRepo.save(new Academy(null, "El Llano"));

    Teacher t1 = teacherRepo.save(new Teacher(null, "Nadia"));
    Teacher t2 = teacherRepo.save(new Teacher(null, "Sabrina"));
    Teacher t3 = teacherRepo.save(new Teacher(null, "Vanessa"));
    Teacher t4 = teacherRepo.save(new Teacher(null, "Erik"));

    Group g1 = groupRepo.save(new Group(null, "Group A"));
    Group g2 = groupRepo.save(new Group(null, "Group B"));
    Group g3 = groupRepo.save(new Group(null, "Group C"));
    Group g4 = groupRepo.save(new Group(null, "Group D"));


    Student s1 = new Student(null, "Patricia", "Fernández Bregón", EnglishLevel.B2, false, a1, t1, g1);
    s1.setUsername("patricia");
    s1.setPassword("1234");
    studentRepo.save(s1);

    Student s2 = new Student(null, "Ana", "Martínez", EnglishLevel.C1, false, a2, t2, g2);
    s2.setUsername("ana");
    s2.setPassword("abcd");
    studentRepo.save(s2);

    Student s3 = new Student(null, "Mario", "López", EnglishLevel.A2, true, a2, t3, g3);
    s3.setUsername("mario");
    s3.setPassword("qwerty");
    studentRepo.save(s3);

    Student s4 = new Student(null, "Lucía", "García", EnglishLevel.C2, false, a1, t4, g4);
    s4.setUsername("lucia");
    s4.setPassword("1234");
    studentRepo.save(s4);
}
}