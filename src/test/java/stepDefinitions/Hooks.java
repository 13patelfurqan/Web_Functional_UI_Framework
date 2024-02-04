package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import utils.TestBase;
import utils.TestContextSetup;

import java.io.File;
import java.io.IOException;

public class Hooks {

	private TestBase testBase;
	private WebDriver driver;

	public Hooks(TestContextSetup testContextSetup) {
		this.testBase = testContextSetup.testBase;
		this.driver = testContextSetup.driver;
	}

	@Before
	public void PrintScenarioInfo(Scenario scenario) {
		System.out.println("/******************************************************************************************************/");
		System.out.println("Starting - " + scenario.getName());
		System.out.println("/******************************************************************************************************/");
		System.out.println("Scenario Tags :  - " + scenario.getSourceTagNames());
		System.out.println("/******************************************************************************************************/");
	}

//	@After
//	public void AfterScenario() throws IOException {
//		driver.quit();
//	}

	@AfterStep
	public void AddScreenshot(Scenario scenario) throws IOException {
		if (scenario.isFailed()) {
			File sourcePath = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			byte[] fileContent = FileUtils.readFileToByteArray(sourcePath);
			scenario.attach(fileContent, "image/png", "FailedScenario(s)");
			System.out.println("/******************************************************************************************************/");
			System.out.println("Scenario Status :  - " + scenario.getStatus());
			System.out.println("/******************************************************************************************************/");
		}
	}
}
