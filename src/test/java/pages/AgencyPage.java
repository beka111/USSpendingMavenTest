package pages;


import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AgencyPage {
	private WebDriver driver;

	public AgencyPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@class='search-section__input']")
	public WebElement searchBox;
	
	@FindBy(xpath= "//div[@class='agency-landing-results-table']/table/tbody/tr")
	public List<WebElement>table;
	
	@FindBy(xpath= "//div[@class='search-section__button-icon']")
	public WebElement searchButton;
	
	@FindBy(xpath = "//div[@class='results-count']")
	public WebElement numberOfResult;
	
	@FindBy(xpath= "//div[@class='results-table-message']")
	public WebElement noResult;
	
	
}
