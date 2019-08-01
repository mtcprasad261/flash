package pom.booking.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.relevantcodes.extentreports.ExtentTest;

public class basepage {
	public WebDriver driver = null;
	public ExtentTest etest = null;
	public boolean isElementPresent(WebElement element) {
		boolean dispalystatus= element.isDisplayed();
		if (dispalystatus) {
			return true;
		}else {
			return false;
		}

}
}