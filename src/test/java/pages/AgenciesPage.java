package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import net.bytebuddy.asm.Advice.Enter;

public class AgenciesPage {
	
	WebDriver driver;
	
	public AgenciesPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath = "//input[@class='search-section__input']")
	WebElement searchTab;
	
	
	public void searchDepartment(String department) {
		searchTab.sendKeys(department + Keys.ENTER);
	}
	

}
