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

public class Project_googleNote {

	AppiumDriver<MobileElement> driver = null;
	WebDriverWait wait;

	@BeforeClass
	public void beforeClass() throws MalformedURLException {
		// Set the Desired Capabilities
		DesiredCapabilities caps = new DesiredCapabilities();

		caps.setCapability("deviceId", "emulator-5554");
		caps.setCapability("deviceName", "Pixel3a");

		caps.setCapability("platformName", "Android");
		caps.setCapability("appPackage", "com.google.android.keep");
		caps.setCapability("appActivity", "com.google.android.keep.activities.BrowseActivity");
		caps.setCapability("noReset", true);

		caps.setCapability("adbExecTimeout", "50000");

		URL appServer = new URL("http://0.0.0.0:4723/wd/hub");
		driver = new AndroidDriver<MobileElement>(appServer, caps);
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		wait = new WebDriverWait(driver, 5);
	}

	@Test
	public void createActivitiy() {
		wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.AccessibilityId("New text note")));
		driver.findElement(MobileBy.AccessibilityId("New text note")).isDisplayed();
		driver.findElement(MobileBy.AccessibilityId("New text note")).click();

		driver.findElementById("editable_title").click();
		driver.findElementById("editable_title").sendKeys("Adding Title Details");

		driver.findElementById("edit_note_text").click();
		driver.findElementById("edit_note_text").sendKeys("Adding Note Details");

		driver.findElementById("menu_reminder").click();

		driver.findElementByXPath(
				"//android.widget.LinearLayout[contains(@content-desc,\"Time - Currently selected\")]/android.widget.Spinner/android.widget.TextView")
				.click();

		driver.findElementById("reminder_time_afternoon").click();
		driver.findElementById("save").click();

		driver.navigate().back();
		driver.navigate().back();

		Assert.assertTrue(driver
				.findElementByXPath(
						"//android.widget.LinearLayout/android.widget.LinearLayout/android.widget.TextView[2]")
				.getText().equals("Adding Note Details"));

	}
	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
