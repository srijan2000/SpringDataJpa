package com.Srijan.SpringdataJpa.repository;

import com.Srijan.SpringdataJpa.entity.Student;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {

    //we want to retrieve the students by name

    public List<Student> findByFirstName(String firstName);

    List<Student> findByFirstNameContaining(String name);

    List<Student> findByLastNameNotNull();

    List<Student> findByGuardianName(String guardianName);

    Student findByFirstNameAndLastName(String firstName, String lastName);

    //JPQL
    @Query("Select s.firstName from Student s where s.emailId = ?1")
    String getStudentFirstNameByEmailAddress(String EmailId);

    @Query (
            value = "select * from tbl_student s where s.email_address = ?1 ",
            nativeQuery = true
    )
    Student getStudentByEmailAddressNative(String emailId);

    //Native Named Param
    @Query(
            value = "Select * From tbl_student s where s.email_address = :emailId",
            nativeQuery = true
    )
    Student getStudentByEmailAddressNativeNamedParam(
            @Param("emailId") String emailId
    );

    @Query(
            value = "Select * from tbl_student s where s.first_name = :firstName",
            nativeQuery = true
    )
    Student getStudentByFirstName( @Param("firstName") String firstName);

    /*@Query(
            value = "Select * from tbl_student s where s.guardian_name = :GuardianfirstName",
            nativeQuery = true
    )
    Student getStudentByGuardianName(@Param("GuardianfirstName") String guardianName);*/

    @Query(
            value = "select * from tbl_student s where s.guardian_name = :guardianName",
            nativeQuery = true
    )
    Student getStudentByGuardian(@Param("guardianName")String guardianName);

    // All the above queries are used to fetch data from the table


    @Modifying
    @Transactional
    @Query(
            value = " update tbl_student set first_name = ?1 where email_address = ?2",
            nativeQuery = true
    )
    //Modifying queries can only use void or int/Integer as return type
    int updateStudentNameByEmailId(String firstName, String lastName);





}
