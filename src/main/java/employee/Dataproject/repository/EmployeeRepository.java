package employee.Dataproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import employee.Dataproject.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

//	 @Query(value=" select e.employe_id,e.employee_name,e.employee_salary,e.employee_designation,p.joining_date,p.project_name from employee e inner join project p on e.employe_id=p.employe_id where e.employe_id=?1",nativeQuery=true)
//		Employee getEmployeeData(Long employeeId);

}
