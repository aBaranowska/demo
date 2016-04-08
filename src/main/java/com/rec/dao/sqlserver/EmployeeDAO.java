package com.rec.dao.sqlserver;

import com.rec.dto.EmployeeDTO;

public interface EmployeeDAO {

	EmployeeDTO getEmployee(final String email);

}
