package com.base;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.utility.PropertiesUtility;

public class BaseClass {

	public static WebDriver driver;
	public static Logger log = Logger.getLogger(BaseClass.class);
	public static ExtentReports report;
	public static ExtentSparkReporter spark;
	public static ExtentTest test;
	
	public void initialization() {
		log.info("reading browser name from properties file");
		String browser =PropertiesUtility.readProperty("browser");
		log.info("reading URL from properties file");
		String url= PropertiesUtility.readProperty("url");
		if(browser.equalsIgnoreCase("chrome")) {
			log.info("chrome browser launching");
			System.setProperty("webdriver.chrome.driver", "E:/chromedriver.exe");
			driver= new ChromeDriver();
		}
		if(browser.equalsIgnoreCase("firefox")) {
			log.info("firefox browser launching");
			System.setProperty("webdriver.gecko.driver", "C:/geckodriver.exe");
			driver= new FirefoxDriver();
		}
		log.info("maximising browser window");
		driver.manage().window().maximize();
		log.info("applying waits on driver instance");
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		log.info("launching an application");
		driver.get(url);
		
	}
	
	public String getScreenshot(String name) {
		String path =System.getProperty("user.dir")+"/screenshots/"+name+".jpg";
		TakesScreenshot ts = (TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File(path);
		try {
			FileUtils.copyFile(src, dest);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return path;
	}
	
	public void reportInit() {
		log.info("initializing extent report");
		report = new ExtentReports();
		spark = new ExtentSparkReporter(System.getProperty("user.dir")+"/target/ExtentReport.html");
		report.attachReporter(spark);
		log.info("extent report will be available in target folder after execution");
	}
	
	
}
