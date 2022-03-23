package com.rwoo.rwdatabasedemo.jpa;

import com.rwoo.rwdatabasedemo.entity.Course;
import com.rwoo.rwdatabasedemo.entity.Passport;
import com.rwoo.rwdatabasedemo.entity.Person;
import com.rwoo.rwdatabasedemo.entity.Student;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class StudentRepository {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    EntityManager entityManager;

    public List<Student> findAll() {
        TypedQuery<Student> query = entityManager.createQuery("Select S From Student S", Student.class);
        return query.getResultList();
    }

    public Student findById(Long id){
        return entityManager.find(Student.class, id);
    }

    public void delete(Student student){
        entityManager.remove(student);
    }

    public void deleteById(Long id){
        Student student = findById(id);
        delete(student);
    }

    public Student save(Student student){
        if (student.getId() == null){
            entityManager.persist(student);
        } else {
            entityManager.merge(student);
        }
        return  student;
    }

    public void saveStudentWithPassport(){
        Passport passport = new Passport("G12345");
        entityManager.persist(passport);
        Student student = new Student("Mike");
        student.setPassport(passport);
        entityManager.persist(student);
    }

    public Student getStudent() {
        Student student = entityManager.find(Student.class, 20001L);
        Passport passport = student.getPassport();
        passport.setNumber("H12345");
        student.setName("Updated");
        return student;
    }

    public void insertStudentAndCourse(Student student, Course course){

        student.addCourse(course);
        course.addStudent(student);

        entityManager.persist(student);
        entityManager.persist(course);
    }

    public void insertStudentAndCourseHardCode(){
        Student student = new Student("Jack");
        Course course = new Course("Micro Service");
//        entityManager.persist(student);
//        entityManager.persist(course);

        student.addCourse(course);
        course.addStudent(student);

        entityManager.persist(student);
        entityManager.persist(course);
    }

    public void playWithEM(){
//        logger.info("Play with EM");
//        Student student = new Student("History");
//        entityManager.persist(student);
//
//        Student student2 = new Student("Geometry");
//        entityManager.persist(student2);


    }
}
