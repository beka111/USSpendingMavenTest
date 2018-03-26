package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.Agency_Page_Dastan;
import pages.HomePage;
import pages.ProfilePage;
import pages.SpendingExplorerPage;
import utility.Config;
import utility.Driver;

public class Test_Cases_11_15_Dastan {

	WebDriver driver = Driver.getDriver("opera");
	@Test
	public void test_11() {
		driver.get(Config.getPropValue("url"));
		Assert.assertEquals(Config.getPropValue("expectedTitle"),driver.getTitle());
		//1st step is passed
		
		HomePage hp = new HomePage(driver);
		Actions action = new Actions(driver);
		action.moveToElement(hp.profiles).perform();
		hp.agencies.click();
		Assert.assertEquals(driver.getCurrentUrl(),Config.getPropValue("urlAgency"));
		//2nd step is passed
		
		Agency_Page_Dastan app = new Agency_Page_Dastan(driver);
		Assert.assertTrue(app.checkIfContainsPercentage(app.numberPercentage));
		//3rd & 4th steps are passed
	}
	
	@Test
	 public void test_12() {
		driver.get(Config.getPropValue("url"));
		Assert.assertEquals(Config.getPropValue("expectedTitle"), driver.getTitle());
		//1st step is passed
		
		HomePage hp = new HomePage(driver);
		hp.sependingExplorer.click();
		SpendingExplorerPage se = new SpendingExplorerPage(driver);
		Assert.assertTrue(se.BudgetFunction.isDisplayed());
		Assert.assertTrue(se.Agency.isDisplayed());
		Assert.assertTrue(se.ObjectClass.isDisplayed());
		//2nd step is passed
	 }
	
	@Test
	public void test_13() {
		driver.get(Config.getPropValue("url"));
		Assert.assertEquals(Config.getPropValue("expectedTitle"), driver.getTitle());
		//1st step is passed
		
		HomePage hp = new HomePage(driver);
		Actions action = new Actions(driver);
		action.moveToElement(hp.awardSearch).perform();
		ProfilePage pp = new ProfilePage(driver);
		Assert.assertTrue(pp.advancedSearch.isDisplayed());
		Assert.assertTrue(pp.keywordSearch.isDisplayed());
		//2nd step is passed
	}
	
	@Test
	public void test_14() {
		driver.get(Config.getPropValue("url"));
		Assert.assertEquals(Config.getPropValue("expectedTitle"), driver.getTitle());
		//1st step is passed
		
		HomePage hp = new HomePage(driver);
		Actions action = new Actions(driver);
		action.moveToElement(hp.profiles).perform();
		Assert.assertTrue(hp.agencies.isDisplayed());
		Assert.assertTrue(hp.federalAccounts.isDisplayed());
		//2nd step is passed
	}
	
	@Test
	public void test_15() {
		driver.get(Config.getPropValue("url"));
		Assert.assertEquals(Config.getPropValue("expectedTitle"), driver.getTitle());
		//1 step is passed
		
		HomePage hp = new HomePage(driver);
		ProfilePage pp = new ProfilePage(driver);
		Actions action = new Actions(driver);
		action.moveToElement(hp.downloadCenter).perform();
		Assert.assertTrue(pp.awardDataArchive.isDisplayed());
		Assert.assertTrue(pp.customAwardData.isDisplayed());
		Assert.assertTrue(pp.agencySubmissionFiles.isDisplayed());
		Assert.assertTrue(pp.databaseSnapshots.isDisplayed());
		Assert.assertTrue(pp.api.isDisplayed());
		//2nd step passed
	}
	
}
