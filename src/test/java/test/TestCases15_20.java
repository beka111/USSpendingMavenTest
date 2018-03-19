package test;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class TestCases15_20 {

	Actions action;

	
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
