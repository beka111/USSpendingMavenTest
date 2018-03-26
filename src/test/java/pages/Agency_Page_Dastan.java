package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Agency_Page_Dastan {
	private WebDriver driver;

	public Agency_Page_Dastan(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//tbody/tr/td[3]")
	public List<WebElement> numberPercentage;

	public boolean checkIfContainsPercentage(List<WebElement> a) {
		boolean con = false;
		int count = 0;
		for (WebElement wb : a) {
			if (wb.getText().contains("%")) {
				con = true;
				count++;
			}
		}
		if (count == a.size() && con) {
			return true;
		}
		return false;

	}
}