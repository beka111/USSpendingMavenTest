package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	private WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// checking the title
	public boolean isAt() {
		boolean res = driver.getTitle().equals("USAspending.gov");
		System.out.println("The title is same: " + res);
		return res;
	}

	public boolean checkUrl(String expected) {
		boolean res = driver.getCurrentUrl().equals(expected);
		return res;
	}

	// ============= All the WebElements in HomePage ================

	@FindBy(xpath = "//span[.='Spending Explorer']")
	public WebElement sependingExplorer;

	@FindBy(xpath = "(//div[@class='nav-dropdown'])[1]")
	public WebElement awardSearch;

	@FindBy(xpath = "//div[.='Profiles']")
	public WebElement profiles;
	
	//@FindBy(xpath =)
//	public WebElement agencies;

	@FindBy(xpath = "//div[.='Download Center']")
	public WebElement downloadCenter;

	@FindBy(xpath = "(//div[.='Glossary'])[2]")
	public WebElement glossary;

	@FindBy(xpath = "//button[@class='hero-button__button']")
	public WebElement arrowPointingDown;

	// =========== Click methods ====================

	public void clickSpendingExplorer() {
		sependingExplorer.click();
	}

}
