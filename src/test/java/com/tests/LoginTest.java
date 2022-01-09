package com.tests;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.base.BaseClass;
import com.pages.Loginpage;

public class LoginTest extends BaseClass{

	Loginpage lp;
	
	@BeforeSuite
	public void setup() {
		initialization();
		reportInit();
		lp= new Loginpage(driver);
	}
	
	@Test
	public void logintest() {
		Assert.assertEquals(lp.loginToApplication("kiran@gmail.com", "123456"), "JavaByKiran | Dashboard");
	}
	@Test
	public void verifyLogo() {
		Assert.assertTrue(lp.verifyLogo());
	}
	@Test
	public void skipTest() {
		throw new SkipException("skipping a testcase");
	}
	
	
	
}
