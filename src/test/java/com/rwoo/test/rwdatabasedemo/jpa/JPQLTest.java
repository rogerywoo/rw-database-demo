package com.rwoo.test.rwdatabasedemo.jpa;

import com.rwoo.rwdatabasedemo.RwDatabaseJpaDemoApplication;
import com.rwoo.rwdatabasedemo.entity.Course;
import com.rwoo.rwdatabasedemo.jpa.CourseRepository;
import org.junit.jupiter.api.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import java.util.List;

import static org.testng.Assert.*;

@SpringBootTest(classes= RwDatabaseJpaDemoApplication.class)
public class JPQLTest {
    private Logger log = LoggerFactory.getLogger(this.getClass());
    @Autowired
    EntityManager em;


    @Test
    public void find_Test(){
        TypedQuery<Course> query = em.createNamedQuery("query_get_all_courses", Course.class);
        List<Course> results = query.getResultList();
        log.info("Select c From Course c -> {}", results);

//        TypedQuery<Course> query = em.createQuery("Select c From Course c", Course.class);
//        List<Course> results = query.getResultList();
//        log.info("Select c From Course c -> {}", results);
    }

    @Test
    public void findWhere_Test(){
        TypedQuery<Course> query = em.createNamedQuery("query_get_100", Course.class);
        List<Course> results = query.getResultList();
        log.info("Select c From Course c -> {}", results);

//        TypedQuery<Course> query = em.createQuery("Select c From Course c where name like 'G%'", Course.class);
//        List<Course> results = query.getResultList();
//        log.info("Select c From Course c -> {}", results);
    }

    @Test
    public void findCoursesWithoutSudents(){
        TypedQuery<Course> query = em.createQuery("Select C from Course C where C.students is empty", Course.class);
        List<Course> results = query.getResultList();
        log.info("Select c From Course c -> {}", results);

    }

    @Test
    public void findCoursesWithAtLeast2Sudents(){
        TypedQuery<Course> query = em.createQuery("Select C from Course C where size(C.students) > 2", Course.class);
        List<Course> results = query.getResultList();
        log.info("Select c From Course c -> {}", results);

    }

    @Test
    public void findCoursesOrderBySudents(){
        TypedQuery<Course> query = em.createQuery("Select C from Course C order by size(C.students) desc", Course.class);
        List<Course> results = query.getResultList();
        log.info("Select c From Course c -> {}", results);

    }

    @Test
    public void findCoursesJoinStudent(){
        Query query = em.createQuery("SELECT C, S FROM Course C JOIN C.students S ");
        List<Object[]> results = query.getResultList();
        log.info("SELECT C, S FROM Course C JOIN C.students S -> {}", results.size());

        for (Object[] result: results){
            log.info("\nCourse/Student {} {}", result[0], result[1]);
        }
    }

    @Test
    public void findAllCoursesJoinStudent(){
        Query query = em.createQuery("SELECT C, S FROM Course C LEFT JOIN C.students S ");
        List<Object[]> results = query.getResultList();
        log.info("SELECT C, S FROM Course C JOIN C.students S -> {}", results.size());

        for (Object[] result: results){
            log.info("\nCourse/Student {} {}", result[0], result[1]);
        }
    }


}
