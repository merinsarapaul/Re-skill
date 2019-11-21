package com.training.pom;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class RetailLogin {
	
String errormessage="No match for Username and/or Password.\n" + 
		"×";
String msg="Success: You have modified categories!\n" + 
		"×";
private WebDriver driver; 

	
	public RetailLogin(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	@FindBy(id="input-username")
	private WebElement userName;
	
	@FindBy(id="input-password")
	private WebElement password;
	
	@FindBy(xpath="//button[@class='btn btn-primary']")
	private WebElement button;
	
	@FindBy(xpath="//div[@class='alert alert-danger']")
	private WebElement errmsg;
	
	@FindBy(xpath="//i[@class='fa fa-tags fw']")
	private WebElement icon;
	
	@FindBy(xpath="//*[text()='Categories']")
	private WebElement categories;
	
	@FindBy(xpath="(//a[@class='btn btn-primary'])[1]")
	private WebElement add;
	
	@FindBy(id="input-name1")
	private WebElement cname;
	
	@FindBy(xpath="//div[@class='note-editable panel-body']")
	private WebElement desc;
	
	@FindBy(id="input-meta-title1")
	private WebElement metatitle;
	
	@FindBy(id="input-meta-description1")
	private WebElement metadesc;
	
	@FindBy(xpath="//button[@class='btn btn-primary']")
	private WebElement save;		
	
	@FindBy(xpath="//div[@class='alert alert-success']")
	private WebElement success;
	
	@FindBy(xpath="(//a[@class='btn btn-primary'])[2]")
	private WebElement edit;
	
	public void EnterUSer(String username) {
		this.userName.click();
		this.userName.sendKeys(username);	
	}
	public void EnterPassword(String passwrd) {
		this.password.click();
		this.password.sendKeys(passwrd);	
	}
	public void ClickLogin() {
		this.button.click();
	}
	public void ErrorMessage() {
		Assert.assertEquals(errmsg.getText(),errormessage);
		
	}
	public void Catalog() {
		
		Actions action = new Actions(driver);
		action.moveToElement(icon).perform();
		this.categories.click();
	}
	public void AddNew()
	{
		this.add.click();
		this.cname.click();
		this.cname.clear();
		this.cname.sendKeys("ORNAMENTS");
		this.desc.click();
		this.desc.clear();
		this.desc.sendKeys("ornaments for ladies");
	}
	public void MetaTitle() 
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		this.metatitle.click();
		this.metatitle.clear();
		this.metatitle.sendKeys("ORNAMENTS");
		this.metadesc.click();
		this.metadesc.clear();
		this.metadesc.sendKeys("ornaments for ladies");
		// js.executeScript("arguments[0].scrollIntoView();",save);
		js.executeScript("window.scrollTo(0, -document.body.scrollHeight);");
		this.save.click();
		Assert.assertEquals(success.getText(), msg);
	}
	
	public void Edit() {
		this.edit.click();
	}
}
