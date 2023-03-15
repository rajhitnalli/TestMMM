package Generic_Utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class Property_Utility {

	public String getPropValue(String key) throws Throwable
	{
		FileInputStream fis=new FileInputStream("./src/main/resources/Commondata.properties.txt");
		Properties pro=new Properties();
		pro.load(fis);
		String val = pro.getProperty(key);
		return val;
	}
}
