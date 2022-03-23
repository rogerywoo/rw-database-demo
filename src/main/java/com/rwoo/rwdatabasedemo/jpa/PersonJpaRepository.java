package com.rwoo.rwdatabasedemo.jpa;


// Transaction should be at the business layer


import com.rwoo.rwdatabasedemo.entity.Person;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class PersonJpaRepository {
    @PersistenceContext
    EntityManager entityManager;

    public List<Person> findAll() {
        TypedQuery<Person> namedQuery = entityManager.createQuery("find_all", Person.class);
        return namedQuery.getResultList();
    }

    public Person findById(int id) {
        return entityManager.find(Person.class, id);
    }

    public Person update(Person person)
    {
        return entityManager.merge(person);
    }

    public Person insert(Person person)
    {
        return entityManager.merge(person);
    }

    public void delete(Person person)
    {
        entityManager.remove(person);
    }
    public void deleteById(int id)
    {
        Person person = findById(id);
        delete(person);
    }
}
