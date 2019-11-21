package retailtestcase;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
//import com.training.generics.ScreenShot;
import com.training.pom.LoginPOM;
import com.training.pom.LoginPage;
import com.training.pom.Search;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class EasyLevel 
{
	 String baseUrl;
	 WebDriver driver;
	 LoginPOM loginPOM;
	 LoginPage loginPage;
	 Search search;
	 private static Properties properties;
	 String email, pwd;
	
	@BeforeClass
	public void setUpBeforeClass() throws IOException
	{
		properties = new Properties();
		FileInputStream reader = new FileInputStream("./resources/others.properties");
		properties.load(reader);
		email=properties.getProperty("email");
		pwd=properties.getProperty("password");
		}
		
	@BeforeMethod
	public void LaunchURL() throws IOException
	{
	driver = DriverFactory.getDriver(DriverNames.CHROME);
	baseUrl = properties.getProperty("baseURL");
	driver.get(baseUrl);
	search = new Search(driver);
	loginPOM = new LoginPOM(driver);
	loginPage = new LoginPage(driver);
		}	
	
	@AfterMethod
	public void closeBrowser() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}
	
	@Test(priority=1)
	public void  RTTC_007() throws InterruptedException
	{	
		Thread.sleep(3000);
		loginPOM.hoverMouse();
		loginPOM.clickAccount();
		loginPOM.sendUserName(email);
		loginPOM.sendPassword(pwd);
		Thread.sleep(2000);
		loginPOM.clickLoginBtn();
		loginPage.clickChangePassword();
		loginPage.chgpwd1(pwd);
		loginPage.chgpwd2("rev123");
		loginPage.clickButton();
		loginPage.errorMessage();
		}

	
	@Test(priority=2)
	public void RTTC_008()
	{
		search.clickSearch();
		search.searchKey("Ring");
		search.clickSearch();
		search.VerifySort();
		search.Alpha();
	}
	
	
	@Test(priority=3)
	public void RTTC_009() throws InterruptedException
	{	
		
		search.clickSearch();
		search.searchKey("Ring");
		search.clickSearch();
		search.selectItems();
		search.AddtoCart();
		search.ShopCart();
		search.DropDown();
		search.CheckCart();
	}
		
}

