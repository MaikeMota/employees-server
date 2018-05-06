package resources;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.OPTIONS;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import model.Employee;
import services.EmployeeService;

/**
 * {@link Employee} endpoint
 * @author maike
 *
 */
@Stateless
@Path(EmployeeResource.PATH)
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class EmployeeResource {

	/**
	 * Path for Employee resource
	 */
	public static final String PATH = "employee";	
	
	@EJB
	private EmployeeService employeeService;
	
	/**
	 * {GET} Requests for a list of employees
	 * @param skills (optional) filter the employees by their skilss
	 * @return the response with the employees
	 */
	@GET
	public Response getList(
			@QueryParam("skills") List<String> skills
	) {
		List<Employee> employees = employeeService.list(skills);
		return Response.ok(employees).build();
		
	}
	
	/**
	 * Handles {OPTION} for browsers
	 * @return
	 */
	@OPTIONS
    public Response options(){
		return Response.noContent().build();
    }
	
	/**
	 * Handles {OPTION} for browsers
	 * @return
	 */
    @OPTIONS
    @Path("{dummy: (.*)}")
    public Response options(@PathParam("dummy") String dummy){
		return Response.noContent().build();
    }
}