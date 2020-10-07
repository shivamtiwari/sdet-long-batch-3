package com.java.AppiumProject;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class Project_createAListofActivities {

	// com.google.android.apps.tasks

	// .ui.TaskListsActivity

	AppiumDriver<MobileElement> driver = null;
	WebDriverWait wait;

	@BeforeClass
	public void beforeClass() throws MalformedURLException {
		// Set the Desired Capabilities
		DesiredCapabilities caps = new DesiredCapabilities();

		caps.setCapability("deviceId", "emulator-5554");
		caps.setCapability("deviceName", "Pixel3a");

		caps.setCapability("platformName", "Android");
		caps.setCapability("appPackage", "com.google.android.apps.tasks");
		caps.setCapability("appActivity", "com.google.android.apps.tasks.ui.TaskListsActivity");
		caps.setCapability("noReset", true);

		caps.setCapability("adbExecTimeout", "50000");

		URL appServer = new URL("http://0.0.0.0:4723/wd/hub");
		driver = new AndroidDriver<MobileElement>(appServer, caps);
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		wait = new WebDriverWait(driver, 5);
	}

	@Test
	public void createActivitiy() {
		wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.AccessibilityId("Create new task")));
		driver.findElement(MobileBy.AccessibilityId("Create new task")).isDisplayed();
		driver.findElement(MobileBy.AccessibilityId("Create new task")).click();

		driver.findElementById("add_task_title").click();
		driver.findElementById("add_task_title").sendKeys("Complete Activity with Google Tasks");
		driver.findElementById("add_task_done").click();

		driver.findElement(MobileBy.AccessibilityId("Create new task")).click();
		driver.findElementById("add_task_title").click();
		driver.findElementById("add_task_title").sendKeys("Complete Activity with Google Keep");
		driver.findElementById("add_task_done").click();
		
		driver.findElement(MobileBy.AccessibilityId("Create new task")).click();
		driver.findElementById("add_task_title").click();
		driver.findElementById("add_task_title").sendKeys("Complete the second Activity Google Keep");
		driver.findElementById("add_task_done").click();
		
		
		Assert.assertTrue(driver.findElementByXPath("//android.widget.FrameLayout[@content-desc=\"Complete Activity with Google Tasks\"]//android.widget.TextView").isDisplayed());
		Assert.assertTrue(driver.findElementByXPath("//android.widget.FrameLayout[@content-desc=\"Complete Activity with Google Keep\"]//android.widget.TextView").isDisplayed());
		Assert.assertTrue(driver.findElementByXPath("//android.widget.FrameLayout[@content-desc=\"Complete the second Activity Google Keep\"]//android.widget.TextView").isDisplayed());
	}
	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
