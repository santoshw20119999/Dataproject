package employee.Dataproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import employee.Dataproject.model.Project;
import employee.Dataproject.repository.ProjectRepository;

@Service
public class ProjectService {

	@Autowired
	ProjectRepository projectRepository;

	public ResponseEntity<String> addProject(Project project) {
		projectRepository.save(project);
		return ResponseEntity.status(HttpStatus.OK).body("Employee added successfully");
	}
}
