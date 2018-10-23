package utility;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Log {

	// Initialize Log4j logs
	private static Logger Log = Logger.getLogger(Log.class.getName());//

	// This is to print log for the beginning of the test case, as we usually run so
	// many test cases as a test suite
	public static void startTestCase(String sTestCaseName) {

		Log.info("****************************************************************************************");
		Log.info("****************************************************************************************");
		Log.info("$$$$$$$$$$$$$$$$$$$$$                 " + sTestCaseName + "       $$$$$$$$$$$$$$$$$$$$$$$$$");
		Log.info("****************************************************************************************");
		Log.info("****************************************************************************************");

	}

	// This is to print log for the ending of the test case
	public static void endTestCase(String sTestCaseName) {
		Log.info("XXXXXXXXXXXXXXXXXXXXXXX             " + "-E---N---D-" + "             XXXXXXXXXXXXXXXXXXXXXX");
		Log.info("X");
		Log.info("X");
		Log.info("X");
		Log.info("X");

	}

	// Need to create these methods, so that they can be called
	public static void info(String message) {
		Log.info(message);
	}

	public static void warn(String message) {
		Log.warn(message);
	}

	public static void error(String message, WebDriver driver) throws IOException {
		Log.warn(message);

		File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String filPath = "C:\\JyotsnaPatil\\SeleniumExceljars\\Screenshots\\";
		File dest = new File(filPath + "screenshot_" + timestamp() + ".png");
		FileUtils.copyFile(screenshotFile, dest);

	}

	public static String timestamp() {
		return new SimpleDateFormat("yyyy-MM-dd HH-mm-ss").format(new Date());
	}

	public static void fatal(String message) {
		Log.fatal(message);
	}

	public static void debug(String message) {
		Log.debug(message);
	}

}
