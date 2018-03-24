package test;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.TestCases15_20;
import utility.Driver;

public class Tests15_20 {
	WebDriver driver;
	TestCases15_20 test1 = new TestCases15_20();

	@BeforeClass
	public void setup() {
		driver = Driver.getDriver("chrome");
		driver.get("https://www.usaspending.gov/#/");
	}

	@Test (priority=1)
	public void test15() {
		test1.downloadCenterDropDown();
	}

	@Test(priority=2)
	public void test16() {
		try {
			test1.glossaryClick();
		} catch (Exception e) {
			e.getMessage();
		}

	}

	@Test(priority=3)
	public void test17() {
		test1.agenciesDropDownClick();
		test1.administrativeSearch("administrative");
	}

	@Test (priority=4)
	public void test18() {
		test1.agenciesDropDownClick();
		test1.administrativeSearch("National Mediation Board");
	}

	//bug -->>
	@Test (priority=5)
	public void test19() {
		test1.agenciesDropDownClick();
		test1.depOfHousing("Department of Housing and Urban development");
	}

	@Test (priority=6)
	public void test20() throws InterruptedException {
		test1.agenciesDropDownClick();
		Thread.sleep(2000);
		test1.searchBox.sendKeys("Court Services and Offender Supervision Agency");
		test1.searchResult.click();
		Thread.sleep(2000);
		driver.navigate().back();
		Thread.sleep(2000);
		test1.searchBox.sendKeys("Ethics");
		test1.searchResult.click();
		Thread.sleep(2000);
		driver.navigate().back();
//		Thread.sleep(2000);
//		driver.findElement(By.partialLinkText("Office of Government Ethics (OGE)")).click();
//		Thread.sleep(2000);
//		driver.navigate().back();
	}
}
