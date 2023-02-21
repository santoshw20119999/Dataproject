package employee.Dataproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import employee.Dataproject.model.Project;
import employee.Dataproject.service.ProjectService;

@RestController
public class ProjectController {
	@Autowired
	ProjectService projectService;

	@PostMapping("/addproject")
	public ResponseEntity<String> addProject(@RequestBody Project project) {
		return projectService.addProject(project);
	}

}
