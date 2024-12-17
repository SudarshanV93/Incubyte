package stepDefinitions;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utility.DriverManager;

public class Hooks {
    private static ExtentReports extentReports;
    private static ExtentTest test;
    
	/*
	 * @Before public void setUp() { ExtentHtmlReporter htmlReporter = new
	 * ExtentHtmlReporter("target/extent-report.html"); extentReports = new
	 * ExtentReports(); extentReports.attachReporter(htmlReporter); }
	 */
	
	@After
	public void afterScenario(Scenario scenario) throws IOException {
		if(scenario.isFailed())
		{
			File path = ((TakesScreenshot)DriverManager.getdriver()).getScreenshotAs(OutputType.FILE);
			byte[] content = FileUtils.readFileToByteArray(path);
			scenario.attach(content, "image/png", "image");
		}
		//extentReports.flush();
		DriverManager.getdriver().quit();
		 
	}
}
