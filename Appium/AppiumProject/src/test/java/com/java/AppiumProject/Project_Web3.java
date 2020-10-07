package com.java.AppiumProject;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class Project_Web3 {
	WebDriverWait wait;
	AppiumDriver<MobileElement> driver = null;

	@BeforeMethod
	public void beforeClass() throws MalformedURLException {
		// Set the Desired Capabilities
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("deviceName", "PixelXL");
		caps.setCapability("platformName", "Android");
		caps.setCapability("appPackage", "com.android.chrome");
		caps.setCapability("appActivity", "com.google.android.apps.chrome.Main");
		caps.setCapability("noReset", true);
		caps.setCapability("automationName", "UiAutomator2");
		caps.setCapability("chromedriverExecutable",
				"C:\\Users\\ShivamTiwari\\Desktop\\New folder (2)\\src\\resources\\drivers\\chromedriver.exe");

		// Instantiate Appium Driver
		URL appServer = new URL("http://0.0.0.0:4723/wd/hub");
		driver = new AndroidDriver<MobileElement>(appServer, caps);
		wait = new WebDriverWait(driver, 10);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		// Open page
		driver.get("https://www.training-support.net/selenium");
	}

	@Test
	public void loginWithValidUserNameAndPassword() {
		// Wait for the page to load
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.view.View")));

		driver.findElementByXPath("//*[@text='Selenium']").isDisplayed();
		wait(5);
		// Scroll element into view and click it
//		MobileElement el = driver.findElement(MobileBy.AndroidUIAutomator("UiScrollable(UiSelector().scrollable(true)).scrollForward().scrollIntoView(text(\"Tab Opener\"))"));

		MobileElement el;
		try {
			el = driver.findElement(MobileBy.AndroidUIAutomator(
					"UiScrollable(UiSelector().scrollable(true)).flingToEnd(20).scrollIntoView(text(\"Popups\"))"));
		} catch (Exception e) {
			el = driver.findElement(MobileBy.AndroidUIAutomator(
					"UiScrollable(UiSelector().scrollable(true)).scrollForward().scrollIntoView(text(\"Popups\"))"));

		}
		wait(5);

		driver.findElementByXPath("//android.view.View[contains(@content-desc,\"Popups\")]/android.view.View[1]")
				.click();

		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.Button[@text=\"Sign In\"]")));

		driver.findElementByXPath("//android.widget.Button[@text=\"Sign In\"]").click();

		wait.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("//android.widget.EditText[@resource-id=\"username\"]")));

		driver.findElementByXPath("//android.widget.EditText[@resource-id=\"username\"]").click();
		driver.findElementByXPath("//android.widget.EditText[@resource-id=\"username\"]").sendKeys("admin");

		driver.findElementByXPath("//android.widget.EditText[@resource-id=\"password\"]").click();
		driver.findElementByXPath("//android.widget.EditText[@resource-id=\"password\"]").sendKeys("password");
		wait(5);
		driver.findElementByXPath("//android.widget.Button[@text=\"Log in\"]").click();

		wait.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("//android.view.View[@text=\"Welcome Back, admin\"]")));
	}
	
	@Test
	public void loginWithINValidUserNameAndPassword() {
		// Wait for the page to load
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.view.View")));

		driver.findElementByXPath("//*[@text='Selenium']").isDisplayed();
		wait(5);
		// Scroll element into view and click it
//		MobileElement el = driver.findElement(MobileBy.AndroidUIAutomator("UiScrollable(UiSelector().scrollable(true)).scrollForward().scrollIntoView(text(\"Tab Opener\"))"));

		MobileElement el;
		try {
			el = driver.findElement(MobileBy.AndroidUIAutomator(
					"UiScrollable(UiSelector().scrollable(true)).flingToEnd(20).scrollIntoView(text(\"Popups\"))"));
		} catch (Exception e) {
			el = driver.findElement(MobileBy.AndroidUIAutomator(
					"UiScrollable(UiSelector().scrollable(true)).scrollForward().scrollIntoView(text(\"Popups\"))"));

		}
		wait(5);

		driver.findElementByXPath("//android.view.View[contains(@content-desc,\"Popups\")]/android.view.View[1]")
				.click();

		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.Button[@text=\"Sign In\"]")));

		driver.findElementByXPath("//android.widget.Button[@text=\"Sign In\"]").click();

		wait.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("//android.widget.EditText[@resource-id=\"username\"]")));

		driver.findElementByXPath("//android.widget.EditText[@resource-id=\"username\"]").click();
		driver.findElementByXPath("//android.widget.EditText[@resource-id=\"username\"]").sendKeys("admi");

		driver.findElementByXPath("//android.widget.EditText[@resource-id=\"password\"]").click();
		driver.findElementByXPath("//android.widget.EditText[@resource-id=\"password\"]").sendKeys("password");
		wait(5);
		driver.findElementByXPath("//android.widget.Button[@text=\"Log in\"]").click();

		wait.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("//android.view.View[@text=\"Invalid Credentials\"]")));
	}

	public void wait(int i) {
		try {
			Thread.sleep(i * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@AfterMethod
	public void afterClass() {
		driver.quit();
	}
}