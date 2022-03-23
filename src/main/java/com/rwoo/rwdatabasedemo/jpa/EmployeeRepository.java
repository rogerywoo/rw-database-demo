package com.rwoo.rwdatabasedemo.jpa;

import com.rwoo.rwdatabasedemo.entity.Course;
import com.rwoo.rwdatabasedemo.entity.Employee;
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
public class EmployeeRepository {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    EntityManager entityManager;

    public List<Employee> findAll() {
        return entityManager
                .createQuery("Select e from Employee e", Employee.class)
                .getResultList();
    }

    public void insert(Employee employee){
        entityManager.persist(employee);
    }
}
