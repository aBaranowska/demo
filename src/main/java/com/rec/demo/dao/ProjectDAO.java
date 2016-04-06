package com.rec.demo.dao;

import java.util.List;

import com.rec.demo.dao.exception.ProjectDAOException;
import com.rec.demo.entity.ProjectEntity;

public interface ProjectDAO {

	List<ProjectEntity> getAllProjects();

	ProjectEntity getProject(final String customer, final String project, final String task) throws ProjectDAOException;

	void addProject(final ProjectEntity project);

}
