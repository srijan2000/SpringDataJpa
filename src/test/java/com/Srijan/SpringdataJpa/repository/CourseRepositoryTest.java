package com.Srijan.SpringdataJpa.repository;

import com.Srijan.SpringdataJpa.entity.Course;
import com.Srijan.SpringdataJpa.entity.Student;
import com.Srijan.SpringdataJpa.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.awt.print.Pageable;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseRepositoryTest {

    @Autowired
    private CourseRepository courseRepository;
    @Test
    public void printCourses(){
        List<Course> courses = courseRepository.findAll();
        System.out.println("Courses = "+ courses);
    }

    @Test
    public void saveCourseWithTeacher(){

        Teacher teacher = Teacher.builder()
                .firstName("Priyanaka")
                .lastName("Singh")
                .build();

        Course course = Course.builder()
                .title("Python")
                .credit(6)
                .teacher(teacher)
                .build();

        courseRepository.save(course);

    }

   /* @Test
    public void findAllPagination(){
        Pageable firstPagewithThreeRecords =
                (Pageable) PageRequest.of(0,3);
        Pageable secondPageWithTwoRecords =
                (Pageable) PageRequest.of(1,2);
        List<Course> courses = courseRepository.findAll((org.springframework.data.domain.Pageable) firstPagewithThreeRecords)
                .getContent();

        Long totalElements = courseRepository.findAll((org.springframework.data.domain.Pageable) firstPagewithThreeRecords).getTotalElements();
        Long totalPages = Long.valueOf(courseRepository.findAll((org.springframework.data.domain.Pageable) firstPagewithThreeRecords)
                        .getTotalPages());
        System.out.println("Courses " + courses);

    }*/

    @Test
    public void saveCourseWithStudentAndTeacher(){
        Teacher teacher= Teacher.builder()
                .firstName("Lizze")
                .lastName("Stark")
                .build();
        Student student = Student.builder()
                .firstName("Abhishek")
                .lastName("Singh")
                .emailId("abhishek@gmail.com")
                .build();
        Course course = Course.builder()
                .title("AI")
                .credit(12)
                .teacher(teacher)
                .build();

        course.addStudents(student);

        courseRepository.save(course);

    }



}