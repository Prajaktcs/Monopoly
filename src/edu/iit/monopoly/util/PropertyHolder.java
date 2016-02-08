package edu.iit.monopoly.util;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class PropertyHolder {
	private static Map<String, String> propertiesMap;
	
	static{
		propertiesMap = new HashMap<>();
	}
	
	/**
	 * Load the properties from the passed path
	 * @param path Location of the properties file
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public static void loadProperties() throws FileNotFoundException, IOException{
		Properties properties = new Properties();
		final InputStream stream = PropertyHolder.class.getClassLoader().getResourceAsStream("config.properties");
		properties.load(stream);
		for(String key : properties.stringPropertyNames()) {
			  propertiesMap.put(key, properties.getProperty(key));
		}
		stream.close();
	}
	
	public String getProperty(String key){
		return propertiesMap.get(key);
	}
}
