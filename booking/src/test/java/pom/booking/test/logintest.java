package pom.booking.test;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.LogStatus;
import pom.booking.pages.launchpage;
import pom.booking.test.base.basetest;
import pom.booking.util.constants;

public class logintest extends basetest {
	
	@Test
	public void testlogin() {
		etest = ereport.startTest("logintest");
		etest.log(LogStatus.INFO, "Login Test started");
		openbrowser(constants.BROWSER_TYPE);
		launchpage launchpages = new launchpage(driver,etest);
		PageFactory.initElements(driver, launchpages);
		boolean loginstatus = launchpages.gotologinpage();
		if(loginstatus)
		{
			reportPass("Login done sucessfully");
		}
		else {
			reportFail("Login failed");
			
		}

	boolean title = launchpages.gotologinpage();
	if(title)
	{
		titlereportPass("Tittle Matched");
	}
	else {
		titlereportFail("Tittle not Matched");
		
	}
}
	@AfterMethod
	public void testclosure() {
		if(ereport!=null) {
			ereport.endTest(etest);
			ereport.flush();
		}
		if(driver!=null) {
			driver.quit();
		
	}

}
}
