package com.java.SDET_Selenium.Test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Job_BoardTest {

	WebDriver driver;

	@BeforeMethod
	public void setUp() {
		System.out.println("*********************************************");
		System.setProperty("webdriver.gecko.driver", "resources/drivers/geckodriver.exe");

//		WebDriver driver = new FirefoxDriver();

		System.setProperty("webdriver.chrome.driver", "resources/drivers/chromedriver.exe");
		System.setProperty("webdriver.chrome.silentOutput", "true");
		WebDriver driver = new ChromeDriver();
		this.driver = driver;

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);

		driver.get("https://alchemy.hguy.co/jobs");

	}

	@Test
	public void TC01_verifyTheWebsiteTitle() {
		if (driver.getTitle().equals("Alchemy Jobs – Job Board Application")) {
			driver.close();
		}
	}

	@Test
	public void TC02_VerifyTheWebsiteHeading() {
		if (driver.findElement(By.xpath("//*[@itemprop='headline']")).getText().equals("Welcome to Alchemy Jobs")) {
			driver.close();
		}
	}

	@Test
	public void TC03_getURLOfHeaderImage() {
		System.out.println(driver.findElement(By.tagName("img")).getAttribute("src"));
		driver.close();
	}

	@Test
	public void TC04_verifyWebSiteSeacondHeading() {
		if (driver.findElement(By.tagName("h2")).getText().equals("Quia quis non")) {
			driver.close();
		}
	}

	@Test
	public void TC05_naviagteToJobPage() {
		driver.findElement(By.xpath("//a[text()='Jobs']")).click();
		driver.findElement(By.id("search_keywords")).isDisplayed();
		System.out.println(driver.getTitle());
		Assert.assertTrue(driver.getTitle().equals("Jobs – Alchemy Jobs"));
		driver.close();
	}

	@Test
	public void TC06_ApplyToAJob() {
		driver.findElement(By.xpath("//a[text()='Jobs']")).click();
		driver.findElement(By.id("search_keywords")).isDisplayed();
		driver.findElement(By.id("search_keywords")).click();
		driver.findElement(By.id("search_keywords")).sendKeys("python");
		driver.findElement(By.id("search_keywords")).sendKeys(Keys.ENTER);
		driver.findElement(By.xpath("//a[contains(.,'Python')]//img")).isDisplayed();

		driver.findElement(By.xpath("//ul[@class='job_listings']/li//a")).click();

		driver.findElement(By.xpath("//*[@value='Apply for job']")).click();

		System.out.println(
				driver.findElement(By.xpath("//*[@class='application_details']//a")).getAttribute("outerText"));

		System.out.println(driver.getTitle());

		driver.close();
	}

	@Test
	public void TC07_CreateAJobListing() {
		driver.findElement(By.xpath("//a[text()='Post a Job']")).click();

		driver.findElement(By.xpath("//form[@id='submit-job-form']//input[contains(@name,'email')]")).clear();
		driver.findElement(By.xpath("//form[@id='submit-job-form']//input[contains(@name,'email')]"))
				.sendKeys("test" + printRandomString(5) + "@gmail.com");

		driver.findElement(By.xpath("//form[@id='submit-job-form']//input[contains(@name,'title')]")).clear();
		driver.findElement(By.xpath("//form[@id='submit-job-form']//input[contains(@name,'title')]"))
				.sendKeys("Automation test Specialist");

		Select dropdown_jobType = new Select(
				driver.findElement(By.xpath("//form[@id='submit-job-form']//select[contains(@name,'type')]")));
		dropdown_jobType.selectByVisibleText("Full Time");

		driver.switchTo().frame(0);
		String description = "Looking for experienced engineer.";
		driver.findElement(By.tagName("p")).click();
		driver.findElement(By.tagName("p")).sendKeys(description);

		driver.switchTo().defaultContent();

		driver.findElement(By.xpath("//form[@id='submit-job-form']//input[contains(@name,'application')]")).clear();
		driver.findElement(By.xpath("//form[@id='submit-job-form']//input[contains(@name,'application')]"))
				.sendKeys("test" + printRandomString(5) + "@gmail.com");

		driver.findElement(By.xpath("//form[@id='submit-job-form']//input[contains(@name,'company_name')]")).clear();
		driver.findElement(By.xpath("//form[@id='submit-job-form']//input[contains(@name,'company_name')]"))
				.sendKeys("IBM");

		driver.findElement(By.xpath("//form[@id='submit-job-form']//input[contains(@name,'submit_job')]")).click();

		driver.findElement(By.xpath("//input[@name='continue']")).isDisplayed();
		driver.findElement(By.xpath("//input[@name='continue']")).click();

		driver.findElement(By.xpath("//a[text()='click here']")).isDisplayed();
		driver.findElement(By.xpath("//a[text()='click here']")).click();

		Assert.assertTrue(driver.findElement(By.xpath("//*[text()='" + description + "']")).isDisplayed());

		driver.close();

	}

	@Test
	public void TC08_visitSiteBackend() {
		driver.navigate().to("https://alchemy.hguy.co/jobs/wp-admin");
		String Username = "root";
		String Password = "pa$$w0rd";

		driver.findElement(By.xpath("//form[@id='loginform']//input[@type='text']")).sendKeys(Username);
		driver.findElement(By.xpath("//form[@id='loginform']//input[@type='password']")).sendKeys(Password);
		driver.findElement(By.xpath("//form[@id='loginform']//input[@type='submit']")).click();

		Assert.assertTrue(driver.findElement(By.xpath("//h1[text()='Dashboard']")).isDisplayed());

		driver.close();

	}

	@Test
	public void TC09_createAJobBackend() {
		driver.navigate().to("https://alchemy.hguy.co/jobs/wp-admin");
		String Username = "root";
		String Password = "pa$$w0rd";

//		driver.findElement(By.xpath(""));
		driver.findElement(By.xpath("//form[@id='loginform']//input[@type='text']")).sendKeys(Username);
		driver.findElement(By.xpath("//form[@id='loginform']//input[@type='password']")).sendKeys(Password);
		driver.findElement(By.xpath("//form[@id='loginform']//input[@type='submit']")).click();

		Assert.assertTrue(driver.findElement(By.xpath("//h1[text()='Dashboard']")).isDisplayed());

		String className = driver.findElement(By.xpath("//*[@id='menu-posts-job_listing']")).getAttribute("class");

		executeJs(
				"document.getElementsByClassName('wp-has-submenu wp-not-current-submenu menu-top menu-icon-job_listing menu-top-last')[0].className = '"
						+ className + " opensub" + "'");

		driver.findElement(By.xpath("//*[@id='menu-posts-job_listing']//a[text()='Add New']")).isDisplayed();
		driver.findElement(By.xpath("//*[@id='menu-posts-job_listing']//a[text()='Add New']")).click();

		driver.findElement(By.tagName("textarea")).isDisplayed();
		Actions keyAction = new Actions(driver);

		try {

			keyAction.sendKeys(Keys.ESCAPE).perform();

			driver.findElement(By.tagName("textarea")).sendKeys(Keys.ESCAPE);
			driver.findElement(By.tagName("textarea")).click();

		} catch (Exception e) {
			keyAction.sendKeys(Keys.ESCAPE).perform();
		}

		driver.findElement(By.tagName("textarea")).sendKeys("Automation test engineer");

		driver.findElement(By.xpath("//*[contains(@class,'content-body')]")).click();
		driver.findElement(By.xpath("//*[contains(@class,'content-body')]"))
				.sendKeys("Automation test engineer details");

		driver.findElement(By.xpath("//form//input[contains(@name,'_application')]")).clear();
		driver.findElement(By.xpath("//form//input[contains(@name,'_application')]"))
				.sendKeys("test" + printRandomString(5) + "@gmail.com");

		driver.findElement(By.xpath("//form//input[contains(@name,'_company_name')]")).clear();
		driver.findElement(By.xpath("//form//input[contains(@name,'_company_name')]")).sendKeys("IBM");

		driver.findElement(By.xpath("//*[contains(text(),'Publish')]")).click();

		driver.findElement(By.xpath("//*[text()='Publish']")).isDisplayed();
		driver.findElement(By.xpath("//*[text()='Publish']")).click();

		driver.findElement(By.xpath("//*[text()='View Job']")).click();

		Assert.assertTrue(driver.findElement(By.xpath("//*[text()='Automation test engineer details']")).isDisplayed());

		driver.close();

	}

	public void executeJs(String script) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript(script, (Object) null);
	}

	public String printRandomString(int n) {
		char[] alphabet = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r',
				's', 't', 'u', 'v', 'w', 'x', 'y', 'z' };

		String res = "";
		for (int i = 0; i < n; i++)
			res = res + alphabet[(int) (Math.random() * 10 % 26)];

		return res.toUpperCase();
	}

}
