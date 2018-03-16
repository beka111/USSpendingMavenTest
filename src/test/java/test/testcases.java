package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.HomePage;
import utility.Config;
import utility.Driver;

public class testcases {

	WebDriver driver;
	HomePage homePage;
	
	@BeforeClass
	public void setup() {
		driver = Driver.getDriver("chrome");
	
	}
	
	@Test(priority=1)
	public void goToUrl() {
		homePage = new HomePage(driver);
		
		//Step 1
		String exp = Config.getPropValue("url");
		driver.get(Config.getPropValue("url"));
		homePage.checkUrl(exp);
		homePage.isAt();
		
		//Step 2
		Actions action = new Actions(driver);
//		action.moveToElement(homePage.profiles).perform();
	}
	
	
	
}
