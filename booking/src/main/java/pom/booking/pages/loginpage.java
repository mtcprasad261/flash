package pom.booking.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import pom.booking.base.basepage;
import pom.booking.util.constants;

public class loginpage extends basepage {
	@FindBy(id="username")
	public WebElement Email;
	@FindBy(id="password")
	public WebElement Password;
	@FindBy(className="rmCheckBox  appendRight10")
	public WebElement Checkbox;
	@FindBy(className="capText font16")
	public WebElement Loginbutton;
	
	public loginpage(WebDriver driver, ExtentTest etest) {
		this.driver = driver;
		this.etest = etest;
	}
//Reusable methods for login page
	public boolean createlogin() {
		Email.sendKeys(constants.USERNAME);
		etest.log(LogStatus.INFO, "Entered Username");
		Password.sendKeys(constants.PASSWORD);
		etest.log(LogStatus.INFO, "Entered Password");
		//Checkbox.click();
		//etest.log(LogStatus.INFO, "");
		Loginbutton.click();
		etest.log(LogStatus.INFO, "login button was clicked");
		homepage homepages = new homepage(driver,etest);
		PageFactory.initElements(driver, homepages);
		boolean loginstatus = homepages.verifyDispalyofHomePage();
		return loginstatus;
	}
}
