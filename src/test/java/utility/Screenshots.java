package utility;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Screenshots {

	public static String takeScreenshot(WebDriver driver, String fileName)throws IOException{
		fileName=fileName+".png";
		File sourceFile=((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String directory="D:\\SeleniumScreetshot";
		FileUtils.copyFile(sourceFile, new File(directory+fileName));
		String destination=directory+fileName;
		return destination;
	}
	
}
