package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class functionality_openmrs {
	WebDriver driver;
	By patientrecord = new By.ByXPath("//div[@id='apps']/a[1]");
	By registerpatient = new By.ByXPath("//div[@id='apps']/a[3]");
	By logout = new By.ByXPath("//li[@class='nav-item logout']");
	By appointment = new By.ByXPath("//div[@id='apps']/a[5]");
	
	public functionality_openmrs (WebDriver dvr) {
		driver = dvr;
	}
		
	public void findPatientRecord() {
		driver.findElement(patientrecord).click();
	}
	public void registerPatientRecord() {
		driver.findElement(registerpatient).click();
	}
	public void appointmentscheduling() {
		driver.findElement(appointment).click();
	}
	public void logOut() {
		driver.findElement(logout).click();
	}

}
