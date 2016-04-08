package com.rec.demo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.rec.demo.config.AppConfig;
import com.rec.demo.config.SQLServerJpaConfig;
import com.rec.demo.dao.sqlserver.EmployeeDAO;
import com.rec.demo.dto.EmployeeDTO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { AppConfig.class })
@Transactional(value = SQLServerJpaConfig.TM)
public class EmployeeDAOTest {

	@Autowired
	private EmployeeDAO employeeDAO;

	private String email = "agnieszka.baranowska@rec-global.com";
	private String employeeNumber = "500056";
	private String personTypeName = "Regular Employee";
	private String businessGroupOrganizationName = "GlobalLogic Poland BG";
	private String locationName = "GlobalLogic Poland - Zielona Gora";

	@Test
	public void getEmployee_dummyEmail() {
		EmployeeDTO employee = employeeDAO.getEmployee("dummy@rec-global.com");
		assertNull(employee);
	}

	@Test
	public void getEmployee() {
		EmployeeDTO employee = employeeDAO.getEmployee(email);
		assertEquals(employeeNumber, employee.getEmployeeNumber());
		assertEquals(personTypeName, employee.getPersonTypeName());
		assertEquals(businessGroupOrganizationName, employee.getBusinessGroupOrganizationName());
		assertEquals(locationName, employee.getLocationName());
	}

}
