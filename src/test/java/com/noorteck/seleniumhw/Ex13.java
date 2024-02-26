package com.noorteck.seleniumhw;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import utils.Hooks;

public class Ex13 extends Hooks {

	public static void main(String[] args) throws InterruptedException {
		setUp();

		dragAndDrop();

		tearDown();
	}

	public static void dragAndDrop() {

		driver.get("http://dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html");

		List<WebElement> capitals = driver.findElements(By.xpath("//div[@id='capitals']//div"));

		List<WebElement> countries = driver.findElements(By.xpath("//div[@id='countries']//div"));

		WebElement rome = driver.findElement(By.xpath("//div[@id='box6']"));

		WebElement italy = driver.findElement(By.xpath("//div[@id='box106']"));
		WebElement spain = driver.findElement(By.xpath("//div[@id='box107']"));
		WebElement norway = driver.findElement(By.xpath("//div[@id='box101']"));
		WebElement denmark = driver.findElement(By.xpath("//div[@id='box104']"));
		WebElement southKorea = driver.findElement(By.xpath("//div[@id='box105']"));
		WebElement sweden = driver.findElement(By.xpath("//div[@id='box102']"));
		WebElement unitedStates = driver.findElement(By.xpath("//div[@id='box103']"));

		Actions actions = new Actions(driver);

		// actions.dragAndDrop(rome, italy).build().perform();

		for (WebElement capt : capitals) {
			String captText = capt.getText();
			for (WebElement country : countries) {
				String countryText = country.getText();
				if (captText.equals("Rome") && countryText.equals("Italy")) {
					actions.dragAndDrop(capt, country).build().perform();
				} else if (captText.equals("Seoul") && countryText.equals("South Korea")) {
					actions.dragAndDrop(capt, country).build().perform();
				} else if (captText.equals("Madrid") && countryText.equals("Spain")) {
					actions.dragAndDrop(capt, country).build().perform();
				} else if (captText.equals("Washington") && countryText.equals("United States")) {
					actions.dragAndDrop(capt, country).build().perform();
				} else if (captText.equals("Copenhagen") && countryText.equals("Denmark")) {
					actions.dragAndDrop(capt, country).build().perform();
				} else if (captText.equals("Stockholm") && countryText.equals("Sweden")) {
					actions.dragAndDrop(capt, country).build().perform();
				} else if (captText.equals("Oslo") && countryText.equals("Norway")) {
					actions.dragAndDrop(capt, country).build().perform();
				}
			}
		}

	}
}
