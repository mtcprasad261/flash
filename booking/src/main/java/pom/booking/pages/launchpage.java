package pom.booking.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import pom.booking.base.basepage;
import pom.booking.util.constants;

public class launchpage extends basepage {
	//webElements
	@FindBy(className="makeFlex hrtlCenter font10 makeRelative lhUser")
	public WebElement Loginaccount;
	public launchpage(WebDriver driver, ExtentTest etest) {
		this.driver = driver;
		this.etest = etest;
	}
	public boolean gotologinpage() {
		driver.get(constants.APP_URL);
		etest.log(LogStatus.INFO,"Application URL"+constants.APP_URL+"got opened");
		Loginaccount.click();
		etest.log(LogStatus.INFO,"Login option clicked");
		loginpage loginpages = new loginpage(driver,etest);
		PageFactory.initElements(driver, loginpages);
		boolean loginstatus = loginpages.createlogin();
		return loginstatus;
	}
}
