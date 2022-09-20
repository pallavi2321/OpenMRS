package OpenMRS;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import Pages.LoginPage;

public class TC_03_InvalidPassword extends BaseClass{

	@Test(description="Test case_03_invalid password validation")
	public void login() throws IOException {

		LoginPage lp= new LoginPage(driver);
		lp.loginOpenMRS(obj.getProperty("username"), obj.getProperty("password"));
		
		String error = driver.findElement(By.xpath("//div[@id='error-message']")).getText();
		System.out.println(error);
		if(error.equals("Invalid username/password. Please try again."))
			System.out.println("Please enter valid password...");
				
		Implicit_wait(10);
	}
}
