package pages;


import java.util.List;

import org.openqa.selenium.Keys;
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
	
	@FindBy(xpath="//div[.='Agency Name']")
	public WebElement AgencyNameButton;
	
	@FindBy(xpath="(//button[@value='asc'])[1]")
	public WebElement AgencyNameButtonAssen;
	
	@FindBy(xpath="(//button[@value='desc'])[1]")
	public WebElement AgencyNameButtonDessen;
	
	@FindBy(xpath="//div[.='Budgetary Resources']")
	public WebElement BudgetaryResButton;
	
	@FindBy(xpath="(//button[@value='asc'])[2]")
	public WebElement BudgetaryResButtonAssen;
	
	@FindBy(xpath="(//button[@value='desc'])[2]")
	public WebElement BudgetaryResButtonDessen;
	
	@FindBy(xpath="//div[.='Percent of Total']")
	public WebElement PercentOfTotalButton;
	
	@FindBy(xpath="(//button[@value='asc'])[3]")
	public WebElement PercentOfTotalButtonAssen;
	
	@FindBy(xpath="(//button[@value='desc'])[3]")
	public WebElement PercentOfTotalButtonDessen;
	
	public void searchDepartment(String department) {
		searchBox.sendKeys(department + Keys.ENTER);
	}
}
