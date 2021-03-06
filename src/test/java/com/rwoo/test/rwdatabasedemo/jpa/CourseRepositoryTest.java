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

import javax.transaction.Transactional;

import static org.testng.Assert.*;

@SpringBootTest(classes= RwDatabaseJpaDemoApplication.class)
public class CourseRepositoryTest {
    private Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    CourseRepository courseRepository;

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
        Course course = courseRepository.findById(10001L);

        assertEquals(expectedName, course.getName());

    }

    @Test
    @Transactional
    public void findByIdFirstLevelCache_Test(){
        String expectedName = "JPA in 50 steps";
        Course course = courseRepository.findById(10001L);
        log.info("First Course Retrieved {}", course);
        Course course1 = courseRepository.findById(10001L);
        log.info("First Course Retrieved Again {}", course1);

        assertEquals(expectedName, course.getName());
        assertEquals(expectedName, course1.getName());

    }

    @Test
    @DirtiesContext
    public void deleteById_Test(){
        courseRepository.deleteById(10001L);

        assertNull(courseRepository.findById(10001L));

    }

    @Test
    @DirtiesContext
    public void save_Test(){
        courseRepository.save(new Course("Class 1"));
        Course course = courseRepository.findById(2L);
        assertNotNull(course);
        assertEquals("Class 1", course.getName());

    }

    @Test
    @DirtiesContext
    public void save1_Test(){
        courseRepository.save(new Course("Class 2"));
        Course course = courseRepository.findById(2L);
        assertNotNull(course);
        assertEquals("Class 2", course.getName());

    }
    @Test
    @DirtiesContext
    public void playWithEM_Test(){
        courseRepository.playWithEM();
    }
}
