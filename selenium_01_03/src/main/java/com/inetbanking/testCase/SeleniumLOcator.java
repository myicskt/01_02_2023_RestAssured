package com.inetbanking.testCase;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class SeleniumLOcator {
	public static String baseURL = "https://demo.guru99.com/v4/";
	public static String username = "mngr464321";
	public static String password = "yzYgumY";
	public static WebDriver driver;

	public static void main(String[] args) {

		setup();
		

		tearDown();
	}

	public static void setup() {

		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/drivers/chromedriver");
		driver = new ChromeDriver();
		driver.get(baseURL);

		// create the WebElement
		WebElement usernameid = driver.findElement(By.name("uid"));
		WebElement userpassword = driver.findElement(By.name("password"));
		WebElement submit = driver.findElement(By.name("btnLogin"));

		// action using WebElement
		usernameid.sendKeys(username);
		userpassword.sendKeys(password);
		submit.click();

		String expectedTitle = "Guru99 Bank Manager HomePage";
		String actuleTitle = driver.getTitle();
		Assert.assertEquals(expectedTitle, actuleTitle);
//		
//		if (expectedTitle.equals(actuleTitle)) {
//			System.out.println("Test is pass");
//
//		} else {
//			System.out.println("Test is fild becouse the expected title is " + "\"" + expectedTitle + "\" "
//					+ "but actule title is " + "\"" + actuleTitle + "\" ");
//		}

	}


	@AfterClass
	public static void tearDown() {

		driver.quit();
	}

}
