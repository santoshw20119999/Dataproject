package employee.Dataproject.service;

import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.github.javafaker.Faker;
import com.opencsv.CSVWriter;

import employee.Dataproject.ServiceInterface.ServiceInterface;
import employee.Dataproject.model.Employee;
import employee.Dataproject.model.Project;
import employee.Dataproject.repository.EmployeeRepository;
import employee.Dataproject.repository.ProjectRepository;

@Service
public class EmployeeService implements ServiceInterface {
	@Autowired
	EmployeeRepository employeeRepository;

	@Autowired
	ProjectRepository projectRepository;

	public ResponseEntity<String> addEmployee(Employee employee) {
		employeeRepository.save(employee);
		return ResponseEntity.status(HttpStatus.OK).body("Employee added successfully");
	}

	// add boolean argument
	public ResponseEntity<String> getEmployeeData(Long employeeId) {
		Optional<Employee> employee = employeeRepository.findById(employeeId); // printing optional in file
		List<Employee> employeelist = employeeRepository.findAll();
		// Employee employee = employeeRepository.getEmployeeData(employeeId);
		try {

			String s = String.valueOf(employeeId);
			String path = "C:\\Users\\santosh wathore\\Desktop\\files\\" + s + ".csv";

			String header = ",Employee Id,Employee Name,Employee Salary,Employee Designation,Projects";
			String[] harray = header.split(",");
			String[] str = employee.toString().split(",");
			List<String[]> elist = new ArrayList<>();
			CSVWriter csv = new CSVWriter(new FileWriter(path)); // create file
			elist.add(str);
			csv.writeNext(harray);
			csv.writeAll(elist);
			csv.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		return ResponseEntity.status(HttpStatus.OK).body("file downloaded");
	}

	@Override
	public void generateData() {
		Faker f = new Faker();
		Employee emp = null;

		for (int i = 0; i < 101; i++) { // fake data for Employee
			emp = new Employee();
			emp.setEmployeeName(f.name().firstName());
			emp.setEmployeeDesignation(f.company().profession());
			emp.setEmployeeSalary(f.number().numberBetween(40000, 100000));
			System.out.println(emp.getEmployeeName());
			emp = employeeRepository.save(emp);

			Date from = new Date();
			from.setDate(2010 - 01 - 01);

			Date to = new Date();
			to.setDate(2022 - 01 - 01);

			for (int j = 0; j <= 2; j++) { // fake data for project
				Project p = new Project();
				p.setEmployeId(emp.getEmployeId());
				p.setJoiningDate(f.date().between(from, to));
				p.setProjectName(f.programmingLanguage().name());
				projectRepository.save(p);
			}

		}

	}

}
