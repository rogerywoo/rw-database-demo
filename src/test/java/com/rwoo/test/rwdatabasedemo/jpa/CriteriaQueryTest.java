package com.rwoo.test.rwdatabasedemo.jpa;

import com.rwoo.rwdatabasedemo.RwDatabaseJpaDemoApplication;
import com.rwoo.rwdatabasedemo.entity.Course;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.Tuple;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import java.util.List;

@SpringBootTest(classes= RwDatabaseJpaDemoApplication.class)
public class CriteriaQueryTest {
    private Logger log = LoggerFactory.getLogger(this.getClass());
    @Autowired
    EntityManager em;


    @Test
    public void findAll_Test(){

        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Course> cq = cb.createQuery(Course.class);
        Root<Course> courseRoot = cq.from(Course.class);
        TypedQuery<Course> query = em.createQuery(cq.select(courseRoot));
        List<Course> results = query.getResultList();
        log.info("TypedQuery<Course> query  -> {}", results);
    }

    @Test
    public void findAHaving100_Test(){

        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Course> cq = cb.createQuery(Course.class);
        Root<Course> courseRoot = cq.from(Course.class);
        Predicate like100Steps = cb.like(courseRoot.get("name"), "%500%");
        cq.where(like100Steps);
        TypedQuery<Course> query = em.createQuery(cq.select(courseRoot));
        List<Course> results = query.getResultList();
        log.info("TypedQueryLike<Course> query  -> {}", results);
    }

    @Test
    public void findAHavingEmpty(){

        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Course> cq = cb.createQuery(Course.class);
        Root<Course> courseRoot = cq.from(Course.class);
        Predicate studentsIsEmpty = cb.isEmpty(courseRoot.get("students"));
        cq.where(studentsIsEmpty);
        TypedQuery<Course> query = em.createQuery(cq.select(courseRoot));
        List<Course> results = query.getResultList();
        log.info("TypedQueryLike<Course> query  -> {}", results);
    }

    @Test
    public void findJoin_Test(){
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Course> cq = cb.createQuery(Course.class);
        Root<Course> courseRoot = cq.from(Course.class);

        Join<Object, Object> joinObjects = courseRoot.join("students");

        TypedQuery<Course> query = em.createQuery(cq.select(courseRoot));
        List<Course> results = query.getResultList();
        log.info("TypedQueryLike<Course> query  -> {}", results);

    }

    @Test
    public void findLeftJoin_Test(){
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Course> cq = cb.createQuery(Course.class);
        Root<Course> courseRoot = cq.from(Course.class);

        Join<Object, Object> joinObjects = courseRoot.join("students", JoinType.LEFT);

        TypedQuery<Course> query = em.createQuery(cq.select(courseRoot));
        List<Course> results = query.getResultList();
        log.info("TypedQueryLike<Course> query  -> {}", results);

    }

}
