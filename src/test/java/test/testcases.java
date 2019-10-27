package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.AgencyPage;
import pages.HomePage;
import utility.Config;
import utility.Driver;

import static test.AgenciesPageTest.waitFor;

public class testcases {

    private WebDriver driver;
    private HomePage homePage;
    private AgencyPage agencyPage;

    @BeforeClass
    public void setup() {
        driver = Driver.getDriver("chrome");
        driver.manage().window().fullscreen();

    }

    // First Positive Test Case
    @Test(priority = 1)
    public void USAHM001() {
        homePage = new HomePage(driver);
        agencyPage = new AgencyPage(driver);

        // Step 1
        String exp = Config.getPropValue("url");
        driver.get(Config.getPropValue("url"));
        homePage.checkUrl(exp);
        waitFor(2);
        homePage.isAt();

        // Step 2
        Actions action = new Actions(driver);
        action.moveToElement(homePage.profiles).perform();
        homePage.agencies.click();
        homePage.checkUrl(Config.getPropValue("urlAgency"));
        waitFor(2);
        homePage.isAt();

        // Step 3
        agencyPage.searchBox.click();
        waitFor(2);
        agencyPage.searchBox.sendKeys("Department of Homeland Security");
        Assert.assertTrue(agencyPage.numberOfResult.isDisplayed());

    }

    // First Negative Test Case
    @Test(priority = 2)
    public void USAHM002() {
        homePage = new HomePage(driver);
        agencyPage = new AgencyPage(driver);

        // Step 1
        String exp = Config.getPropValue("url");
        driver.get(Config.getPropValue("url"));
        homePage.checkUrl(exp);
        homePage.isAt();

        // Step 2
        Actions action = new Actions(driver);
        waitFor(2);
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
    public void USAHM003() {
        homePage = new HomePage(driver);
        agencyPage = new AgencyPage(driver);

        // Step 1
        String exp = Config.getPropValue("url");
        driver.get(Config.getPropValue("url"));
        waitFor(2);
        homePage.checkUrl(exp);
        homePage.isAt();

        // Step 2
        Actions action = new Actions(driver);
        action.moveToElement(homePage.profiles).perform();
        homePage.agencies.click();
        homePage.checkUrl(Config.getPropValue("urlAgency"));
        homePage.isAt();

        // Step 3
        waitFor(2);
        String actual = agencyPage.BudgetaryResButton.getCssValue("color");
        System.out.println("The actual color is: " + actual);
        agencyPage.BudgetaryResButton.click();
        String expected = agencyPage.BudgetaryResButtonDessen.getCssValue("color");
        System.out.println("The changed color is: " + expected);
        Assert.assertEquals(actual, expected); // it fails because


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
    public void USAHM004() {
        homePage = new HomePage(driver);
        agencyPage = new AgencyPage(driver);

        // Step 1
        String exp = Config.getPropValue("url");
        driver.get(Config.getPropValue("url"));
        waitFor(2);
        homePage.checkUrl(exp);
        homePage.isAt();

        // Step 2
        Actions action = new Actions(driver);
        action.moveToElement(homePage.profiles).perform();
        homePage.agencies.click();
        homePage.checkUrl(Config.getPropValue("urlAgency"));
        homePage.isAt();

        // Step 3
        String actual = driver
                .findElement(By.xpath("//div[@class='agency-landing-results-table']/table/tbody/tr[1]/td[1]"))
                .getText();
        System.out.println(actual);

        waitFor(2);
        agencyPage.PercentOfTotalButton.click();
        System.out.println("Target===> " + agencyPage.PercentOfTotalButtonDessen.getCssValue("color"));
        Assert.assertTrue(agencyPage.PercentOfTotalButtonDessen.isEnabled(), "The color is not changed");
        String expected = driver
                .findElement(By.xpath("//div[@class='agency-landing-results-table']/table/tbody/tr[1]/td[1]"))
                .getText();
        System.out.println(expected);

        Assert.assertNotEquals(actual, expected, "The table is changed, it's Dessending order now");

    }

    @Test(priority = 5)
    public void USAHM005() {
        homePage = new HomePage(driver);
        agencyPage = new AgencyPage(driver);

        // Step 1
        String exp = Config.getPropValue("url");
        driver.get(Config.getPropValue("url"));
        waitFor(2);
        homePage.checkUrl(exp);
        homePage.isAt();

        // Step 2
        Actions action = new Actions(driver);
        action.moveToElement(homePage.profiles).perform();
        homePage.agencies.click();
        homePage.checkUrl(Config.getPropValue("urlAgency"));
        homePage.isAt();

        // Step 3

        String actual = driver
                .findElement(By.xpath("//div[@class='agency-landing-results-table']/table/tbody/tr[1]/td[1]"))
                .getText();
        System.out.println(actual);

        waitFor(2);

        agencyPage.AgencyNameButton.click();
        System.out.println("Target===> " + agencyPage.PercentOfTotalButtonDessen.getCssValue("color"));
        Assert.assertTrue(agencyPage.PercentOfTotalButtonDessen.isEnabled(), "The color is not changed");
        String expected = driver
                .findElement(By.xpath("//div[@class='agency-landing-results-table']/table/tbody/tr[1]/td[1]"))
                .getText();
        System.out.println(expected);

        Assert.assertNotEquals(actual, expected, "The table is changed, it's Dessending order now");

    }
}