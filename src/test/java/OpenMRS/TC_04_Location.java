package OpenMRS;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import Pages.LoginPage;

public class TC_04_Location extends BaseClass {
	
	@Test(description="Test case_04_Location validation")
	public void login() throws IOException {

		LoginPage lp= new LoginPage(driver);
		lp.loginOpenMRS(obj.getProperty("username"), obj.getProperty("password"));
		
		String error = driver.findElement(By.xpath("//span[@class='location-error']")).getText();
		System.out.println(error);
		if(error.equals("You must choose a location!"))
			System.out.println("Please select Location ...");
		Implicit_wait(10);
	}

}
