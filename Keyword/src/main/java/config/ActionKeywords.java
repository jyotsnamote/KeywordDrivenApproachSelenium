package config;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import static executionEngine.DriverscriptTest.OR;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import executionEngine.DriverscriptTest;
import utility.Log;

public class ActionKeywords {

	public static WebDriver driver;

	// This block of code will decide which browser type to start
	public static void openBrowser(String object, String data) {
		Log.info("Opening Browser");
		try {
			// If value of the parameter is Mozilla, this will execute
			if (data.equals("Mozilla")) {
				System.setProperty("webdriver.firefox.driver", "C:\\JyotsnaPatil\\chromedriver_win32\\geckodriver.exe");
				driver = new FirefoxDriver();
				Log.info("Mozilla browser started");
			} else if (data.equals("IE")) {
				// You may need to change the code here to start IE Driver
				System.setProperty("webdriver.ie.driver", "C:\\JyotsnaPatil\\chromedriver_win32\\iedriver.exe");
				driver = new InternetExplorerDriver();
				Log.info("IE browser started");
			} else if (data.equals("Chrome")) {
				System.setProperty("webdriver.chrome.driver", "C:\\JyotsnaPatil\\chromedriver_win32\\chromedriver.exe");
				driver = new ChromeDriver();
				Log.info("Chrome browser started");
			}

			int implicitWaitTime = (10);
			driver.manage().timeouts().implicitlyWait(implicitWaitTime, TimeUnit.SECONDS);
		} catch (Exception e) {
			Log.info("Not able to open the Browser --- " + e.getMessage());
			DriverscriptTest.bResult = false;
		}
	}

	public static void navigate(String object, String data) {
		try {
			Log.info("Navigating to URL");
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			// Constant Variable is used in place of URL
			driver.get(Constants.URL);
		} catch (Exception e) {
			Log.info("Not able to navigate --- " + e.getMessage());
			DriverscriptTest.bResult = false;
		}
	}

	public static void click(String object, String data) throws IOException {
		try {
			Log.info("Clicking on Webelement " + object);
			driver.findElement(By.xpath(OR.getProperty(object))).click();
		} catch (Exception e) {
			Log.error("Not able to click --- " + e.getMessage(),driver);			
			DriverscriptTest.bResult = false;
			
		}
	}

	// Now this method accepts two value (Object name & Data)
	public static void input(String object, String data) throws IOException {
		try {
			Log.info("Entering the text in " + object);
			driver.findElement(By.xpath(OR.getProperty(object))).sendKeys(data);
		} catch (Exception e) {
			Log.error("Not able to Enter UserName --- " + e.getMessage(),driver);
			DriverscriptTest.bResult = false;
		}
	}

	public static void waitFor(String object, String data) throws Exception {
		try {
			Log.info("Wait for 5 seconds");
			Thread.sleep(5000);
		} catch (Exception e) {
			Log.error("Not able to Wait --- " + e.getMessage(),driver);
			DriverscriptTest.bResult = false;
		}
	}

	public static void closeBrowser(String object, String data) throws IOException {
		try {
			Log.info("Closing the browser");
			driver.quit();
		} catch (Exception e) {
			Log.error("Not able to Close the Browser --- " + e.getMessage(),driver);
			DriverscriptTest.bResult = false;
		}
	}

}
