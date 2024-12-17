package utility;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverManager {
	
private static WebDriver driver = null;
	
	public static WebDriver getdriver() {
		if (driver != null) {
			return driver;
			
		} else {
			System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
			return driver;
		}
	}


}
