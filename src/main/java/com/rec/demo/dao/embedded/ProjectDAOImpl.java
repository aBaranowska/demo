package com.rec.demo.dao.embedded;

import java.util.List;

import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.rec.demo.entity.embedded.ProjectEntity;
import com.rec.demo.exception.ProjectDAOException;

@Repository
public class ProjectDAOImpl extends BaseDAOImpl implements ProjectDAO {

	public List<ProjectEntity> getAllProjects() {
		TypedQuery<ProjectEntity> query = entityManager.createQuery("from ProjectEntity", ProjectEntity.class);
		return query.getResultList();
	}

	public ProjectEntity getProject(final String customer, final String project, final String task)
			throws ProjectDAOException {
		if (customer == null || project == null || task == null) {
			throw new ProjectDAOException(ProjectDAOException.NULL_QUERY_PARAMETER);
		}
		TypedQuery<ProjectEntity> query = entityManager.createQuery(
				"from ProjectEntity where customer = :customer and project = :project and task = :task",
				ProjectEntity.class);
		query.setParameter("customer", customer);
		query.setParameter("project", project);
		query.setParameter("task", task);
		List<ProjectEntity> list = query.getResultList();
		if (list.size() == 0) {
			return null;
		}
		if (list.size() > 1) {
			throw new ProjectDAOException(ProjectDAOException.MORE_THAN_ONE_PROJECT_EXIST);
		}
		return list.get(0);
	}

	public void addProject(final ProjectEntity project) {
		entityManager.persist(project);
	}

}
