package com.rwoo.rwdatabasedemo;

import com.rwoo.rwdatabasedemo.entity.Person;
import com.rwoo.rwdatabasedemo.jdbc.PersonJbdcDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;


//@SpringBootApplication  -- To use Jpa
//public class RwDatabaseDemoApplication implements CommandLineRunner {
//	private Logger logger = LoggerFactory.getLogger(this.getClass());

//	@Autowired
//	PersonJbdcDAO dao;
//	public static void main(String[] args) {
//		SpringApplication.run(RwDatabaseDemoApplication.class, args);
//	}

//	@Override
//	public void run(String... args) throws Exception {
//		logger.info("All users -> {}", dao.findAll());
//		logger.info("User id 10001-> {}", dao.findById(10001));
//		logger.info("Delete id 10002 Number of users deleted-> {}", dao.deleteById(10002));
//		logger.info("Inserting id 10004 Number of users deleted-> {}",
//				dao.insert(new Person(10004, "Arial", "Berlin", new Date())));
//		logger.info("Update id 10002 -> {}",
//				dao.insert(new Person(10002, "Tommy", "London", new Date())));
//	}
//}
