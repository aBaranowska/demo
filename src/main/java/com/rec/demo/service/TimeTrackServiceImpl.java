package com.rec.demo.service;

import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rec.demo.dao.ProjectDAO;
import com.rec.demo.dao.TimeTrackDAO;
import com.rec.demo.dao.UserDAO;
import com.rec.demo.dao.exception.ProjectDAOException;
import com.rec.demo.dao.exception.UserDAOException;
import com.rec.demo.dto.TimeTrackDTO;
import com.rec.demo.entity.ProjectEntity;
import com.rec.demo.entity.TimeTrackEntity;
import com.rec.demo.entity.UserEntity;
import com.rec.demo.service.exception.TimeTrackServiceException;

@Service
@Transactional("tm")
public class TimeTrackServiceImpl implements TimeTrackService {

	private static final int FIRST_NAME_USER_REGEX_GROUP = 2;

	private static final int LAST_NAME_USER_REGEX_GROUP = 1;

	private static final int LOGIN_USER_REGEX_GROUP = 3;

	@Autowired
	private UserDAO userDAO;

	@Autowired
	private ProjectDAO projectDAO;

	@Autowired
	private TimeTrackDAO timeTrackDAO;

	@Value("${userRegex}")
	private String userRegex;

	public void processTimeTrack(final TimeTrackDTO timeTrackDTO) throws TimeTrackServiceException {
		String user = timeTrackDTO.getUser();

		String firstName = getFirstName(user);
		String lastName = getLastName(user);
		String login = getLogin(user);

		UserEntity userEntity;
		try {
			userEntity = userDAO.getUser(firstName, lastName, login);
		} catch (UserDAOException e) {
			throw new TimeTrackServiceException(e);
		}

		if (userEntity == null) {
			userEntity = new UserEntity();
			userEntity.setFirstName(firstName);
			userEntity.setLastName(lastName);
			userEntity.setLogin(login);

			userDAO.addUser(userEntity);
		}

		String customer = timeTrackDTO.getCustomer();
		String project = timeTrackDTO.getProject();
		String task = timeTrackDTO.getTask();

		ProjectEntity projectEntity;
		try {
			projectEntity = projectDAO.getProject(customer, project, task);
		} catch (ProjectDAOException e) {
			throw new TimeTrackServiceException(e);
		}

		if (projectEntity == null) {
			projectEntity = new ProjectEntity();
			projectEntity.setCustomer(customer);
			projectEntity.setProject(project);
			projectEntity.setTask(task);

			projectDAO.addProject(projectEntity);
		}

		Date date = timeTrackDTO.getDate();
		Double spentTime = timeTrackDTO.getSpentTime();

		TimeTrackEntity timeTrackEntity = new TimeTrackEntity();
		timeTrackEntity.setUser(userEntity);
		timeTrackEntity.setProject(projectEntity);
		timeTrackEntity.setDate(date);
		timeTrackEntity.setSpentTime(spentTime);

		timeTrackDAO.addTimeTrack(timeTrackEntity);
	}

	public String getFirstName(final String user) {
		return getValue(user, FIRST_NAME_USER_REGEX_GROUP);
	}

	public String getLastName(final String user) {
		return getValue(user, LAST_NAME_USER_REGEX_GROUP);
	}

	public String getLogin(final String user) {
		return getValue(user, LOGIN_USER_REGEX_GROUP);
	}

	private String getValue(final String user, final int group) {
		Pattern pattern = Pattern.compile(userRegex);
		Matcher matcher = pattern.matcher(user);
		if (matcher.find()) {
			return matcher.group(group);
		}
		return null;
	}

}
