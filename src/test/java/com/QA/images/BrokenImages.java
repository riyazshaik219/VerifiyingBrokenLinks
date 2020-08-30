package com.QA.images;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class BrokenImages {

	
	@Test
	public void imagesTest() {
		
		WebDriver driver = new FirefoxDriver();
		
		driver.get("https://www.amazon.in/");
		
		List<WebElement> images = driver.findElements(By.tagName("img"));
		
		System.out.println("Total number of images are:"+images.size());
	}
}
