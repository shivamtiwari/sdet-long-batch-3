package com.java.SDET_Selenium.Test;

import java.util.logging.Level;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class TestCode {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.gecko.driver","resources/drivers/geckodriver.exe");
//		LoggingPreferences preferences = new LoggingPreferences();
//		preferences.enable(LogType.BROWSER, Level.OFF);
//		preferences.enable(LogType.CLIENT, Level.OFF);
//		preferences.enable(LogType.DRIVER, Level.OFF);
//		preferences.enable(LogType.PROFILER, Level.OFF);
//		preferences.enable(LogType.PERFORMANCE, Level.OFF);
//		preferences.enable(LogType.SERVER, Level.OFF);
//		DesiredCapabilities dc = new DesiredCapabilities();
//		dc.setCapability(CapabilityType.LOGGING_PREFS, preferences);
//		FirefoxOptions opt = new FirefoxOptions();
//		opt.merge(dc);
//		FirefoxProfile profile = new FirefoxProfile();
//		profile.setPreference("network.proxy.type", 0);
//		WebDriver driver = new FirefoxDriver(opt);
		
//		WebDriver driver = new FirefoxDriver();
		
		System.setProperty("webdriver.chrome.driver", "resources/drivers/chromedriver.exe");
		System.setProperty("webdriver.chrome.silentOutput", "true");
		WebDriver driver = new ChromeDriver();
		
		
		driver.get("https://lms.training-support.net/alchemy/");

	}

}
