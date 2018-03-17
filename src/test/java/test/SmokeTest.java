package test;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

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
		profPage=new ProfilePage(driver);
		driver.get(Config.getPropValue("url"));
	}
	
	@AfterClass
	public void tearDown() {
//		driver.quit();
	}
	@Test
	public void test1() throws InterruptedException {
		
		profPage.spendingExplorerClick();
		Thread.sleep(2000);
		profPage.federalAccoutsDropDownClick();
		profPage.keywordSerachClick();
		Thread.sleep(2000);
		profPage.agenciesDropDownClick();
		Thread.sleep(2000);
		profPage.awardDataArchiveClick();
		Thread.sleep(2000);
		profPage.glossaryClick();
		Thread.sleep(2000);
		profPage.logoClick();
	}
}
