package com.rec.demo;

import static org.junit.Assert.assertEquals;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.rec.demo.config.JpaConfig;
import com.rec.demo.config.PropertyConfig;
import com.rec.demo.dao.ProjectDAO;
import com.rec.demo.dao.TimeTrackDAO;
import com.rec.demo.dao.UserDAO;
import com.rec.demo.dto.TimeTrackDTO;
import com.rec.demo.entity.ProjectEntity;
import com.rec.demo.entity.TimeTrackEntity;
import com.rec.demo.entity.UserEntity;
import com.rec.demo.service.TimeTrackService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { JpaConfig.class, PropertyConfig.class })
public class TimeTrackServiceTest {

	@Autowired
	private UserDAO userDAO;

	@Autowired
	private ProjectDAO projectDAO;

	@Autowired
	private TimeTrackDAO timeTrackDAO;

	@Autowired
	private TimeTrackService timeTrackService;

	private TimeTrackDTO timeTrackDTO;
	private String user = "Leja, Micha³ (leja.michal)";
	private String customer = "Gemalto DE";
	private String project = "ST_IFX Maintenance ST_2016";
	private String task = "TC_Maintenance_Automation";
	private Date parsedDate;
	private String date = "2016-03-23";
	private Double spentTime = 2.5;
	private String firstName = "Micha³";
	private String lastName = "Leja";
	private String login = "leja.michal";

	@Before
	public void setUp() throws ParseException {
		parsedDate = new SimpleDateFormat("yyyy-MM-dd").parse(date);

		timeTrackDTO = new TimeTrackDTO();
		timeTrackDTO.setUser(user);
		timeTrackDTO.setCustomer(customer);
		timeTrackDTO.setProject(project);
		timeTrackDTO.setTask(task);
		timeTrackDTO.setDate(parsedDate);
		timeTrackDTO.setSpentTime(spentTime);
	}

	@Test
	public void getFirstName() {
		assertEquals(firstName, timeTrackService.getFirstName(user));
	}

	@Test
	public void getLastName() {
		assertEquals(lastName, timeTrackService.getLastName(user));
	}

	@Test
	public void getLogin() {
		assertEquals(login, timeTrackService.getLogin(user));
	}

	@Test
	@Rollback(true)
	public void processTimeTrack() {
		timeTrackService.processTimeTrack(timeTrackDTO);

		UserEntity userEntity = userDAO.getAllUsers().get(0);
		assertEquals(firstName, userEntity.getFirstName());
		assertEquals(lastName, userEntity.getLastName());
		assertEquals(login, userEntity.getLogin());

		ProjectEntity projectEntity = projectDAO.getAllProjects().get(0);
		assertEquals(customer, projectEntity.getCustomer());
		assertEquals(project, projectEntity.getProject());
		assertEquals(task, projectEntity.getTask());

		TimeTrackEntity timeTrack = timeTrackDAO.getAllTimeTracks().get(0);
		assertEquals(userEntity.getId(), timeTrack.getUser().getId());
		assertEquals(projectEntity.getId(), timeTrack.getProject().getId());
		assertEquals(parsedDate, timeTrack.getDate());
		assertEquals(spentTime, timeTrack.getSpentTime());
	}

}
