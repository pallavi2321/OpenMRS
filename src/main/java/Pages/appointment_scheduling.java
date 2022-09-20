package Pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.By.ById;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.WebDriver;

public class appointment_scheduling {
	WebDriver driver;
	By manage_service= new By.ByXPath("//a[@id='appointmentschedulingui-manageAppointmentTypes-app']");

	By data= new By.ByXPath("(//div[@id='appointmentTypesTable_wrapper']//table//tr//td[1])[6]");
	By edit = new By.ByXPath("(//i[@title='Edit'])[6]");
	By delete = new By.ByXPath("(//i[@title='Delete'])[6]");
	By text = new By.ById("description-field");
	By save = new By.ById("save-button");
	By delete_alert = new By.ByXPath("(//button[@class='cancel'])[6]");
	//

	public appointment_scheduling(WebDriver dvr) {
		driver = dvr;
	}

	public void appointment() throws InterruptedException {
		System.out.println("appointment scheduling called...");
		driver.findElement(manage_service).click();
		String dept = driver.findElement(data).getText();
		System.out.println(dept);
		if(dept.equals("Gynecology (New Patient)")) {
		//if delete
			driver.findElement(delete).click();
			driver.findElement(delete_alert ).click();
		//	Alert alert= driver.switchTo().alert();
		//	System.out.println(alert.getText());
		//	alert.accept();
		//	 alert.dismiss();
		
		//if edit
		/*driver.findElement(edit).click();		
		driver.findElement(text).sendKeys("branch of medicine that deals with the diagnosis");
		Thread.sleep(3000);
		driver.findElement(save).click();*/ 
		}
	}
}
