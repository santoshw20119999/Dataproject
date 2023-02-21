package employee.Dataproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import employee.Dataproject.model.Project;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {

}
