package com.example.developer;

import com.example.developer.model.Employee;
import com.example.developer.model.JSONData;
import com.example.developer.model.crud.EmployeeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class DeveloperApplication{

	private JSONData jsonData = new JSONData();
	private static final String urlEmployees =  "http://dummy.restapiexample.com/api/v1/employees";
	private static final Logger log = LoggerFactory.getLogger(DeveloperApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(DeveloperApplication.class, args);
	}

	@Bean
	public CommandLineRunner run(EmployeeRepository repository){
		return (args)-> {

			RestTemplateBuilder restTemplateBuilder = new RestTemplateBuilder();
			jsonData = restTemplateBuilder.build().getForObject(urlEmployees, JSONData.class);

			log.info("///// ADDING EMPLOYEES TO H2DB ////");
			for (Employee employee:
				jsonData.getData()) {
				repository.save(employee);
				log.info("Adding : "+  employee.toString());
			}
		};
	}
}
