package com.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver ldriver;
	
	public LoginPage(WebDriver rdriver)
	{
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
		
	}
      
	@FindBy(name="uid")
	WebElement textUserName;
	
	@FindBy(name="password")
	WebElement textPassword;
	
	@FindBy(name="btnLogin")
	WebElement btnLogin;
	
	@FindBy(xpath="//a[normalize-space()='Log out']")
	WebElement linklogout;
	
	
	
	
	public void setUserName(String Uname) 
	{
		textUserName.sendKeys(Uname);
		
	}
	
	public void setPassword(String pwd) 
	{
		textPassword.sendKeys(pwd);
		
	}
	
	public void loginClick() 
	{
		btnLogin.click();
		
	}
	
	public void linklogout() 
	{
		linklogout.click();
		
	}
}