package com.rwoo.test.rwdatabasedemo.jpa;

import com.rwoo.rwdatabasedemo.RwDatabaseJpaDemoApplication;
import com.rwoo.rwdatabasedemo.entity.Course;
import com.rwoo.rwdatabasedemo.entity.Passport;
import com.rwoo.rwdatabasedemo.entity.Student;
import com.rwoo.rwdatabasedemo.jpa.StudentRepository;
import org.junit.jupiter.api.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import java.util.List;

import static org.testng.Assert.*;

/**
 * Entity Manager talks to Persist Context
 *
 * Hibernate uses Session and Session Manager
 *
 */
@SpringBootTest(classes= RwDatabaseJpaDemoApplication.class)
public class StudentRepositoryTest {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    EntityManager em;

    @Test
    @Transactional
    public void retrieveStudentAndPassport_Test(){
        Student student = em.find(Student.class, 20001L);
        student.getPassport();
//        logger.info("student -> ");
        logger.info("student -> {}", student);
        logger.info("student/passport -> {}", student.getPassport());
    }

    @Test
    @Transactional
    public void retrievePassportAndStudent_Test(){
        Passport passport = em.find(Passport.class, 40001L);
//        passport.getStudent();
//        logger.info("student -> ");
        logger.info("passport -> {}", passport);
        logger.info("passport/student -> {}", passport.getStudent());
    }

    @Test
    @Transactional  // Using entity manger.  If using a repository, the repository usually uses a transactional
    public void some_Test(){
        Student student = em.find(Student.class, 20001L);
        Passport passport = student.getPassport();
        passport.setNumber("H12345");
        student.setName("Updated");

        logger.info("student -> ");
//        logger.info("student -> {}", student);
        logger.info("student/passport -> {}", student.getPassport());
    }

    @Test
    @Transactional  // Using entity manger.  If using a repository, the repository usually uses a transactional
    public void retrieveStudentAndCourse(){
        Student student = em.find(Student.class, 20001L);
        logger.info("student -> {}", student);
        logger.info("student/course -> {}", student.getCourses());
    }


    @Test
    public void getStudent() {
        studentRepository.getStudent();

        TypedQuery<Student> query = em.createQuery("Select S From Student S", Student.class);
        List<Student>  results = query.getResultList();

        logger.info("Select S From student S-> {}", results);

        results =  studentRepository.findAll();


        logger.info("all student -> {}", results);
//        logger.info("student 200001-> {}", em.find(Student.class, 20001L));

    }

//
//    public List<Student> findAll() {
//        TypedQuery<Student> query = entityManager.createQuery("Select S From Student S", Student.class);
//        return query.getResultList();
//    }


    @Test
    public void getAllStudent() {

        TypedQuery<Student> query = em.createQuery("Select S From Student S", Student.class);
        List<Student>  results = query.getResultList();

        logger.info("Select S From student S-> {}", results);

    }

//    @Test
//    @DirtiesContext
//    public void playWithEM_Test(){
//        studentRepository.playWithEM();
//    }
}
