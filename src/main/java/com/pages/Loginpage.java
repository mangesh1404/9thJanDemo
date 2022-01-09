package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BaseClass;

public class Loginpage extends BaseClass{

	
	@FindBy(id="email")
	private WebElement uname;
	
	@FindBy(id="password")
	private WebElement pass;
	
	@FindBy(xpath="//button")
	private WebElement loginBtn;
	
	@FindBy(xpath="//img[contains(@src,'jbk')]")
	private WebElement logo;
	
	
	public Loginpage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public String loginToApplication(String username, String password) {
		uname.sendKeys(username);
		pass.sendKeys(password);
		loginBtn.click();
		return driver.getTitle();
	}
	
	public boolean verifyLogo() {
		 return logo.isDisplayed();
	}
	
	
	
	
	
}
