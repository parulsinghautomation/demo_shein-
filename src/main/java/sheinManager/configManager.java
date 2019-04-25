package sheinManager;

import java.io.FileReader;
import java.util.Properties;


public class configManager {
	
public static Properties property=new Properties();
	
	public static void configreader() throws Exception
	{
		
		FileReader fr=new FileReader("Config.properties");
		property.load(fr);
		property.get("url");
		
		
	}

}
