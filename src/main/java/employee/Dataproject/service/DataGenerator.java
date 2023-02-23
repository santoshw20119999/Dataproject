package employee.Dataproject.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.javafaker.Faker;

import employee.Dataproject.model.Project;
import employee.Dataproject.repository.EmployeeRepository;
import employee.Dataproject.repository.ProjectRepository;

@Service
public class DataGenerator {
	@Autowired
	EmployeeRepository employeeRepository;
	@Autowired
	ProjectRepository projectRepository;

	Faker f = new Faker();

	@SuppressWarnings("deprecation")
	public void generateData() {

//		for (int i = 0; i < 101; i++) { // fake data for Employee
//			Employee emp = new Employee();
//			emp.setEmployeId(100 + i);
//			emp.setEmployeeName(f.name().firstName());
//			emp.setEmployeeDesignation(f.company().profession());
//			emp.setEmployeeSalary(f.number().numberBetween(40000, 100000));
//			System.out.println(emp.getEmployeeName());
//			employeeRepository.save(emp);
//		}

		Date from = new Date();
		from.setDate(2010 - 01 - 01);

		Date to = new Date();
		to.setDate(2022 - 01 - 01);

		for (int i = 0; i < 201; i++) { // fake data for project
			Project emp = new Project();
		
			emp.setJoiningDate(f.date().between(from, to));
			emp.setProjectName(f.programmingLanguage().name());
			emp.setEmployeId(null);
			projectRepository.save(emp);
		}

	}

}
