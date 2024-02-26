package com.noorteck.seleniumhw;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import utils.Hooks;

public class Ex11 extends Hooks {

	public static void main(String[] args) throws InterruptedException {
		setUp();

		rightClick();

		tearDown();
	}

	public static void rightClick() throws InterruptedException {

		driver.get("https://demo.guru99.com/test/simple_context_menu.html");

		WebElement rightClickButton = driver.findElement(By.xpath("//*[@id=\"authentication\"]/span"));

		Actions actions = new Actions(driver);

		actions.contextClick(rightClickButton).build().perform();
		
	//	WebElement copyLink = driver.findElement(By.xpath("//*[@id=\"authentication\"]/ul/li[3]"));
		
		WebElement copyLink = driver.findElement(By.xpath("//li[@class='context-menu-item context-menu-icon context-menu-icon-copy']"));
		
		actions.click(copyLink).build().perform();

		Alert alertObj = driver.switchTo().alert();

		String text = alertObj.getText();

		if (text.contains("copy")) {
			System.out.println("TESTCASED PASS");

		} else {
			System.out.println("TESTCASED FAILED");
		}

	}
}
