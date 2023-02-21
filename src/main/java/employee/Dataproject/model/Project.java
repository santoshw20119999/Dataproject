package employee.Dataproject.model;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Project implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long projectId;
	private String projectName;
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date joiningDate;
	private Long employeId;

	public Project() {

	}

	public Project(Long projectId, String projectName, Date joiningDate, Long employeId) {

		this.projectId = projectId;
		this.projectName = projectName;
		this.joiningDate = joiningDate;
		this.employeId = employeId;
	}

	public Long getProjectId() {
		return projectId;
	}

	public void setProjectId(Long projectId) {
		this.projectId = projectId;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public Date getJoiningDate() {
		return joiningDate;
	}

	public void setJoiningDate(Date joiningDate) {
		this.joiningDate = joiningDate;
	}

	public Long getEmployeId() {
		return employeId;
	}

	public void setEmployeId(Long employeId) {
		this.employeId = employeId;
	}

	@Override
	public String toString() {
		return ", projectId=" + projectId + ", projectName=" + projectName + ", joiningDate=" + joiningDate
				+ ", employeId=" + employeId + "";
	}

//	@Override
//	public String toString() {
//		return "" + projectId +","+ projectName +","+ joiningDate
//				+ ","+ employeId + ",";
//	}
	
	

}
