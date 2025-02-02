package com.Srijan.SpringdataJpa.repository;

import com.Srijan.SpringdataJpa.entity.Course;
import com.Srijan.SpringdataJpa.entity.CourseMaterial;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseMaterialRepositoryTest {



    @Autowired
    private CourseMaterialRepository repository;

    @Test
    public void SaveCourseMaterial(){
        Course course = Course.builder().title(".net").credit(5).build();

        CourseMaterial courseMaterial = CourseMaterial.builder().url("www.dailycodebuffer.com")
                .course(course)
                .build();
        repository.save(courseMaterial);
    }
    @Test
    public void printAllCourseMaterils(){
        List<CourseMaterial> courseMaterials = repository.findAll();
        System.out.println("Course Materials = " + courseMaterials);

    }

}