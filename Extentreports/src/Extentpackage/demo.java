package Extentpackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;



public class demo {
	ExtentReports ereport;
	ExtentTest eTest;
	
	@Test
	public void sampletest() {
		ereport= Extentmanager.getInstance();
		eTest= ereport.startTest("starting");
		eTest.log(LogStatus.INFO, "started the demo project");
		WebDriver driver = new FirefoxDriver();
		eTest.log(LogStatus.INFO, "window maximize");
		driver.manage().window().maximize();
		eTest.log(LogStatus.INFO, "Blog open");
		driver.get("http://omayo.blogspot.com/");
		eTest.log(LogStatus.INFO, "element clicked");
		driver.findElement(By.linkText("compendiumdev")).click();
		eTest.log(LogStatus.INFO, "closed the browser");
		driver.close();
		int age=test1(25,25);

	}
	@AfterMethod
	public void testclousre() {
		ereport.endTest(eTest);
		ereport.flush();		
	}
	public int test1(int ags,int bgs)
	{
		int sum=ags+bgs;
		return sum;
	}
}
public class abc
{
 public void ab2()
 {
	 demo dem=new demo();
	 dem.test1(46);
 }
}
