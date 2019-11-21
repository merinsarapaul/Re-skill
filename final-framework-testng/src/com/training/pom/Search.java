package com.training.pom;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
//import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class Search {

String message="Shopping Cart updated!\n" + 
		"Success: You have added SasmitaRing to your shopping cart!";
String pname="SasmitaRing";
String modname="SKU-012";
String price="Rs.200";
List actuallist;
List actlist;
private WebDriver driver; 
	
	public Search(WebDriver driver) 
	{
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
    	
	@FindBy(id="search_button")
	private WebElement searchBtn;
	
	@FindBy(id="filter_keyword")
	private WebElement searchKeyword;
	
	@FindBy(xpath="//img[@alt='Earrings']")
	private WebElement selectItem;
	
	@FindBy(xpath="//button[@class='btn']")
	private WebElement addCart;
	
	@FindBy(xpath="//h3[@class='heading']")
	private WebElement dropDown;
	
	@FindBy(xpath="//a[text()='View Cart']")
	private WebElement viewCart;
	
	@FindBy(css=".noty_text")
	private WebElement shoppingCart;
	
	@FindBy(xpath="(//a[text()='SasmitaRing'])[2]")
	private WebElement prodName;
	
	@FindBy(xpath="(//td[@class='model'])[2]")
	private WebElement model;
	
	@FindBy(xpath="(//td[@class='price'])[2]")
	private WebElement unitPrice;
	
	@FindBy(xpath=" (//td[@class='total'])[3]")
	private WebElement totPrice;
	
	@FindBy(xpath="(//select[@onchange='location = this.value;'])[2]")
	private WebElement sortName;
	
	
	public void clickSearch()
	{	
		Actions action = new Actions(driver);
		action.moveToElement(searchBtn).perform();
		this.searchBtn.click();
	}
	
	public void searchKey(String word)
	{
		this.searchKeyword.click();
		this.searchKeyword.sendKeys(word);
			}
	
	public void selectItems()
	{
		this.selectItem.click();
		
		}
	public void AddtoCart()
	{
		this.addCart.click();
	}
	
	public void ShopCart() throws InterruptedException {
		Assert.assertEquals(shoppingCart.getText(),message);
		System.out.println(shoppingCart.getText());
		Thread.sleep(6000);
		
	}
	public void DropDown() {
		Actions action = new Actions(driver);
		action.moveToElement(dropDown).perform();	
		this.viewCart.click();
		//this.dropdown.click();
		
	}
	public void CheckCart()
	{
		Assert.assertEquals(prodName.getText(),pname);
		Assert.assertEquals(model.getText(),modname);
		Assert.assertEquals(unitPrice.getText(),price);
		Assert.assertEquals(totPrice.getText(),price);
	}
	
	public void VerifySort()
	{
		this.sortName.click();
		Select onchange= new Select(driver.findElement(By.xpath("(//select[@onchange='location = this.value;'])[2]")));
		actuallist=new ArrayList();
		List<WebElement> myTools=onchange.getOptions();
		for(WebElement ele:myTools) 
		{
			String value=ele.getText();
			actuallist.add(value);
		}
		List temp=new ArrayList();
		temp.add("Default");
		temp.add("Name (A - Z)");
		temp.add("Name (Z - A)");
		temp.add("Price (Low > High)");
		temp.add("Price (High > Low)");
		temp.add("Rating (Highest)");
		temp.add("Rating (Lowest)");
		temp.add("Model (A - Z)");
		temp.add("Model (Z - A)");
		Assert.assertEquals(actuallist, temp);
		
		}
	
	public void Alpha() {
		WebElement drpdown =driver.findElement(By.xpath("//option[text()='Name (A - Z)']"));
		drpdown.click();		
		actlist= new ArrayList();
		List<WebElement> items = driver.findElements(By.xpath("//h4/a[@href='http://retailm1.upskills.in/home?search=Ring&sort=pd.name&order=ASC']"));
		
		for(WebElement ele:items) 
		{
			String value=ele.getText();
			actlist.add(value);
		}
		
	    List temp1=new ArrayList();
	    temp1.addAll(actlist);
	    Collections.sort(temp1);
	    Assert.assertTrue(actlist.equals(temp1));
	    
	    this.sortName.click();
		WebElement slct =driver.findElement(By.xpath("//option[text()='Rating (Highest)']"));
		slct.click();
}
	
	
}
