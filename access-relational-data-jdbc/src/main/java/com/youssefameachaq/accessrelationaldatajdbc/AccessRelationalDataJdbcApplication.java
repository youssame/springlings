package com.youssefameachaq.accessrelationaldatajdbc;

import com.youssefameachaq.accessrelationaldatajdbc.models.Customer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@SpringBootApplication
public class AccessRelationalDataJdbcApplication implements CommandLineRunner {
	private static final Logger log = LoggerFactory.getLogger(AccessRelationalDataJdbcApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(AccessRelationalDataJdbcApplication.class, args);
	}

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public void run(String... args) throws Exception {
		log.info("Create tables...");
		jdbcTemplate.execute("DROP TABLE customers IF EXISTS");
		jdbcTemplate.execute("CREATE TABLE customers(" +
				"id SERIAL, first_name VARCHAR(255), last_name VARCHAR(255))");

		List<Object[]> splitNames = Arrays.asList("Youssef Ameachaq", "Leo Messi", "Christiano Ronaldo")
				.stream()
				.map(name -> name.split(" "))
				.collect(Collectors.toList());

		splitNames.forEach(name -> log.info(String.format("Inserting customer record for : %s %s", name[0], name[1])));

		jdbcTemplate.batchUpdate("INSERT INTO customers(first_name, last_name) VALUES (?,?)", splitNames);

		log.info("Querying for customers where first name = Youssef");

		jdbcTemplate.query("SELECT * FROM customers where first_name = ?",
				(rs, rowNum) -> new Customer(rs.getLong("id"), rs.getString("first_name"), rs.getString("last_name")), "Youssef")
				.forEach(customer -> log.info(customer.toString()));
	}
}
