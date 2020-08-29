package com.QA.BrokenLinks;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class VerifyingBrokenLinks {

	 static WebDriver driver;
	
	 @Test
	 public void LoginTest(){
			
			WebDriver driver = new FirefoxDriver();
			
			driver.get("https://www.google.com/");
			
			List<WebElement> links = driver.findElements(By.tagName("a"));
			
			System.out.println("Total number of links are:"+links.size());
			
			for(int i=0;i<links.size();i++) {
				
				WebElement ele = links.get(i);
				
				String url= ele.getAttribute("href");
				
				VerifyActiveLinks(url);
			}
			
		}
		
		public static void VerifyActiveLinks(String linkurl) {
			
			try {
				URL url = new URL(linkurl);
				
				HttpURLConnection httpConnect=(HttpURLConnection)url.openConnection();
				
				httpConnect.setConnectTimeout(3000);
				
				httpConnect.connect();
				
				if(httpConnect.getResponseCode()==200) {
					
					System.out.println(linkurl+"-"+httpConnect.getResponseMessage());
				}
				if(httpConnect.getResponseCode()==HttpURLConnection.HTTP_NOT_FOUND) {
					
					System.out.println(linkurl+"-"+httpConnect.getResponseMessage()+"-"+HttpURLConnection.HTTP_NOT_FOUND);
				}
			} catch (Exception e) {
				
				
			}
		}

}
