package com.course.rabbitmqproducer;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.course.rabbitmqproducer.producer.HumanResourceProducer;
import com.course.rabbitmqproducer.producer.entity.Employee;

@SpringBootApplication
public class RabbitmqProducerApplication implements CommandLineRunner {
	
	@Autowired
	private HumanResourceProducer humanResourceProducer;
	

	public static void main(String[] args) {
		SpringApplication.run(RabbitmqProducerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		for(int i = 0;i< 5;i++) {
			Employee employee = new Employee("emp" + i, "Employee " + i, new Date());
			humanResourceProducer.sendMessage(employee);
			System.out.println("Employee sent");
		}
		
	}
}
