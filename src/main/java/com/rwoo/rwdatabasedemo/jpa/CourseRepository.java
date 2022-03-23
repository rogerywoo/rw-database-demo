package com.rwoo.rwdatabasedemo.jpa;

import com.rwoo.rwdatabasedemo.entity.Course;
import com.rwoo.rwdatabasedemo.entity.Review;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class CourseRepository {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    EntityManager entityManager;



    public Course findById(Long id){
        return entityManager.find(Course.class, id);
    }

    public void delete(Course course){
        entityManager.remove(course);
    }

    public void deleteById(Long id){
        Course course = findById(id);
        delete(course);
    }

    public Course save(Course course){
        if (course.getId() == null){
            entityManager.persist(course);
        } else {
            entityManager.merge(course);
        }
        return  course;
    }

    public void addReviewsForCourse(Long courseId, List<Review> reviews) {
        Course course = findById(courseId);
        logger.info("course.getReviews() -> {}", course.getReviews());
        for (Review review : reviews) {
            course.addReview(review);
            review.setCourse(course);
            entityManager.persist(review);
        }
    }

    public void playWithEM(){
        logger.info("Play with EM");
        Course course = new Course("History");
        entityManager.persist(course);

        Course course2 = new Course("Geometry");
        entityManager.persist(course2);

//        entityManager.detach(course2);
//
//        entityManager.flush();
//
//        course.setName("History 2");
//        entityManager.flush();

//        course2.setName("Geometry 2");
//        entityManager.flush();

    }
}
