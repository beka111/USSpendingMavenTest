package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SpendingExplorerPage {

	private WebDriver driver;

	public SpendingExplorerPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	// ========= WebElement for Spending Explorer Page =============

	@FindBy(xpath = "(//a[.='Start'])[1]")
	public WebElement BudgetFunction;

	@FindBy(xpath = "(//a[.='Start'])[2]")
	public WebElement Agency;

	@FindBy(xpath = "(//a[.='Start'])[3]")
	public WebElement ObjectClass;

	// =========== Clicking Methods ================================

	public void clickBudgetFuction() {
		BudgetFunction.click();
	}

	public void clickAgency() {
		Agency.click();
	}

	public void clickObjectClass() {
		ObjectClass.click();
	}

}
