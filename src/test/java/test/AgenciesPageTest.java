package test;

import static utility.Config.getPropValue;

import org.junit.AfterClass;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.AgencyPage;
import pages.ProfilePage;
import utility.Driver;

public class AgenciesPageTest {
    private WebDriver driver;
    private AgencyPage ap;
    private ProfilePage pp;


    @BeforeClass
    public void setup() {
        driver = Driver.getDriver("chrome");
        driver.get(getPropValue("url"));

    }

    @Test
    public void test1() {
        pp = new ProfilePage(driver);
        pp.agenciesDropDownClick();
        waitFor(3);
    }

    @Test
    public void test2() {
        ap = new AgencyPage(driver);
        ap.searchDepartment(getPropValue("department"));
        waitFor(2);


    }

    @AfterClass
    public void tearDown() {
        waitFor(3);
        driver.quit();
    }


    public static void waitFor(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            System.out.println(e);
        }
    }


}
