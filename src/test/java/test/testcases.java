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
	public void USAHM001() throws InterruptedException {
		homePage = new HomePage(driver);
		agencyPage = new AgencyPage(driver);

		// Step 1
		String exp = Config.getPropValue("url");
		driver.get(Config.getPropValue("url"));
		homePage.checkUrl(exp);
		Thread.sleep(2000);
		homePage.isAt();

		// Step 2
		Actions action = new Actions(driver);
		action.moveToElement(homePage.profiles).perform();
		homePage.agencies.click();
		homePage.checkUrl(Config.getPropValue("urlAgency"));
		Thread.sleep(2000);
		homePage.isAt();

		// Step 3
		agencyPage.searchBox.click();
		Thread.sleep(2000);
		agencyPage.searchBox.sendKeys("Department of Homeland Security");
		Assert.assertTrue(agencyPage.numberOfResult.isDisplayed());

	}

	// First Negative Test Case
	@Test(priority = 2)
	public void USAHM002() throws InterruptedException {
		homePage = new HomePage(driver);
		agencyPage = new AgencyPage(driver);

		// Step 1
		String exp = Config.getPropValue("url");
		driver.get(Config.getPropValue("url"));
		homePage.checkUrl(exp);
		homePage.isAt();

		// Step 2
		Actions action = new Actions(driver);
		Thread.sleep(2000);
		action.moveToElement(homePage.profiles).perform();
		homePage.agencies.click();
		homePage.checkUrl(Config.getPropValue("urlAgency"));
		homePage.isAt();

		// Step 3
		agencyPage.searchBox.click();
		agencyPage.searchBox.sendKeys("babakuly");
		Assert.assertTrue(agencyPage.numberOfResult.isDisplayed());
		Assert.assertTrue(agencyPage.noResult.isDisplayed());

	}

	@Test(priority = 3)
	public void USAHM003() throws InterruptedException {
		homePage = new HomePage(driver);
		agencyPage = new AgencyPage(driver);

		// Step 1
		String exp = Config.getPropValue("url");
		driver.get(Config.getPropValue("url"));
		Thread.sleep(2000);
		homePage.checkUrl(exp);
		homePage.isAt();

		// Step 2
		Actions action = new Actions(driver);
		action.moveToElement(homePage.profiles).perform();
		homePage.agencies.click();
		homePage.checkUrl(Config.getPropValue("urlAgency"));
		homePage.isAt();

		// Step 3
		agencyPage.BudgetaryResButtonDessen.click();
		Assert.assertTrue(agencyPage.BudgetaryResButtonDessen.isEnabled(), "Thec colo is not changed");
		Assert.assertTrue(agencyPage.BudgetaryResButtonAssen.isEnabled(), "The color is changed");

		// Step 4
		agencyPage.BudgetaryResButtonAssen.click();
		agencyPage.BudgetaryResButtonAssen.click();
		Assert.assertTrue(agencyPage.BudgetaryResButtonAssen.isEnabled(), "The color is not changed");
		System.out.println(agencyPage.BudgetaryResButtonAssen.isEnabled());
		System.out.println(agencyPage.BudgetaryResButtonAssen.isSelected());

	}

	@Test(priority = 4)
	public void USAHM004() throws InterruptedException {
		homePage = new HomePage(driver);
		agencyPage = new AgencyPage(driver);

		// Step 1
		String exp = Config.getPropValue("url");
		driver.get(Config.getPropValue("url"));
		Thread.sleep(2000);
		homePage.checkUrl(exp);
		homePage.isAt();

		// Step 2
		Actions action = new Actions(driver);
		action.moveToElement(homePage.profiles).perform();
		homePage.agencies.click();
		homePage.checkUrl(Config.getPropValue("urlAgency"));
		homePage.isAt();

		// Step 3
		agencyPage.PercentOfTotalButton.click();
		Thread.sleep(2000);
		Assert.assertTrue(agencyPage.PercentOfTotalButtonDessen.isEnabled(), "The color is not changed");

	}

}