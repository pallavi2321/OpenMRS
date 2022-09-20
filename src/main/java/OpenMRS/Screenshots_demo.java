package OpenMRS;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Screenshots_demo {


	public static String screenshot(WebDriver driver) throws IOException {
		String currentdate = getCurrentDateandTime();
		String FilePath = "C:\\Users\\Admin\\technogeeks\\First_maven_project\\Screenshots\\";
		//String FileName = d.toString().replace(":", "_").replace(" ", "_") + ".png";
		String FileName = currentdate+".jpg";

		//String screenshotPath ="C:\\Users\\Admin\\technogeeks\\First_maven_project\\Screenshots\\" + getCurrentDateandTime() + ".png" ;
		String screenshotPath = System.setProperty("user.dir", "\\Screenshots" + getCurrentDateandTime() + ".jpg");

		System.out.println(screenshotPath);
		File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE); 
		FileHandler.copy(screenshot, new File(FilePath + FileName)); 

		
		//FileHandler.copy(screenshot, new File(screenshotPath));
		return screenshotPath;
	} 

	public static String getCurrentDateandTime() {
		DateFormat customdate = new SimpleDateFormat("MM_dd_yyyy_HH_mm_ss");
		Date currentdate = new Date();
		String date = customdate.format(currentdate);
		return date;
	}

}


/*TakesScreenshot scrshot = ((TakesScreenshot) driver);
File scrfile = scrshot .getScreenshotAs(OutputType.FILE);
File destfile = new File("C:\\Users\\Admin\\technogeeks\\First_maven_project\\Screenshots\\currentdate.png");
FileUtils.copyFile(scrfile, destfile); */







