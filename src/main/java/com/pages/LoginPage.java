package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	
	private WebDriver driver;
	
	private By emailId=By.id("email");
	private By password =By.id("passwd");
	private By signInButton=By.id("SubmitLogin");
	private By forgotPwdLink=By.linkText("Forgot your password?");
	
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public String getLoginPageTitle()
	{
		return driver.getTitle();
	}
	
	public boolean isForgotPwdLinkExist()
	{
		return driver.findElement(forgotPwdLink).isDisplayed();
	}
	
	public void enterUserName(String username)
	{
		driver.findElement(emailId).sendKeys(username);
	}
	
	public void enterPassword(String pwd)
	{
		driver.findElement(password).sendKeys(pwd);
		
	}
	public void clickLoginButton()
	{
		driver.findElement(signInButton).click();
	}
	
	public MyAccountPage doLogin(String un, String ps)
	{
		System.out.println("Login with "+un+" and "+ps);
		driver.findElement(emailId).sendKeys(un);
		driver.findElement(password).sendKeys(ps);
		driver.findElement(signInButton).click();
		return new MyAccountPage(driver);
	}
}
