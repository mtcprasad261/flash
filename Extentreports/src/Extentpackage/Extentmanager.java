package Extentpackage;

import java.io.File;
import java.util.Date;

import com.relevantcodes.extentreports.DisplayOrder;
import com.relevantcodes.extentreports.ExtentReports;

public class Extentmanager {
	public static ExtentReports getInstance() {
		// TODO Auto-generated method stub
		ExtentReports ereport = new ExtentReports("Filepath", true, DisplayOrder.NEWEST_FIRST);
		Date d = new Date();
		String date = d.toString();
		System.out.println(date);
		String updatedate = date.replace("","_").replace(":","_");
		System.out.println(updatedate);
		String Filename=updatedate+".html";
		System.out.println(Filename);
		String Filepath ="reports//"+Filename;
		System.out.println(Filepath);
		File configfile = new File("ReportsConfig.xml");
		ereport.loadConfig(configfile);
		ereport.addSystemInfo("Environment","qa").addSystemInfo("Seleniumversion","2.53.1");
		return ereport;
		
	}

}
