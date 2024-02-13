package com.noorteck.seleniumhw;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import utils.Hooks;

public class Ex2 extends Hooks {

	public static void main(String[] args) throws InterruptedException {

		setUp();

		driver.get("https://demo.guru99.com/test/newtours/");

		Thread.sleep(2000);

		WebElement registerButton = driver.findElement(
				By.xpath("/html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[2]/td/table/tbody/tr/td[2]/a"));
		registerButton.click();

		Thread.sleep(2000);

		String title = driver.getTitle();
		if (title.equals("Mercury Tours")) {
			System.out.println(title);
		} else {
			System.out.println("Not" + title);
		}

		WebElement firstnameField = driver.findElement(By.name("firstName"));
		firstnameField.sendKeys("Jeremy");

		WebElement lastnameField = driver.findElement(By.name("lastName"));
		lastnameField.sendKeys("Asuncion");

		WebElement phoneNumField = driver.findElement(By.name("phone"));
		phoneNumField.sendKeys("911-911-9111");

		WebElement emailField = driver.findElement(By.name("userName"));
		emailField.sendKeys("rukrusho@gmail.com");

		WebElement addressField = driver.findElement(By.name("address1"));
		addressField.sendKeys("1234 JavaLand Lane");

		WebElement cityField = driver.findElement(By.name("city"));
		cityField.sendKeys("Java");

		WebElement stateField = driver.findElement(By.name("state"));
		stateField.sendKeys("Virginia");

		WebElement zipcodeField = driver.findElement(By.name("postalCode"));
		zipcodeField.sendKeys("22026");

		WebElement usernameField = driver.findElement(By.id("email"));
		usernameField.sendKeys("Amazin");

		WebElement passwordField = driver.findElement(By.name("password"));
		passwordField.sendKeys("1234Java");

		WebElement confirmField = driver.findElement(By.name("confirmPassword"));
		confirmField.sendKeys("1234Java");

		Thread.sleep(3000);

		WebElement submitButton = driver.findElement(By.name("submit"));
		submitButton.click();

		Thread.sleep(3000);

		WebElement confirmRegister = driver.findElement(By.xpath(
				"/html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[3]/td/p[2]/font"));
		String confirmStr = confirmRegister.getText();
		if (confirmStr.contains("Thank you for registering")) {
			System.out.println("TESTCASE PASSED");
		} else {
			System.out.println("TESTCASE FAILED");
		}

		tearDown();

	}
}
