package com.hierarchy;

import com.hierarchy.dao.EmployeeRepository;
import com.hierarchy.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HeirarchyApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(HeirarchyApplication.class, args);
	}

	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public void run(String... args) throws Exception {
		this.employeeRepository.deleteAll();

		// add employees
		Employee employee = new Employee();
		employee.setEmployeeId("100");
		employee.setEmployeeName("Alan");
		employee.setManagerId("150");
		this.employeeRepository.save(employee);
		Employee employee1 = new Employee();
		employee1.setEmployeeId("220");
		employee1.setEmployeeName("Martin");
		employee1.setManagerId("100");
		this.employeeRepository.save(employee1);
		Employee employee2 = new Employee();
		employee2.setEmployeeId("150");
		employee2.setEmployeeName("Jamie");
		employee2.setManagerId("");
		this.employeeRepository.save(employee2);
		Employee employee3 = new Employee();
		employee3.setEmployeeId("275");
		employee3.setEmployeeName("Alex");
		employee3.setManagerId("100");
		this.employeeRepository.save(employee3);
		Employee employee4 = new Employee();
		employee4.setEmployeeId("400");
		employee4.setEmployeeName("Steve");
		employee4.setManagerId("150");
		this.employeeRepository.save(employee4);
		Employee employee5 = new Employee();
		employee5.setEmployeeId("190");
		employee5.setEmployeeName("David");
		employee5.setManagerId("400");
		this.employeeRepository.save(employee5);
	}
}
