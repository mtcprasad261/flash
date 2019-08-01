package pom.booking.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.relevantcodes.extentreports.ExtentTest;
import pom.booking.base.basepage;

public class homepage extends basepage {
	@FindBy(className="chNavIcon appendBottom2 chSprite chFlights active")
	public WebElement Flights;
	@FindBy(className="fsw_inputField font30 lineHeight36 latoBlack")
	public WebElement From;
	@FindBy(className="fsw_inputField font30 latoBlack")
	public WebElement To;
	@FindBy(className="dateInnerCell")
	public WebElement Depature;
	@FindBy(className="lbl_input latoBold appendBottom10")
	public WebElement Travellar;
	@FindBy(xpath="//*[@id=\\\"root\\\"]/div/div[2]/div/div[2]/div[1]/div[5]/div[1]/div/ul[1]/li[2]")
	public WebElement Passenger;
	@FindBy(className="selected")
	public WebElement Business;
	@FindBy(className="primaryBtn btnApply pushRight")
	public WebElement Apply;
	@FindBy(className="primaryBtn font24 latoBlack widgetSearchBtn")
	public WebElement Search;
	@FindBy(className="fli_primary_btn text-uppercase")
	public WebElement Booknow;
	@FindBy(className="font16 latoBold blackText appendBottom5 makeFlex hrtlCenter")
	public WebElement Logout;
	
	
	public homepage(WebDriver driver, ExtentTest etest) {
		this.driver = driver;
		this.etest = etest;
	}
	public boolean verifyDispalyofHomePage() {
		return(isElementPresent(Flights));
	}

}
