package com.inetbanking.testCase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class BaseClass {

	// https://demo.guru99.com/v4/
	// usrid = mngr464321
	// pws = yzYgumY

	public static String baseURL = "https://demo.guru99.com/v4/";
	public static String username = "mngr464321";
	public static String password = "yzYgumY";
	public static WebDriver driver;

	public static void main(String[] args) {

		setup();
		// getMethod();
		navigateMethod();

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

		if (expectedTitle.equals(actuleTitle)) {
			System.out.println("Test is pass");

		} else {
			System.out.println("Test is fild becouse the expected title is " + "\"" + expectedTitle + "\" "
					+ "but actule title is " + "\"" + actuleTitle + "\" ");
		}

	}

	public static void getMethod() {
		System.out.println("******************************************************/n");
		System.out.println("1. Get current url: " + driver.getCurrentUrl());
		System.out.println("******************************************************/n");
		System.out.println("2. Get window handle : " + driver.getWindowHandle());
		System.out.println("******************************************************/n");
		System.out.println("3. Get class :  " + driver.getClass());
		System.out.println("******************************************************/n");
		System.out.println("4. Get page source: " + driver.getPageSource());
	}

	public static void navigateMethod() {
		driver.get(baseURL);
		System.out.println(driver.getTitle());

		driver.navigate().to("http://www.facebook.com");
		System.out.println(driver.getTitle());

		driver.navigate().back();
		System.out.println(driver.getTitle());

		driver.navigate().forward();
		System.out.println(driver.getTitle());

		driver.navigate().refresh();
	}

	@AfterClass
	public static void tearDown() {

		driver.quit();
	}
}
