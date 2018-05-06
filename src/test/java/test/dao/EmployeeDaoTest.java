package test.dao;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.UnsupportedEncodingException;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import dao.EmployeeDao;
import test.util.TestUtil;

public class EmployeeDaoTest {
	
	@Test
	@DisplayName("Shoud be 4 Employess on the list")
	public void shouldBeFourEmployee() throws UnsupportedEncodingException {
		File jsonFile = TestUtil.getJsonFile();	
		EmployeeDao employeeDao = new EmployeeDao(jsonFile);
		assertEquals(4, employeeDao.getEmployees().size());
	}
	
}


