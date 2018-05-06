package test.service;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import dao.EmployeeDao;
import services.EmployeeService;
import test.util.TestUtil;

public class EmployeeServiceTest {
	
	private static EmployeeDao employeeDao;
	private static EmployeeService employeeService;
	
	@BeforeClass
	public static void setup() throws UnsupportedEncodingException {
		File jsonFile = TestUtil.getJsonFile();	
		EmployeeServiceTest.employeeDao = new EmployeeDao(jsonFile);
		EmployeeServiceTest.employeeService = new EmployeeService(EmployeeServiceTest.employeeDao);
	}

	@Test
	@DisplayName("Shoud be 0 Employees on the list")
	public void shouldBeZeroEmployee() {
		String[] skills = {"python"};
		assertEquals(0, EmployeeServiceTest.employeeService.list(Arrays.asList(skills)).size());
	}

	@Test
	@DisplayName("Shoud be 2 Employees on the list")
	public void shouldBeTwoEmployee() {
		String[] skills = {"DevOps"};
		assertEquals(2, EmployeeServiceTest.employeeService.list(Arrays.asList(skills)).size());
	}

	@Test
	@DisplayName("Shoud be 3 Employees on the list")
	public void shouldBeThreeEmployee() {
		String[] skills = {"javaee"};
		assertEquals(3, EmployeeServiceTest.employeeService.list(Arrays.asList(skills)).size());
	}

	@Test
	@DisplayName("Shoud be 4 Employees on the list")
	public void shouldBeFourEmployee() {
		assertEquals(4, EmployeeServiceTest.employeeService.list(null).size());
	}

}
