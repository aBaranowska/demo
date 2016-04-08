package com.rec.dao.embedded;

import java.util.List;

import com.rec.entity.embedded.ProjectEntity;
import com.rec.exception.ProjectDAOException;

public interface ProjectDAO {

	List<ProjectEntity> getAllProjects();

	ProjectEntity getProject(final String customer, final String project, final String task) throws ProjectDAOException;

	void addProject(final ProjectEntity project);

}
