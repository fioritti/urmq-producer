package com.course.rabbitmqproducer;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

import com.course.rabbitmqproducer.producer.EmployeeJsonProducer;
import com.course.rabbitmqproducer.producer.entity.Employee;

@SpringBootApplication
//@EnableScheduling
public class RabbitmqProducerApplication implements CommandLineRunner {
	
	@Autowired
	private EmployeeJsonProducer employeeJsonProducer;
	
//	@Autowired
//	private HelloRabbitProducer helloRabbitProducer;

	public static void main(String[] args) {
		SpringApplication.run(RabbitmqProducerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		helloRabbitProducer.sendHello("Fioritti " + Math.random());
		
		for(int i = 0;i< 5;i++) {
			Employee employee = new Employee("emp" + i, "Employee " + i, new Date());
			employeeJsonProducer.sendMessage(employee);
			System.out.println("Employee sent");
		}
		
	}
}
