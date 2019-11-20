package com.training.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class LoginPage {

private WebDriver driver; 
	
	public LoginPage(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	String errormessage="Password confirmation does not match password!";
	
	WebElement chgpwd;
    	
	@FindBy(id="input-password")
	private WebElement pwd1;
	
	@FindBy(id="input-confirm")
	private WebElement pwd2;
	
	@FindBy(xpath="//input[@class='btn btn-primary']")
	private WebElement button;
	
	@FindBy(xpath="//div[@class='text-danger']")
	private WebElement errmsg;
	
	public void clickChangePassword()
	{	
	
		driver.findElement(By.xpath("//a[@href='http://retailm1.upskills.in/account/password']")).click();
	}
	
	public void chgpwd1(String password1)
	{
		this.pwd1.click();
		this.pwd1.sendKeys(password1);	
	}
	
	public void chgpwd2(String password2)
	{
		this.pwd2.click();
		this.pwd2.sendKeys(password2);
	}
	
	public void clickButton()
	{
		this.button.click();
	}
	public void errorMessage() 
	{
		Assert.assertEquals(errmsg.getText(),errormessage);
		System.out.println(errmsg.getText());
	}
	
}
