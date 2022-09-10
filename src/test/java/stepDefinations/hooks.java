package stepDefinations;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import utils.Dependancies;

public class hooks {
	
	Dependancies dep;
	
	public hooks(Dependancies dep) {
		this.dep = dep;
	}
	
	//This will run after Scenarios implementation is complete
	@After
	public void AfterScenaros() throws IOException {
		dep.testBase.WebDriverManager().quit();
	}
	
	@AfterStep
	public void AddScreenshots(Scenario scenario) throws IOException {
		WebDriver driver = dep.testBase.WebDriverManager();
		if(scenario.isFailed()) {
			File SourcePath = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			byte[] fileContent = FileUtils.readFileToByteArray(SourcePath);
			scenario.attach(fileContent,"image/png","image");
		}
	}
	
	
}
