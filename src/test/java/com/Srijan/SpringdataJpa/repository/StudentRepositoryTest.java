package com.Srijan.SpringdataJpa.repository;

import com.Srijan.SpringdataJpa.entity.Guardian;
import com.Srijan.SpringdataJpa.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest

class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void saveStudent(){
        Student student = Student.builder().emailId("srijan.veera@gmail.com")
                .firstName("srijan")
                .lastName("veerareddy")
                //.guardianName("Vinni")
                // .guardianEmail("vinni@gmail.com")
                // .guardianMobile("9999999999")
                 .build();

        studentRepository.save(student);

    }
    @Test
    public void saveStudentWithGuardian(){
        Guardian guardian = Guardian.builder()
                .email("nikhil@gmail.com")
                .name("Nikhil")
                .mobile("9999999999")
                .build();

        Student student = Student.builder()
                .firstName("Shivam")
                .emailId("shivam@gmail.com")
                .lastName("kumar")
                .guardian(guardian)
                .build();

        studentRepository.save(student);
    }
    @Test
    public void printAllStudent(){
        List<Student> studentList =
                studentRepository.findAll();
        System.out.println("Student List in database = "+ studentList);

    }

    @Test
    public void printStudentByFirstName(){
        List<Student> students = studentRepository.findByFirstName("shivam");
        System.out.println("students = " + students);

    }

    @Test
    public void printStudentsByFirstNameContaining(){
        List<Student> students = studentRepository.findByFirstNameContaining("s");
        System.out.println("Students = "+ students);
    }

    @Test
    public void printStudentBasedOnGuardianName(){

        List<Student> students = studentRepository.findByGuardianName("vinni");
        System.out.println("Students" + students);
    }

    @Test
    public void printStudentByEmailAddress(){
        String student = studentRepository.getStudentFirstNameByEmailAddress("srijan.veera@gmail.com");
        System.out.println("Student " + student);
    }
    @Test
    public void printStudentByEmailAddressByNative(){
        Student student = studentRepository.getStudentByEmailAddressNative("shivam@gmail.com");
        System.out.println("Student " + student);
    }

    @Test
    public void printgetStudentByEmailAddressNativeNamedParam(){
        Student student = studentRepository.getStudentByEmailAddressNativeNamedParam("shivam@gmail.com");
        System.out.println("Student = " + student);
    }
    @Test
    public void printgetStudentByFirstNameNativeNamedParam(){
        Student student = studentRepository.getStudentByFirstName("shivam");
        System.out.println("Student = " + student);
    }

    @Test
    public void printgetStudentByGuardianNativeNamedParam(){
        Student student = studentRepository.getStudentByGuardian("vinni");
        System.out.println("Student = "+ student);
    }

    @Test
    public void updateStudentNameByEmailId(){
        int student = studentRepository.updateStudentNameByEmailId("venkat",
                "srijan.veera@gmail.com");
        System.out.println("Student " + student );

    }
}