package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.AgencyPage;
import pages.HomePage;
import utility.Config;
import utility.Driver;

public class testcases {

	WebDriver driver;
	HomePage homePage;
	AgencyPage agencyPage;
	
	@BeforeClass
	public void setup() {
		driver = Driver.getDriver("chrome");
	
	}
	
	// First Positive Test Case
		@Test(priority = 1)
		public void pTest1() {
			homePage = new HomePage(driver);
			agencyPage = new AgencyPage(driver);

			// Step 1
			String exp = Config.getPropValue("url");
			driver.get(Config.getPropValue("url"));
			homePage.checkUrl(exp);
			homePage.isAt();

			// Step 2
			Actions action = new Actions(driver);
			action.moveToElement(homePage.profiles).perform();
			homePage.agencies.click();
			String urlAgency = "https://www.usaspending.gov/#/agency";
			homePage.checkUrl(urlAgency);
			homePage.isAt();

			// Step 3
			agencyPage.searchBox.click();
			agencyPage.searchBox.sendKeys("Department of Homeland Security");
			// agencyPage.searchButton.click();
			Assert.assertTrue(agencyPage.numberOfResult.isDisplayed());
		}

		// First Negative Test Case
		@Test(priority = 2)
		public void nTest1() {
			homePage = new HomePage(driver);
			agencyPage = new AgencyPage(driver);

			// Step 1
			String exp = Config.getPropValue("url");
			driver.get(Config.getPropValue("url"));
			homePage.checkUrl(exp);
			homePage.isAt();

			// Step 2
			Actions action = new Actions(driver);
			action.moveToElement(homePage.profiles).perform();
			homePage.agencies.click();
			String urlAgency = "https://www.usaspending.gov/#/agency";
			homePage.checkUrl(urlAgency);
			homePage.isAt();

			// Step 3
			agencyPage.searchBox.click();
			agencyPage.searchBox.sendKeys("babakuly");
			Assert.assertTrue(agencyPage.numberOfResult.isDisplayed());
			Assert.assertTrue(agencyPage.noResult.isDisplayed());

		}
	
	
}
