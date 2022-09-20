package OpenMRS;

import java.io.IOException;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import Pages.LoginPage;
import Pages.RegisterPatient;
import Pages.functionality_openmrs;

public class TC_05_RegisterPatient extends BaseClass {
	
	@Test
	public void registerPatient() throws Exception {
		
	LoginPage lp= new LoginPage(driver);
	lp.loginOpenMRS(obj.getProperty("username"), obj.getProperty("password")); 
	
	functionality_openmrs loc = new functionality_openmrs(driver);
	loc.registerPatientRecord();	
	
	RegisterPatient rp = new RegisterPatient(driver);
	rp.register();
	
	Screenshots_demo.screenshot(driver);
	
	Implicit_wait(10);
	loc.logOut();
	
	String str = this.getClass().getName();
	
	System.out.println(str);
	
	}
		
}
