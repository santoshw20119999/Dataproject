package employee.Dataproject.service;

import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.opencsv.CSVWriter;

import employee.Dataproject.model.Employee;
import employee.Dataproject.repository.EmployeeRepository;

@Service
public class EmployeeService {
	@Autowired
	EmployeeRepository employeeRepository;

	public ResponseEntity<String> addEmployee(Employee employee) {
		employeeRepository.save(employee);
		return ResponseEntity.status(HttpStatus.OK).body("Employee added successfully");
	}

	public ResponseEntity<String> getEmployeeData(Long employeeId) {
		Employee employee = employeeRepository.getEmployeeData(employeeId);
		try {

			String s = String.valueOf(employeeId);
			String path = "C:\\Users\\santosh wathore\\Desktop\\files\\" + s + ".csv";

//			FileOutputStream fos = new FileOutputStream(path);
//			ObjectOutputStream obs = new ObjectOutputStream(fos);
//			obs.writeObject(list.toString());
//			obs.close();
//			fos.close();
			String header = ",Employee Id,Employee Name,Employee Salary,Employee Designation,Projects";
			String[] harray = header.split(",");
			String[] str = employee.toString().split(",");
			List<String[]> elist = new ArrayList<>();
			CSVWriter csv = new CSVWriter(new FileWriter(path));       //create file
			elist.add(str);
			csv.writeNext(harray);
			csv.writeAll(elist);
			csv.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		return ResponseEntity.status(HttpStatus.OK).body("file downloaded");
	}

}
