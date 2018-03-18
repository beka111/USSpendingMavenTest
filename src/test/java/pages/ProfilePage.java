package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProfilePage {
	WebDriver driver;

	public ProfilePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "logo")
	WebElement logo;

	/**
	 * Verifying logo is displayed and Click on logo to verify it will navigate us
	 * to home page
	 */
	public boolean logoIsThere() {
		return logo.isDisplayed();
	}

	public void logoClick() {
		logo.click();
	}

	@FindBy(css = ".official-banner__text")
	WebElement officialWebSite;

	public boolean officialWebSiteIsThere() {
		return officialWebSite.isDisplayed();
	}

	/**
	 * Spending Explorer link, click
	 */
	@FindBy(linkText = "Spending Explorer")
	WebElement spendingExplorerLink;

	public void spendingExplorerClick() {
		spendingExplorerLink.click();
	}

	/**
	 * Award Search dropdown links: Advanced Search, Keyword Search
	 */

	@FindBy(xpath = "//div[.='Award Search']")
	WebElement awardSearch;

	Actions action;

	@FindBy(linkText = "Advanced Search")
	WebElement advancedSearch;

	public void advancedSearchClick() {
		action = new Actions(driver);
		action.moveToElement(awardSearch).perform();
		advancedSearch.click();
	}

	@FindBy(linkText = "Keyword Search")
	WebElement keywordSearch;

	public void keywordSerachClick() {
		action = new Actions(driver);
		action.moveToElement(awardSearch).perform();
		keywordSearch.click();
	}

	/**
	 * Profiles dropdown links: Agencies, Federal Accounts
	 */

	@FindBy(xpath = "//div[.='Profiles']")
	WebElement profiles;

	@FindBy(xpath = "//a[.='Agencies']")
	WebElement agenciesDropDown;

	public void agenciesDropDownClick() {
		action = new Actions(driver);
		action.moveToElement(profiles).perform();
		action.moveToElement(agenciesDropDown).click().perform();
	}

	@FindBy(xpath = "//a[.='Federal Accounts']")
	WebElement federalAccoutsDropDown;

	public void federalAccoutsDropDownClick() {
		action = new Actions(driver);
		action.moveToElement(profiles).perform();
		federalAccoutsDropDown.click();
	}

	/**
	 * Download Center dropdown links: Award Data Archive, Custom Award Data, Agency
	 * Submission Files, DataBase Snapshots, API
	 */

	@FindBy(xpath = "//div[.='Download Center']")
	WebElement downloadCenter;

	@FindBy(linkText = "Award Data Archive")
	WebElement awardDataArchive;

	public void awardDataArchiveClick() {
		action.moveToElement(downloadCenter).perform();
		awardDataArchive.click();
	}

	@FindBy(xpath = "//div[.='Custom Award Data']")
	WebElement customAwardData;

	public void customawardData() {
		action.moveToElement(downloadCenter).perform();
		customAwardData.click();
	}

	@FindBy(xpath = "//div[.='Agency Submission Files']")
	WebElement agencySubmissionFiles;

	public void agencySubmissionFiles() {
		action.moveToElement(downloadCenter).perform();
		agencySubmissionFiles.click();
	}

	@FindBy(xpath = "//div[.='Database Snapshots']")
	WebElement databaseSnapshots;

	public void databaseSnapshotsClick() {
		action.moveToElement(downloadCenter).perform();
		databaseSnapshots.click();
	}

	@FindBy(xpath = "//div[.='API']")
	WebElement api;

	public void apiClick() {
		action.moveToElement(downloadCenter).perform();
		api.click();
	}

	/**
	 * Glossary
	 */
	@FindBy(xpath = "//div[.='Glossary']")
	WebElement glossary;

	public void glossaryClick() {
		glossary.click();
	}

	/**
	 * Text is present verification
	 */

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

	/**
	 * Verifying the results, agencies table
	 */

	public boolean VerifyResults() {
		return results.getText().equals("1-50 of 1668 results");
	}

	@FindBy(xpath = "//div[.='Account Number']")
	WebElement accountNumber;

	public void accountNumberClick() {
		accountNumber.click();
	}

	@FindBy(xpath = "//div[.='Account Name']")
	WebElement accountName;

	public void accountNameClick() {
		accountName.click();
	}

	@FindBy(xpath = "//div[.='Managing Agency']")
	WebElement managingAgency;

	public void managingAgencyClick() {
		managingAgency.click();
	}

	@FindBy(xpath = "//div[.='2018 Budgetary Resources']")
	WebElement budgetaryResources;

	public void budgetaryRecourcesClick() {
		budgetaryResources.click();
	}

	/**
	 * Agencies list
	 */
	@FindBy(css = ".results-table-cell.results-table-cell_column_accountName")
	WebElement agencies;

	public List<WebElement> agenciesList() {
		List<WebElement> list1 = driver
				.findElements(By.cssSelector(".results-table-cell.results-table-cell_column_accountName"));
		return list1;
	}

}
