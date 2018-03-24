	package pages;

	import java.util.ArrayList;
	import java.util.List;

	import org.junit.Assert;
	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.interactions.Actions;
	import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.PageFactory;

	import utility.Driver;

	public class TestCases15_20 {
		WebDriver driver;
		Actions action;

		public TestCases15_20() {
			driver = Driver.getDriver("chrome");
			PageFactory.initElements(driver, this);
		}

		/**
		 * USS15 Verifying Download Center dropdown options
		 */
		@FindBy(xpath = "//div[.='Download Center']")
		WebElement downloadCenter;

		@FindBy(linkText = "Award Data Archive")
		WebElement awardDataArchive;

		public void downloadCenterDropDown() {
			action = new Actions(driver);
			action.moveToElement(downloadCenter).perform();
			WebElement downloadCenterElement = driver
					.findElement(By.xpath("//button[@title='Download Center']/following-sibling::div"));

			List<WebElement> downloadCenterList = driver
					.findElements(By.xpath("//button[@title='Download Center']/following-sibling::div//a"));
			List<String> actDownloadCenterList = new ArrayList();
			for (WebElement e : downloadCenterList) {
//				System.out.println(e.getText());

				if (e.getText().contains("Coming soon") ) {
					continue;
				}
				actDownloadCenterList.add(e.getText());
			}
			actDownloadCenterList.add(driver.findElement(By.xpath("//button[@title='Download Center']/following-sibling::div//button[.='Database Snapshots']")).getText());

			List<String> expDownloadCenterList = new ArrayList();
			expDownloadCenterList.add("Award Data Archive");
			expDownloadCenterList.add("Custom Award Data");
			expDownloadCenterList.add("Agency Submission Files");
			expDownloadCenterList.add("API");
			expDownloadCenterList.add("Database Snapshots");
			Assert.assertEquals(expDownloadCenterList, actDownloadCenterList);

		}

		/**
		 * USS16
		 * 
		 * Glossary
		 */
		@FindBy(xpath = "//div[.='Glossary']")
		WebElement glossary;

		@FindBy(css = ".close-button")
		WebElement glossaryClose;

		public void glossaryClick() throws InterruptedException {
			glossary.click();
			Thread.sleep(2000);
			glossaryClose.click();

		}

		/**
		 * USS17 Profile Dropdown -> Agencies option
		 * 
		 */
		@FindBy(xpath = "//div[.='Profiles']")
		WebElement profiles;

		@FindBy(xpath = "//a[.='Agencies']")
		WebElement agenciesOption;

		public void agenciesDropDownClick() {
			action = new Actions(driver);
			action.moveToElement(profiles).perform();
			action.moveToElement(agenciesOption).click().perform();
		}

		@FindBy(xpath = "//input[@class='search-section__input']")
		public WebElement searchBox;

		@FindBy(xpath = "//div[@class='search-section__button-icon']")
		public WebElement searchButton;

		@FindBy(xpath = "//div[@class='agency-landing-results-table']//div/a")
		public WebElement searchResult;

		@FindBy(css = ".against-auth-text .number.number-bolder")
		WebElement obligatedAmount;

		// disappearing elements -> need to hover over them
		@FindBy(xpath = "//*[.='Personnel compensation and benefits']")
		WebElement personnelComp;

		
		@FindBy(xpath = "//*[.='Grants and fixed charges']")
		WebElement grantsAndFixedCharges;
		
		@FindBy(xpath = "//*[.='Contractual services and supplies']")
		WebElement contractualServices;

		@FindBy(xpath = "//div[@class='treemap-inner-wrap']/div[@class='visualization-tooltip']//div[@class='tooltip-value']")
		WebElement personnel;

		@FindBy(xpath = "//div[@class='treemap-inner-wrap']/div[@class='visualization-tooltip']//div[@class='tooltip-value']")
		WebElement contactual;

		@FindBy(xpath = "//div[@class='visualization-tooltip']//div[@class='tooltip-body center']//div[@class='tooltip-value']")
		WebElement housingMoney;

		public void depOfHousing(String depOfHous) {
			searchBox.sendKeys(depOfHous);
			searchResult.click();
			action = new Actions(driver);
			action.moveToElement(grantsAndFixedCharges).perform();
			String personnelText = housingMoney.getText().substring(1, 5);
			Double p = Double.parseDouble(personnelText);
			String sumOfTwoAmounts = p.toString();
			Assert.assertEquals(obligatedAmount.getText().substring(1, 5), sumOfTwoAmounts);
		}

		public void administrativeSearch(String searchWord) {
			searchBox.sendKeys(searchWord);
			searchResult.click();
			action = new Actions(driver);
			action.moveToElement(personnelComp).perform();

			// getting number value of $3.5 and $1.5 and asserting with previous value

			String personnelText = personnel.getText().substring(1, 4);
			action.moveToElement(contractualServices).build().perform();
			String contractText = contactual.getText().substring(1, 4);
			Double p = Double.parseDouble(personnelText);
			Double c = Double.parseDouble(contractText);
			Double sum = p + c;
			String sumOfTwoAmounts = sum.toString();
			Assert.assertEquals(obligatedAmount.getText().substring(1, 4), sumOfTwoAmounts);

		}

		/**
		 * USS18
		 * 
		 */
		/**
		 * 1st step need to call agenciesDropDownClick(); method then call
		 * administrativeSearch method and give it "national mediation board" as a
		 * parameter
		 *
		 */

		
		/**
		 * 
		 * USS20
		 * 
		 */
		
		@FindBy(xpath = "//a[.='Federal Accounts']")
		WebElement federalAccoutsDropDown;

		public void federalAccoutsDropDownClick() {
			action = new Actions(driver);
			action.moveToElement(profiles).perform();
			federalAccoutsDropDown.click();
		}

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

	}


