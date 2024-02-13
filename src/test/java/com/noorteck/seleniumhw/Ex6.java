package com.noorteck.seleniumhw;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;

import utils.Hooks;

public class Ex6 extends Hooks {

	public static void main(String[] args) throws InterruptedException {

		setUp();

		driver.get("https://demo.automationtesting.in/Alerts.html");

		String pageTitle = driver.getTitle();
		if (pageTitle.equals("Alerts")) {
			System.out.println("Page Title: " + pageTitle);
		}
		WebElement alertTextbox = driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div[1]/ul/li[3]/a"));
		alertTextbox.click();

		Thread.sleep(2000);

		WebElement demoButton = driver.findElement(By.xpath("//*[@id=\"Textbox\"]/button"));
		demoButton.click();

		Thread.sleep(2000);

		Alert alertObj = driver.switchTo().alert();

		alertObj.sendKeys("Jeremy");

		Thread.sleep(3000);

		alertObj.accept();

		Thread.sleep(2000);

		WebElement verifMessage = driver.findElement(By.xpath("//*[@id=\"demo1\"]"));
		String message = verifMessage.getText();
		if (message.contains("How are you today")) {
			System.out.println("It does contain: How are you today");
		}

		driver.navigate().refresh();

		WebElement alertOkCancelField = driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div[1]/ul/li[2]/a"));
		alertOkCancelField.click();

		Thread.sleep(2000);

		WebElement confirmBox = driver.findElement(By.xpath("//*[@id=\"CancelTab\"]/button"));
		confirmBox.click();

		Thread.sleep(2000);

		Alert alertObj1 = driver.switchTo().alert();

		String verify = alertObj1.getText();
		if (verify.contains("Press a Button !")) {
			alertObj1.dismiss();
		} else {
			alertObj1.accept();
		}

		Thread.sleep(2000);

		WebElement verifyMessage = driver.findElement(By.id("demo"));
		String message1 = verifyMessage.getText();
		if(message1.contains("You Pressed")) {
			System.out.println("Message does contain: You Pressed: " + message1);
		}

		tearDown();

		
	}
}
