package com.rec.demo.dao2;

import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.transform.Transformers;
import org.hibernate.type.StandardBasicTypes;
import org.springframework.stereotype.Repository;

import com.rec.demo.dao2.exception.EmployeeDAOException;
import com.rec.demo.dto2.EmployeeDTO;

@Repository
public class EmployeeDAOImpl extends BaseDAOImpl implements EmployeeDAO {

	@SuppressWarnings("unchecked")
	public EmployeeDTO getEmployee(final String email) {
		Session session = entityManager.unwrap(Session.class);
		SQLQuery query = session.createSQLQuery(
				"select EmployeeNumber, PersonTypeName, BusinessGroupOrganizationName, LocationName from vw_Employee where EmailID = :email");
		query.addScalar("EmployeeNumber", StandardBasicTypes.STRING);
		query.addScalar("PersonTypeName", StandardBasicTypes.STRING);
		query.addScalar("BusinessGroupOrganizationName", StandardBasicTypes.STRING);
		query.addScalar("LocationName", StandardBasicTypes.STRING);
		query.setParameter("email", email);
		query.setResultTransformer(Transformers.aliasToBean(EmployeeDTO.class));
		List<EmployeeDTO> list = query.list();
		if (list.size() == 0) {
			return null;
		}
		if (list.size() > 1) {
			throw new EmployeeDAOException(EmployeeDAOException.MORE_THAN_ONE_EMPLOYEE_EXIST);
		}
		return list.get(0);
	}

}
