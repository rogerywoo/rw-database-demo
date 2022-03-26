package com.rwoo.test.rwdatabasedemo.jpa;

import com.rwoo.rwdatabasedemo.RwDatabaseJpaDemoApplication;
import com.rwoo.rwdatabasedemo.entity.Course;
import com.rwoo.rwdatabasedemo.jpa.CourseSpringDataRepository;
import org.junit.jupiter.api.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.*;

import java.util.Optional;

import static org.testng.Assert.*;

@SpringBootTest(classes= RwDatabaseJpaDemoApplication.class)
public class CourseSpringRepositoryTest {
    private Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    CourseSpringDataRepository repository;

    @BeforeEach
    public void before(){
        System.out.println("Before");
    }

    @AfterEach
    public void after(){
        System.out.println("After");
    }

    @BeforeAll
    public static void beforeClass(){
        System.out.println("beforeClass");
    }

    @AfterAll
    public static void afterClass(){
        System.out.println("afterClass");
    }

    @Test
    public void findById_Test(){
        String expectedName = "JPA in 50 steps";
        Optional<Course> course = repository.findById(10001L);

        if (course.isPresent()) {
            assertTrue(course.isPresent());
        }
    }
    @Test
    public void findByNotExistId_Test(){
        String expectedName = "JPA in 50 steps";
        Optional<Course> course = repository.findById(20001L);

        if (course.isPresent()) {
            assertTrue(course.isEmpty());
        }
    }

    @Test
    public void playingAroundWithSpringDataRepository(){
        Course course = new Course("Micro Services in 100 Steps");
        repository.save(course);

        course.setName("Micro Services in 100 Steps - Updated");
        repository.save(course);

        log.info("Courses -> {}", repository.findAll());
    }


    @Test
    public void sortCourse_Test(){
        Sort sort = Sort.by(Sort.Direction.DESC, "name");
        log.info("Courses -> {}", repository.findAll(sort));

        sort = Sort.by(Sort.Direction.ASC, "name");
        log.info("Courses -> {}", repository.findAll(sort));
    }

    @Test
    public void paginationCourse_Test(){
        PageRequest pageRequest = PageRequest.of(0,3);

        Page<Course> firstPage = repository.findAll(pageRequest);
        log.info("First Page -> {}", firstPage.getContent());

        Pageable secondPageable = firstPage.nextPageable();
        Page<Course> secondPage = repository.findAll(secondPageable);
        log.info("First Page -> {}", secondPage.getContent());

    }


    @Test
    public void paginationAllCourse_Test(){
        Pageable pageable;
        PageRequest pageRequest = PageRequest.of(0,3);

        Slice<Course> slice = repository.findAll(pageRequest);
        log.info("First Page -> {}", slice.getContent());
        while (slice.hasNext()) {
            pageable =  slice.nextPageable();
            slice = repository.findAll(pageable);
            log.info("First Page -> {}", slice.getContent());
        }
    }

    @Test
    public void findByName_Test(){
        log.info("Find By Name -> {}", repository.findByName("JPA in 50 steps B"));
    }

}
