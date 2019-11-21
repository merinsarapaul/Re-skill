package retailtestcase;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.training.pom.RetailLogin;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class MidLevel {

	 String Url;
	 WebDriver driver;
	 RetailLogin rlogin;
	 private static Properties properties;
	//private ScreenShot screenShot;
	 String user, pwd;
	@BeforeClass
	public void setUpBeforeClass() throws IOException
	{
		properties = new Properties();
		FileInputStream reader = new FileInputStream("./resources/others.properties");
		properties.load(reader);
		user=properties.getProperty("User");
		pwd=properties.getProperty("password1");
		}
		
	@BeforeMethod
	public void LaunchURL() throws IOException
	{
	driver = DriverFactory.getDriver(DriverNames.CHROME);
	Url = properties.getProperty("RetailURL");
	driver.get(Url);
	rlogin = new RetailLogin(driver);
	}	
	
	@AfterMethod
	public void closeBrowser() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}
	
	@Test(priority=1)
	public void  RTTC_037() throws InterruptedException
	{	
		rlogin.EnterUSer(user);
		rlogin.EnterPassword("123456");
		rlogin.ClickLogin();
		rlogin.ErrorMessage();
		}
	
	@Test(priority=2)
	public void RTTC_038() 
	{
		rlogin.EnterUSer(user);
		rlogin.EnterPassword(pwd);
		rlogin.ClickLogin();
		rlogin.Catalog();
		rlogin.AddNew();	
		rlogin.MetaTitle();
	}
	@Test(priority=3)
	public void RTTC_039() throws InterruptedException
	{
		rlogin.EnterUSer(user);
		rlogin.EnterPassword(pwd);
		rlogin.ClickLogin();
		rlogin.Catalog();
		rlogin.Edit();
		Thread.sleep(1000);
		rlogin.MetaTitle();
				
	}
}
