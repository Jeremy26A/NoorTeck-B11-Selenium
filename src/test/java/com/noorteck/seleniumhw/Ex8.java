package com.noorteck.seleniumhw;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import utils.Hooks;

public class Ex8 extends Hooks {

	public static void main(String[] args) throws InterruptedException {
		setUp();

		driver.get("https://demo.automationtesting.in/Frames.html");

		WebElement frame = driver.findElement(By.id("singleframe"));
		driver.switchTo().frame(frame);

		WebElement iframeTextField = driver.findElement(By.xpath("/html/body/section/div/div/div/input"));
		iframeTextField.sendKeys("Accessing iframe");

		Thread.sleep(2000);

		driver.switchTo().defaultContent();

		WebElement withFrameButton = driver
				.findElement(By.xpath("/html/body/section/div[1]/div/div/div/div[1]/div/ul/li[2]/a"));
		withFrameButton.click();

		WebElement withFrame = driver.findElement(By.xpath("//*[@id=\"Multiple\"]/iframe"));
		driver.switchTo().frame(withFrame);

		WebElement demoFrame = driver.findElement(By.xpath("/html/body/section/div/div/iframe"));
		driver.switchTo().frame(demoFrame);

		WebElement withFrameField = driver.findElement(By.xpath("/html/body/section/div/div/div/input"));
		withFrameField.sendKeys("Iframe is easy");

		driver.switchTo().defaultContent();

		WebElement homeButton = driver.findElement(By.cssSelector("a[href=\"Index.html\"]"));
		homeButton.click();

		String title = driver.getTitle();
		if (title.equals("Index")) {
			System.out.println("TESTCASE PASSED");
		} else {
			System.out.println("TESTCASE FAILED");
		}
		Thread.sleep(2000);

		tearDown();
	}
}
