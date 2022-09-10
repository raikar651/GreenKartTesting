package cucumberOptions;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features="src/test/java/Features",
		glue="stepDefinations",
//		dryRun=true,
		monochrome=true,
		tags="@placeOrder or @OffersPage",
		plugin= {"html:target/cucumber.html","json:target/cucumber.json",
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
				"rerun:target/failed_scenarios.txt"
				}
		)
public class TestNGTestRunner extends AbstractTestNGCucumberTests{
	
	/* How to run parallely Scenarios 
	--> Simply call the parent class scenarios and set parallel = true*/
	
	
	@Override
	@DataProvider(parallel=true)   			
	public Object[][] scenarios(){
		return super.scenarios();
	}

}
