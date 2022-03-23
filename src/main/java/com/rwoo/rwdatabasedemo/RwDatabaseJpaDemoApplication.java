package com.rwoo.rwdatabasedemo;

import com.rwoo.rwdatabasedemo.entity.*;
import com.rwoo.rwdatabasedemo.jpa.CourseRepository;
import com.rwoo.rwdatabasedemo.jpa.EmployeeRepository;
import com.rwoo.rwdatabasedemo.jpa.PersonJpaRepository;
import com.rwoo.rwdatabasedemo.jpa.StudentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SpringBootApplication
public class RwDatabaseJpaDemoApplication implements CommandLineRunner {
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	PersonJpaRepository repository;

	@Autowired
	StudentRepository studentRepository;

	@Autowired
	EmployeeRepository employeeRepository;

	@Autowired
	CourseRepository courseRepository;

	public static void main(String[] args) {

		SpringApplication.run(RwDatabaseJpaDemoApplication.class, args);
	}

//	@Override
//	public void run(String... args) throws Exception {
////		logger.info("All users -> {}", dao.findAll());
//		logger.info("User id 10001-> {}", repository.findById(10001));
////		logger.info("Delete id 10002 Number of users deleted-> {}", repository.deleteById(10002));
//		repository.deleteById(10002);
//		logger.info("Inserting id 10004 Number of users deleted-> {}",
//				repository.insert(new Person(10004, "Arial", "Berlin", new Date())));
//		logger.info("Update id 10003 -> {}",
//				repository.insert(new Person(10003, "Tommy", "London", new Date())));
//
//		logger.info("Add new -> {}",
//				repository.insert(new Person("Unknown", "Unknown", new Date())));
//
//		logger.info("Add new -> {}",
//				repository.insert(new Person("Next", "Next", new Date())));
//		logger.info("Find All -> {}", repository.findAll());
//
//	}

	@Override
	public void run(String... args) throws Exception {

		Employee fullTimeEmployee = new FullTimeEmployee("Roger", new BigDecimal(10000));
		Employee partTimeEmployee = new PartTimeEmployee("Bill ", new BigDecimal(10));

		employeeRepository.insert(fullTimeEmployee);
		employeeRepository.insert(partTimeEmployee);

		List<Employee> employees = employeeRepository.findAll();
		logger.info("employee -> {}", employees);


		//		List<Review> reviews = new ArrayList<Review>();
//		reviews.add(new Review(3, "Average"));
//		reviews.add(new Review(5, "Awesome"));
//		courseRepository.addReviewsForCourse(10001L, reviews);
//		//studentRepository.insertStudentAndCourse();
//		studentRepository.insertStudentAndCourse(new Student("Jack"), new  Course("Micro Service"));


//		studentRepository.saveStudentWithPassport();
//		courseRepository.playWithEM();
//		logger.info("Course id 10001-> {}", courseRepository.findById(10001L));
//		logger.info("Add new -> {}",
//				courseRepository.save(new Course("Philosophy")));


//		courseRepository.deleteById(10002L);
////		logger.info("Delete id 10002 Number of users deleted-> {}", repository.deleteById(10002));
//		repository.deleteById(10002);
//		logger.info("Inserting id 10004 Number of users deleted-> {}",
//				repository.insert(new Person(10004, "Arial", "Berlin", new Date())));
//		logger.info("Update id 10003 -> {}",
//				repository.insert(new Person(10003, "Tommy", "London", new Date())));
//
//		logger.info("Add new -> {}",
//				repository.insert(new Person("Unknown", "Unknown", new Date())));
//
//		logger.info("Add new -> {}",
//				repository.insert(new Person("Next", "Next", new Date())));
//		logger.info("Find All -> {}", repository.findAll());

	}
}
