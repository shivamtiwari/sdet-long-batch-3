package com.java.AppiumProject;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.offset.ElementOption;
import junit.framework.Assert;

public class Project_Web1 {
	WebDriverWait wait;
	AppiumDriver<MobileElement> driver = null;

	@BeforeClass
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
	public void scrollIntoViewTest() {
		// Wait for the page to load
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.view.View")));

		driver.findElementByXPath("//*[@text='Selenium']").isDisplayed();

		// Scroll element into view and click it
//		MobileElement el = driver.findElement(MobileBy.AndroidUIAutomator("UiScrollable(UiSelector().scrollable(true)).scrollForward().scrollIntoView(text(\"Tab Opener\"))"));

		MobileElement el;
		try {
			el = driver.findElement(MobileBy.AndroidUIAutomator(
					"UiScrollable(UiSelector().scrollable(true)).flingToEnd(25).scrollIntoView(text(\"To-Do List\"))"));
		} catch (Exception e) {
			el = driver.findElement(MobileBy.AndroidUIAutomator(
					"UiScrollable(UiSelector().scrollable(true)).scrollForward().scrollIntoView(text(\"To-Do List\"))"));

		}
		wait(5);


		driver.findElementByXPath("//android.view.View[contains(@content-desc,\"To-Do List\")]/android.view.View[1]")
				.click();

		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.Button[@text='Add Task']")));

		driver.findElementByXPath("//android.view.View[@resource-id='tasksCard']//android.widget.EditText").click();
		driver.findElementByXPath("//android.view.View[@resource-id='tasksCard']//android.widget.EditText")
				.sendKeys("Add tasks to list");
		driver.findElementByXPath("//android.widget.Button[@text='Add Task']").click();

		wait(5);

		driver.findElementByXPath("//android.view.View[@resource-id='tasksCard']//android.widget.EditText").click();
		driver.findElementByXPath("//android.view.View[@resource-id='tasksCard']//android.widget.EditText")
				.sendKeys("Get number of tasks");
		driver.findElementByXPath("//android.widget.Button[@text='Add Task']").click();

		wait(5);

		driver.findElementByXPath("//android.view.View[@resource-id='tasksCard']//android.widget.EditText").click();
		driver.findElementByXPath("//android.view.View[@resource-id='tasksCard']//android.widget.EditText")
				.sendKeys("Clear the list");
		driver.findElementByXPath("//android.widget.Button[@text='Add Task']").click();

		wait(5);

		List<MobileElement> tasks = driver
				.findElementsByXPath("//android.view.View[@resource-id='tasksList']//android.view.View");

		tasks.get(1).click();
		tasks.get(2).click();
		tasks.get(3).click();

		wait(5);

		driver.findElementByXPath("//android.view.View[@resource-id='tasksCard']//android.widget.TextView").click();
	}

	public void wait(int i) {
		try {
			Thread.sleep(i * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}