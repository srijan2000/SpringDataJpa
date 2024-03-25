package com.Srijan.SpringdataJpa.repository;

import com.Srijan.SpringdataJpa.entity.Course;
import com.Srijan.SpringdataJpa.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TeacherRepositoryTest {
    @Autowired
    private TeacherRepository teacherRepository;

    @Test
    public void saveTeacher(){
        Course course = Course.builder().title("Cricket")
                .credit(1)
                .build();
        Course courseJenkins = Course.builder().title("Jenkins")
                .credit(3)
                .build();


        Teacher teacher = Teacher.builder().
                firstName("Sachin").
                lastName("Tendulkar")
               // .courses(List.of(course, courseJenkins))
                .build();

        teacherRepository.save(teacher);

    }

}