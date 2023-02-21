package employee.Dataproject.model;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;

@Entity
public class Employee implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long employeId;
	private String employeeName;
	private long employeeSalary;
	private String employeeDesignation;
	@OneToMany(targetEntity = Project.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "employeId", referencedColumnName = "employeId")
	private List<Project> projects;

	public Employee() {

	}

	public Employee(long employeId, String employeeName, long employeeSalary, String employeeDesignation,
			List<Project> projects) {

		this.employeId = employeId;
		this.employeeName = employeeName;
		this.employeeSalary = employeeSalary;
		this.employeeDesignation = employeeDesignation;
		this.projects = projects;
	}

	public long getEmployeId() {
		return employeId;
	}

	public void setEmployeId(long employeId) {
		this.employeId = employeId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public long getEmployeeSalary() {
		return employeeSalary;
	}

	public void setEmployeeSalary(long employeeSalary) {
		this.employeeSalary = employeeSalary;
	}

	public String getEmployeeDesignation() {
		return employeeDesignation;
	}

	public void setEmployeeDesignation(String employeeDesignation) {
		this.employeeDesignation = employeeDesignation;
	}

	public List<Project> getProjects() {
		return projects;
	}

	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}

	@Override
	public String toString() {
		return ",employeId=" + employeId + ", employeeName=" + employeeName + ", employeeSalary="
				+ employeeSalary + ", employeeDesignation=" + employeeDesignation + ", projects=" + projects + "";
	}

}
