package OpenMRS;

import java.io.IOException;

import org.testng.annotations.Test;

import Pages.LoginPage;
import Pages.appointment_scheduling;
import Pages.functionality_openmrs;


public class TC_06_AppointmentScheduling extends BaseClass{

	@Test
	public void registerPatient() throws InterruptedException, IOException {

		LoginPage lp= new LoginPage(driver);
		lp.loginOpenMRS(obj.getProperty("username"), obj.getProperty("password"));

		functionality_openmrs loc = new functionality_openmrs(driver);
		loc.appointmentscheduling();

		appointment_scheduling aps = new appointment_scheduling(driver);
		aps.appointment();
	}

}
