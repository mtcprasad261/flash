package pom.booking.test.base;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import pom.booking.util.ExtentManager;
import pom.booking.util.constants;

public class basetest {
	public WebDriver driver = null;
	public ExtentReports  ereport = ExtentManager.getInstance();
	public ExtentTest etest = null;
	public void openbrowser(String browsertype){
		
		if(browsertype.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", constants.FIREFOX_DRIVER);
			 driver = new FirefoxDriver();
	} else if (browsertype.equalsIgnoreCase("chrome")) {
		System.setProperty("webdriver.gecko.driver", constants.CHROME_DRIVER);
		 driver = new ChromeDriver();
	}
	etest.log(LogStatus.INFO, "succesfully opened browser"+browsertype);
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
}
	public void reportPass(String message) {
		etest.log(LogStatus.PASS,message);
	}
	public void reportFail(String message) {
		etest.log(LogStatus.FAIL,message);
		takeScreenshot();
		Assert.fail(message);
}
	public void titlereportPass(String message) {
		etest.log(LogStatus.PASS,message);
		System.out.println("Tittle Matched");
	}
	public void titlereportFail(String message) {
		etest.log(LogStatus.FAIL,message);
		System.out.println("Tittle not Matched");
		takeScreenshot();
		Assert.fail(message);
}
public void takeScreenshot(){
		
		Date d=new Date();
		String screenshotFile=d.toString().replace(":", "_").replace(" ", "_")+".png";
		// store screenshot in that file
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(scrFile, new File("screenshots//"+screenshotFile));
		} catch (IOException e) {
			e.printStackTrace();
		}
		//put screenshot file into the reports
		etest.log(LogStatus.INFO,"Screenshot-> "+ etest.addScreenCapture(System.getProperty("user.dir")+"//screenshots//"+screenshotFile));
			
	}
	
}