package Pages;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ById;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class LoginPage {
	WebDriver driver;
//	Properties obj;
	By username = new By.ById("username");
	By password = new By.ById("password");
	By locator = new By.ById("Outpatient Clinic");
	By loginbutton = new By.ById("loginButton");

	public LoginPage(WebDriver dvr) throws IOException {
		driver = dvr;
	//	obj = new Properties();
	//	FileInputStream objfile = new FileInputStream(System.getProperty("user.dir")+"\\config_files\\config.properties");
	//	obj.load(objfile);
	}
	
	public void loginOpenMRS(String un, String pw) {
		driver.findElement(username).sendKeys(un);
		driver.findElement(password).sendKeys(pw);
		//driver.findElement(By.id(obj.getProperty("locator"))).click();
		driver.findElement(locator).click();
		driver.findElement(loginbutton).click();
	}

}



