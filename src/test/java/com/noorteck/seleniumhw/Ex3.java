package com.noorteck.seleniumhw;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import utils.Hooks;

public class Ex3 extends Hooks {

	public static void main(String[] args) throws InterruptedException {

		setUp();

		driver.get("https://demo.nopcommerce.com/");

		Thread.sleep(2000);

		WebElement registerButton = driver
				.findElement(By.xpath("/html/body/div[6]/div[1]/div[1]/div[2]/div[1]/ul/li[1]/a"));
		registerButton.click();

		String pageTitle = driver.getTitle();

		if (pageTitle.contains("nopCommerce demo store. Register")) {
			System.out.println("Page title: " + pageTitle);
		}

		WebElement maleButton = driver.findElement(By.id("gender-male"));
		maleButton.click();
		Thread.sleep(2000);

		WebElement firstnameField = driver.findElement(By.name("FirstName"));
		firstnameField.sendKeys("Jeremy");

		WebElement lastnameField = driver.findElement(By.name("LastName"));
		lastnameField.sendKeys("Asuncion");

		WebElement dateField = driver.findElement(By.name("DateOfBirthDay"));

		Select selectObj = new Select(dateField);

		selectObj.selectByIndex(26);

		WebElement monthField = driver.findElement(By.name("DateOfBirthMonth"));

		Select selectObj1 = new Select(monthField);

		List<WebElement> monthList = selectObj1.getOptions();

		for (WebElement month : monthList) {
			String monthStr = month.getText();
			if (monthStr.equals("December")) {
				month.click();
				break;
			}
		}

		WebElement yearField = driver.findElement(By.name("DateOfBirthYear"));

		Select selectObj2 = new Select(yearField);

		selectObj2.selectByVisibleText("1993");

		WebElement emailField = driver.findElement(By.id("Email"));
		emailField.sendKeys("rukrusho@gmail.com");

		WebElement companyField = driver.findElement(By.id("Company"));
		companyField.sendKeys("amazin");

		WebElement newsCheck = driver.findElement(By.id("Newsletter"));
		newsCheck.click();

		WebElement passwordField = driver.findElement(By.id("Password"));
		passwordField.sendKeys("1234Java");

		WebElement completeRegister = driver
				.findElement(By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/div[1]"));
		String complete = completeRegister.getText();
		if (complete.equals("Your registration completed!!!")) {
			System.out.println("TESTCASE PASSED");
		} else {
			System.out.println("TESTCASE FAILED");
		}

		tearDown();
	}
}
