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
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@SpringBootTest(classes= RwDatabaseJpaDemoApplication.class)
public class NativeSQLTest {
    private Logger log = LoggerFactory.getLogger(this.getClass());
    @Autowired
    EntityManager em;


    @Test
    public void native_query_Test(){
        Query query = em.createNativeQuery("select * from course", Course.class);
        List<Course> results = query.getResultList();
        log.info("select * from course -> {}", results);
    }

    @Test
    public void native_where_query_Test(){
        Query query = em.createNativeQuery("select * from course where id = ?", Course.class);
        query.setParameter(1, 10001L);
        List<Course> results = query.getResultList();
        log.info("select * from course where id = ? {}", results);
    }

    @Test
    public void native_where_pos_query_Test(){
        Query query = em.createNativeQuery("select * from course where id = :id", Course.class);
        query.setParameter("id", 10001L);
        List<Course> results = query.getResultList();
        log.info("select * from course where id = ? {}", results);
    }
    @Test
    @Transactional
    public void native_update_query_Test(){
        Query query = em.createNativeQuery("update COURSE set name = 'test'");
        int numberUpdateRows = query.executeUpdate();
        log.info("numberUpdateRows {}", numberUpdateRows);
    }
}
