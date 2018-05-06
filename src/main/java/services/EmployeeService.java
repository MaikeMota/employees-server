package services;

import java.util.List;
import java.util.stream.Collectors;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import dao.EmployeeDao;
import model.Employee;
import util.CollectionsUtil;

/**
 * Responsible for filters and business rules
 * @author maike
 *
 */
@Stateless
public class EmployeeService {
	
	@EJB
	private EmployeeDao employeeDao;
	
	public EmployeeService() {
	}
	
	public EmployeeService(EmployeeDao dao) {
		this.employeeDao = dao;
	}
	
	/**
	 * List the {@link Employee}
	 * @param skills the skills list to use as filter
	 * @return
	 */
	public List<Employee> list(List<String> skills){
		List<Employee> employeeResults = employeeDao.getEmployees();;
		if(skills != null && !skills.isEmpty()) {
			employeeResults = employeeResults
					.stream()
					.filter(employee -> {
						if(employee.getSkills() != null && !employee.getSkills().isEmpty()) {
							return CollectionsUtil.hasAny(employee.getSkills(), skills);									
						}else {
							return true;
						}
					})
					.collect(Collectors.toList());
		}
		return employeeResults;
	}

}