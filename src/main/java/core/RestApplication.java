package core;

import java.io.Serializable;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

/**
 * Configures Rest for current project
 * @author maike
 *
 */
@ApplicationPath(RestApplication.API_PATH)
public class RestApplication extends Application implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public static final String API_PATH = "/api/"; 


}
