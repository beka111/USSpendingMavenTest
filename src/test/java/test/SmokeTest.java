package test;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import pages.ProfilePage;
import utility.Config;
import utility.Driver;

public class SmokeTest {
	WebDriver driver;
	ProfilePage profPage;
	ExtentReports report;
	ExtentTest test;
	
	
	@BeforeClass
	public void setUp() throws IOException {
		report=new ExtentReports("/USSpendingMavenTest/src/test/resources/SmokeTest.html");
		test=report.startTest("Report for US Spending app");
		driver=Driver.getDriver("chrome");
		test.log(LogStatus.INFO, "Chrome has been set up as Browser");
		profPage=new ProfilePage(driver);
		driver.get(Config.getPropValue("url"));
		test.log(LogStatus.INFO, "Application under test is loaded");
	}
	
	@AfterClass
	public void tearDown() {
//		driver.quit();
		test.log(LogStatus.INFO, "Browser quit");
		report.endTest(test);
		report.flush();
	}
	@Test
	public void test1() throws InterruptedException {
		test.log(LogStatus.INFO, "Home page loaded");
		Thread.sleep(2000);
		profPage.spendingExplorerClick();
		test.log(LogStatus.INFO, "Clicked on Spending Explorer link, the page is loaded and functional");
		Thread.sleep(2000);
		profPage.federalAccoutsDropDownClick();
		test.log(LogStatus.INFO, "Fedral Accounts page is functional and up");
		Thread.sleep(2000);
		profPage.keywordSerachClick();
		test.log(LogStatus.INFO, "Hovered over Award Search dropdown, WebElement is functional, Keyword Search page loaded when clicked on Keyword Search link");
		Thread.sleep(2000);
		profPage.agenciesDropDownClick();
		test.log(LogStatus.INFO, "Hovered over Profiles dropdown. Element is funcional and Agencies/Federal Accounts links are clickable");
		Thread.sleep(2000);
		profPage.awardDataArchiveClick();
		test.log(LogStatus.INFO, "Hovered over Download Center dropdown, it is functional, clicked on Award Data Archive link, links are clickable");
		Thread.sleep(2000);
		profPage.glossaryClick();
		test.log(LogStatus.INFO, "Clicked on Glossary link. Glossary opened and functional");
		Thread.sleep(2000);
		profPage.logoClick();
		test.log(LogStatus.INFO, "Clicked on logo and navigated to Home page");
	}
}
