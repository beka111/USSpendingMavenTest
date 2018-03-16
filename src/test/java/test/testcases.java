package test;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import utility.Config;
import utility.Driver;
import utility.GenericMethods;

public class testcases {

	WebDriver driver;
	
	
	@BeforeClass
	public void setup() {
		driver = Driver.getDriver("chrome");
	
	}
	
	@Test
	public void goToUrl() {
		
		//driver.get("https://www.usaspending.gov/#/");
		driver.get(Config.getPropValue("url"));
	}
}
