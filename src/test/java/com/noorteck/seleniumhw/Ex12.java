package com.noorteck.seleniumhw;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import utils.Hooks;

public class Ex12 extends Hooks {

	public static void main(String[] args) throws InterruptedException {
		setUp();
		
		doubleClick();
		
		tearDown();
	}

	public static void doubleClick() {

		driver.get("https://demo.guru99.com/test/simple_context_menu.html");

		WebElement doubleButton = driver.findElement(By.xpath("//button[text()='Double-Click Me To See Alert']"));

		Actions actions = new Actions(driver);

		actions.doubleClick(doubleButton).build().perform();

		Alert alertObj = driver.switchTo().alert();

		String text = alertObj.getText();

		if (text.contains("You double clicked")) {
			System.out.println("TESTCASE PASSED");
		} else {
			System.out.println("TESTCASE FAILED");
		}
	}
}
