package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProfilePage {
	public ProfilePage() {
		PageFactory federalPage = new PageFactory();

	}

	@FindBy(xpath = "//h1[contains(text(),'Federal Account Profiles')]")
	WebElement fedAccoutProfiles;

	public boolean verifyFedAccoutnProf() {
		return fedAccoutProfiles.getText().equals("Federal Account Profiles");
	}

	@FindBy(xpath = "//h2[contains(text(),'Find a Federal Account Profile')]")
	WebElement findFedAccProfile;

	public boolean verifyFindFedAccProfile() {
		return findFedAccProfile.getText().equals("Find a Federal Account Profile.");
	}

	@FindBy(xpath = "//ul[@class='pager']//preceding::div[@class='pagination']/div[@class='pagination__totals']")
	WebElement results;

	public boolean VerifyResults() {
		return results.getText().equals("1-50 of 1668 results");
	}
	
	
	
	
}
