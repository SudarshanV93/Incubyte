package utility;

import java.time.Duration;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class WebUtility {
	WebDriver driver;

	public WebUtility(WebDriver driver) {
		this.driver = driver;
	}
	
	public boolean waitAndVerifyElement(By objToWaitFor) {
		boolean flag = false;
		try {
			Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(20));
			wait.until(ExpectedConditions.visibilityOfElementLocated(objToWaitFor));
			wait.until(new Function<WebDriver, Boolean>() {
				public Boolean apply(WebDriver driver) {
					String.valueOf(((JavascriptExecutor) driver).executeScript("return document.readyState"));
					return String.valueOf(((JavascriptExecutor) driver).executeScript("return document.readyState"))
							.equals("complete");
				}
			});
			flag= driver.findElement(objToWaitFor).isDisplayed();
		} catch (Exception e) {
			flag = false;
			e.printStackTrace();
			Assert.fail("Element not present - " + objToWaitFor + " Error - " + e.getMessage());
		}
		return flag;
	}
	
	public void clearText(By objToClearText) {
		try {
			driver.findElement(objToClearText).clear();
			Assert.assertTrue(true, "Clear text operation successful - " + objToClearText);
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail("Clear text operation unsuccessful. " + " Error - " + e.getMessage());
		}
	}
	
	public void waitFor(int intMiliseconds) throws Exception {
		try {
			Thread.sleep(intMiliseconds);
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail("Not able to Wait. Error - " + e.getMessage());
		}
	}
	public void inputText(By objToInputTextInto, String strTextToInput) {
		try {
			waitAndVerifyElement(objToInputTextInto);
			clearText(objToInputTextInto);
			waitFor(2000);			
			driver.findElement(objToInputTextInto).sendKeys(strTextToInput);
			Assert.assertTrue(true, "Text input successful in -  " + objToInputTextInto);
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail("Text input unsuccessful in - " + objToInputTextInto + ". Error - " + e.getMessage());
		}
	}
	
	public void click(By objToBeClicked) {
		try {
			waitAndVerifyElement(objToBeClicked);
			driver.findElement(objToBeClicked).click();
			Assert.assertTrue(true, "Click on object successful - " + objToBeClicked);
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail("Click on object unsuccessful - " + objToBeClicked + ". Error - " + e.getMessage());
		}
	}

	public void navigate(String strUrlToNavigate) {
		try {
			driver.get(strUrlToNavigate);
			driver.manage().window().maximize();
			Assert.assertTrue(driver.getCurrentUrl().contains(strUrlToNavigate), "Navigated to URL - " + strUrlToNavigate);
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail("Navigation to url failed- " + strUrlToNavigate + ". Error - " + e.getMessage());
		}
	}
	
}
