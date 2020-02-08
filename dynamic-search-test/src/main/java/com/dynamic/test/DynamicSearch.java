package com.dynamic.test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class DynamicSearch {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");

		ChromeDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();

		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		driver.get("https://www.google.com");

		System.out.println("Parent Page Title : " + driver.getTitle());
		driver.findElement(By.name("q")).sendKeys("lexisnexis");
		List<WebElement> list = driver
				.findElements(By.xpath("//ul[@role='listbox']//li/descendant::div[@class='sbl1']"));

		System.out.println("total number of suggestions in searchbox::: " + list.size());

		for (WebElement element : list) {
			if (element.getText().contains("lexisnexis careers")) {
				System.out.println("Element Name :" + element.getText());
				element.click();
				System.out.println("Result Page Title : " +driver.getTitle());
				break;
			}
		}
		
		driver.quit();

	}

}
