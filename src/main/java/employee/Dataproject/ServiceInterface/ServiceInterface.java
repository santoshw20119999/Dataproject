package employee.Dataproject.ServiceInterface;

import org.springframework.http.ResponseEntity;

import employee.Dataproject.model.Employee;

public interface ServiceInterface {
	public ResponseEntity<String> addEmployee(Employee employee);
	public ResponseEntity<String> getEmployeeData(Long employeeId);
	public ResponseEntity<String> getEmployeeData();
	public void generateData();
}
