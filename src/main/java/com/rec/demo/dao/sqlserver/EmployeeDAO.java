package com.rec.demo.dao.sqlserver;

import com.rec.demo.dto.EmployeeDTO;

public interface EmployeeDAO {

	EmployeeDTO getEmployee(final String email);

}
