package com.utility;

import java.io.FileInputStream;
import java.util.Properties;

import org.testng.annotations.Test;

import com.base.BaseClass;

public class PropertiesUtility extends BaseClass{

	public static FileInputStream fis;
	public static Properties prop;
	
	public static String readProperty(String key) {
		log.info("reading property file");
		prop= new Properties();
		try {
			fis =new FileInputStream(System.getProperty("user.dir")+"/src/main/resources/config.properties");
			prop.load(fis);
		} catch (Exception e) {
			log.error("property file not present in the given path");
			e.printStackTrace();
		}
		return prop.getProperty(key);
	}
	
	
	
	
}
