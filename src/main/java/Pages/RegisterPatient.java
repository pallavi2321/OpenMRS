package Pages;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import OpenMRS.ExcelDataConfig;

public class RegisterPatient {
	WebDriver driver;
	By name = new By.ByXPath("//input[@name='givenName']");
	By middlename = new By.ByXPath("//input[@name='middleName']");
	By familyname = new By.ByXPath("//input[@name='familyName']");
	By next_button = new By.ByXPath("//button[@id='next-button']");
	By genderval = new By.ByXPath("//select[@id='gender-field']");
	By day = new By.ByXPath("//input[@id='birthdateDay-field']");
	By monthval = new By.ByXPath("//select[@id='birthdateMonth-field']");
	By year = new By.ByXPath("//input[@id='birthdateYear-field']");
	By address1 = new By.ByXPath("//input[@id='address1']");
	By address2 = new By.ByXPath("//input[@id='address2']");
	By city = new By.ByXPath("//input[@id='cityVillage']");
	By state = new By.ByXPath("//input[@id='stateProvince']");
	By country = new By.ByXPath("//input[@id='country']");
	By postalCode = new By.ByXPath("//input[@id='postalCode']");
	By phone = new By.ByXPath("//input[@name='phoneNumber']");
	By relationval = new By.ByXPath("//select[@id='relationship_type']");
	By Person_relation = new By.ByXPath("//input[@placeholder='Person Name']");
	By confirm = new By.ByXPath("//input[@id='submit']");

	public RegisterPatient(WebDriver dvr) {
		driver = dvr;
	}
	public void register() throws Exception {
		ExcelDataConfig excel = new ExcelDataConfig();
		HashMap<String, String> TD= excel.ExcelOperations(3);
				
		driver.findElement(name).sendKeys(TD.get("name"));
		driver.findElement(middlename).sendKeys(TD.get("middlename"));
		driver.findElement(familyname).sendKeys(TD.get("familyname"));
		driver.findElement(next_button).click();
		Thread.sleep(1000);
		Select gender = new Select (driver.findElement(genderval));
		gender.selectByVisibleText(TD.get("genderval"));

		driver.findElement(next_button).click();
		Thread.sleep(1000);
		driver.findElement(day).sendKeys(TD.get("day"));
		Select month = new Select (driver.findElement(monthval));
		month.selectByVisibleText(TD.get("month"));
		driver.findElement(year).sendKeys(TD.get("year"));
		driver.findElement(next_button).click();
		Thread.sleep(1000);
		driver.findElement(address1).sendKeys(TD.get("address1"));
		driver.findElement(address2).sendKeys(TD.get("address2"));
		Thread.sleep(1000);
		driver.findElement(city).sendKeys(TD.get("city"));
		driver.findElement(state).sendKeys(TD.get("state"));
		driver.findElement(country).sendKeys(TD.get("country"));
		driver.findElement(postalCode).sendKeys(TD.get("postalCode"));
		driver.findElement(next_button).click();
		Thread.sleep(1000);
		driver.findElement(phone).sendKeys(TD.get("phone"));
		Thread.sleep(1000);
		driver.findElement(next_button).click();
		Thread.sleep(1000);
		Select relation = new Select (driver.findElement(relationval));
		Thread.sleep(1000);
		relation.selectByVisibleText(TD.get("relation"));
		driver.findElement(Person_relation).sendKeys(TD.get("Person_relation"));
		driver.findElement(next_button).click();
		Thread.sleep(1000);
		driver.findElement(confirm).click();

	}

}



