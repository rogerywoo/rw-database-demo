package com.rwoo.rwdatabasedemo.entity;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Student {
    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @OneToOne(fetch= FetchType.LAZY)
    private Passport passport;

    @ManyToMany
    @JoinTable(name="STUDENT_COURSE",
            joinColumns = @JoinColumn(name="STUDENT_ID"),
            inverseJoinColumns = @JoinColumn(name="COURSE_ID"))
    private List<Course> courses = new ArrayList<Course>();

    @UpdateTimestamp    // Hibernate only
    private LocalDateTime lastUpdatedDate;

    @CreationTimestamp      // Hibernate only
    private LocalDateTime createdDate;

    public Student() {
    }

    public Student(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Passport getPassport() {
        return passport;
    }

    public void setPassport(Passport passport) {
        this.passport = passport;
    }

    public LocalDateTime getLastUpdatedDate() {
        return lastUpdatedDate;
    }

    public void setLastUpdatedDate(LocalDateTime lastUpdatedDate) {
        this.lastUpdatedDate = lastUpdatedDate;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void addCourse(Course course) {
        courses.add(course);
    }

    @Override
    public String toString() {
        return "\n Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
//                ", passport=" + passport +
                ", lastUpdatedDate=" + lastUpdatedDate +
                ", createdDate=" + createdDate +
                '}';
    }
}
