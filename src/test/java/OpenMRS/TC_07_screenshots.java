package OpenMRS;

import java.io.IOException;

import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.Test;

public class TC_07_screenshots extends BaseClass {
	
	@Test
	public void takescreenshot() throws IOException {
		logger = extent.createTest("Take Screenshot");
		
		Screenshots_demo ss = new Screenshots_demo();
		ss.screenshot(driver);
		logger.pass("screenshot successful.....");
	//	logger.fail("Unable to take screenshot");
		
	}

}
