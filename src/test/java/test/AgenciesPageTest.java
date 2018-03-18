package test;

import static utility.Config.getPropValue;

import org.junit.AfterClass;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.AgenciesPage;
import pages.ProfilePage;
import utility.Driver;

public class AgenciesPageTest {
	WebDriver driver;
	AgenciesPage ap;
	ProfilePage pp;
	
	
	@BeforeClass
	public void setup() {
		driver = Driver.getDriver("chrome");
		driver.get(getPropValue("url"));
		
	}
	
	@Test
	public void test1() throws InterruptedException { 
		
		pp = new ProfilePage(driver);
		pp.agenciesDropDownClick();
		Thread.sleep(3000);
	}
	
	@Test
	public void test2() throws InterruptedException {
		ap = new AgenciesPage(driver);
		ap.searchDepartment(getPropValue("department"));
		Thread.sleep(2000);
		
		
	}
	@AfterClass
	public void tearDown() throws InterruptedException {
		Thread.sleep(3000);
		driver.quit();
	}
	
	
	
	

}
