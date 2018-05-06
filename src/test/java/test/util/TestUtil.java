package test.util;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

public class TestUtil {
	
	public static File getJsonFile() throws UnsupportedEncodingException {
		final String FILE_PATH = "employees.json";
		TestUtil util = new TestUtil();
		ClassLoader classLoader = util.getClass().getClassLoader();
		String filePath = URLDecoder.decode(classLoader.getResource(FILE_PATH).getFile(), "UTF-8");
		return new File(filePath);	
	}

}
