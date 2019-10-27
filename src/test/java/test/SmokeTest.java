package test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.ProfilePage;
import utility.Config;
import utility.Driver;

import static test.AgenciesPageTest.waitFor;

public class SmokeTest {
    private WebDriver driver;
    private ProfilePage profPage;
    private ExtentReports report;
    private ExtentTest test;


    @BeforeClass
    public void setUp() {
        report = new ExtentReports("/USSpendingMavenTest/src/test/resources/SmokeTest.html");
        test = report.startTest("Report for US Spending app");
        driver = Driver.getDriver("chrome");
        test.log(LogStatus.INFO, "Chrome has been set up as Browser");
        profPage = new ProfilePage(driver);
        driver.get(Config.getPropValue("url"));
        test.log(LogStatus.INFO, "Application under test is loaded");
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
        test.log(LogStatus.INFO, "Browser quit");
        report.endTest(test);
        report.flush();
    }

    @Test
    public void test1() {
        test.log(LogStatus.INFO, "Home page loaded");
        waitFor(2);
        profPage.spendingExplorerClick();
        test.log(LogStatus.INFO, "Clicked on Spending Explorer link, the page is loaded and functional");
        waitFor(2);
        profPage.federalAccoutsDropDownClick();
        test.log(LogStatus.INFO, "Fedral Accounts page is functional and up");
        waitFor(2);
        profPage.keywordSerachClick();
        test.log(LogStatus.INFO, "Hovered over Award Search dropdown, WebElement is functional, Keyword Search page loaded when clicked on Keyword Search link");
        waitFor(2);
        profPage.agenciesDropDownClick();
        test.log(LogStatus.INFO, "Hovered over Profiles dropdown. Element is funcional and Agencies/Federal Accounts links are clickable");
        waitFor(2);
        profPage.awardDataArchiveClick();
        test.log(LogStatus.INFO, "Hovered over Download Center dropdown, it is functional, clicked on Award Data Archive link, links are clickable");
        waitFor(2);
        profPage.glossaryClick();
        test.log(LogStatus.INFO, "Clicked on Glossary link. Glossary opened and functional");
        waitFor(2);
        profPage.logoClick();
        test.log(LogStatus.INFO, "Clicked on logo and navigated to Home page");
    }
}
