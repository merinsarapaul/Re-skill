package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPOM {
	private WebDriver driver; 
	
	public LoginPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath="//i[@class='fa fa-user-o']")
	private WebElement hover;
    	
	@FindBy(xpath="//i[@class='fa fa-sign-in']" )
	private WebElement myAccount;
	
	@FindBy(id="input-email")
	private WebElement userName; 
	
	@FindBy(id="input-password")
	private WebElement password;
	
	@FindBy(xpath="//input[@class='btn btn-primary']")
	private WebElement loginBtn; 
	//a[text()='Change your password']
	public void sendUserName(String username) 
	{
		this.userName.clear();
		this.userName.click();
		this.userName.sendKeys(username);
	}
	
	public void sendPassword(String pwd) {
		this.password.clear(); 
		this.password.click();
		this.password.sendKeys(pwd); 
	}
	
	public void clickLoginBtn() 
	{
		this.loginBtn.click(); 
	}
	
	public void hoverMouse() 
	{
		//WebElement account= driver.findElement(By.xpath("//i[@class='fa fa-user-o']"));
		Actions action = new Actions(driver);
		action.moveToElement(hover).perform();
	}
	
	public void clickAccount()
	{
		this.myAccount.click();
	}
	
	
}
