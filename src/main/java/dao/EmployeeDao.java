package dao;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import model.Employee;

/**
 * Acts as a in memory database
 * @author maike
 *
 */
@Stateless
public class EmployeeDao {
	
	/**
	 * The json file to be parsed
	 */
	private static final String FILE_PATH = "employees.json";
	
	/**
	 * Holds in memory the list of {@link Employee}
	 */
	private static List<Employee> employees;
	
	public EmployeeDao() {
	}
	
	public EmployeeDao(File jsonFile) {
		EmployeeDao.employees = this.jsonToList(jsonFile);
	}
	
	/**
	 * Parses the json file to an in memory list
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	@PostConstruct
	public void initializeEmployess(){
		ClassLoader classLoader = getClass().getClassLoader();
		File jsonFile = new File(classLoader.getResource(FILE_PATH).getFile());
		EmployeeDao.employees = this.jsonToList(jsonFile);
	}
	
	private List<Employee> jsonToList(File file) {
		List<Employee> employees;
		ObjectMapper mapper = new ObjectMapper();
		try {
			employees = 
				mapper.readValue(
						file,
						new TypeReference<List<Employee>>() {}
						);
		} catch (IOException e) {
			e.printStackTrace();
			employees = new ArrayList<Employee>();
		} 
		return employees;
	}
	
	/**
	 *  List of employees
	 * @return  the current list of {@link employee}
	 */
	public List<Employee> getEmployees() {
		return EmployeeDao.employees;
	}

}
