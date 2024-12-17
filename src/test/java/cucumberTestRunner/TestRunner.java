package cucumberTestRunner;

import io.cucumber.testng.*;

@CucumberOptions(
		features={"feature"},
		glue={"stepDefinitions"},
		plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"} ,
		monochrome = true
		
	)
public class TestRunner extends AbstractTestNGCucumberTests{

}
