package employee.Dataproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import employee.Dataproject.model.Employee;
import employee.Dataproject.service.DataGenerator;
import employee.Dataproject.service.EmployeeService;

@RestController
public class EmployeeController {
	@Autowired
	EmployeeService employeeService;
	@Autowired
	DataGenerator dataGenerator;

	@PostMapping("/addemployee")
	public ResponseEntity<String> addEmployee(@RequestBody Employee employee) {
		return employeeService.addEmployee(employee);

	}

	@GetMapping("/downloadfile")
	public ResponseEntity<String> getEmployeeData(@RequestParam("employeeId") Long employeeId) {

		return employeeService.getEmployeeData(employeeId);
		
	}
	@GetMapping("/fakedata")
	public void randondata() {
		dataGenerator.generateData();
	}
}
