package com.durgaprasad.database.databasebasics;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@SpringBootApplication
public class DatabaseBasicsApplication implements CommandLineRunner {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private PersonJdbcDAO dao;

	public static void main(String[] args) {
		SpringApplication.run(DatabaseBasicsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		logger.info("All users -> {}", dao.findAll());
		logger.info("User 10001 -> {}", dao.findById(10001));
		logger.info("Number of rows deleted -> {}", dao.deleteById(10002));
		Person person = new Person(10004, "Ed Nagarkatte", "Ankola", new Date());
		logger.info("Inserting the person -> {}", dao.insert(person));
		person.setName("Ekanath D Nagarkatte");
		logger.info("Updating the name -> {}", dao.update(person));
		logger.info("All users -> {}", dao.findAll());
	}
}
