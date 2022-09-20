package OpenMRS;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeDriverService;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class BaseClass {
	public WebDriver driver;
	Properties obj;
	String browser;
	String loggerpath;
	public ExcelDataConfig excel;
	ExtentHtmlReporter htmlReporter;
	ExtentReports extent;		//helps to generate the logs in the test report.
	ExtentTest logger;

	@BeforeSuite
	public void setupSuite() throws Exception {
		excel = new ExcelDataConfig();
		loggerpath ="C:\\Users\\Admin\\technogeeks\\First_maven_project\\Extent_reports\\"+ Screenshots_demo.getCurrentDateandTime() + "_.html";
		htmlReporter = new ExtentHtmlReporter(loggerpath);
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
	}

	@BeforeClass
	public void DriverSetup() throws IOException {
		//File src = new File(("user.dir")+"\\config_files\\config.properties");
		//objfile = new FileInputStream(src);
		obj = new Properties();
		FileInputStream objfile = new FileInputStream(System.getProperty("user.dir")+"\\config_files\\config.properties");
		obj.load(objfile);

		browser=obj.getProperty("browser");

		if(browser.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver",obj.getProperty("driverpath"));
			driver = new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("edge"))
		{
			System.setProperty("webdriver.edge.driver",obj.getProperty("driverpath"));
			driver = new EdgeDriver();

			driver.get(obj.getProperty("url"));
			driver.manage().deleteAllCookies();
			driver.manage().window().maximize();
			//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		}
	}
	public void Implicit_wait(int sec) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(sec));

	}


	@AfterMethod //takes screenshot if test case is failed
	public void tearDownMethod(ITestResult result) throws IOException {
		if(result.getStatus()==ITestResult.FAILURE)
		{
			String str = Screenshots_demo.screenshot(driver);
			System.out.println("str:" +str);
			//Screenshots_demo.screenshot(driver);
			logger.fail("Test failed", MediaEntityBuilder.createScreenCaptureFromPath(Screenshots_demo.screenshot(driver)).build()); 	  
		}
		else if(result.getStatus()==ITestResult.SUCCESS)
		{
			String str = Screenshots_demo.screenshot(driver);
			System.out.println("str:" +str);
			logger.pass("Test Passed", MediaEntityBuilder.createScreenCaptureFromPath(Screenshots_demo.screenshot(driver)).build());
			
		}
		/*else if(result.getStatus()==ITestResult.SKIP) {
			String str = Screenshots_demo.screenshot(driver);
			System.out.println("str:" +str);
			logger.skip("Test skipped", MediaEntityBuilder.createScreenCaptureFromPath(Screenshots_demo.screenshot(driver)).build());
		}*/
		extent.flush();
	}
	
	@AfterClass
	public void postTC() {
		driver.quit();
	}
}


/**/ 
