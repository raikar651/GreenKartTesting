package stepDefinations;




import java.io.IOException;

import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import pageObjects.LandingPage;
import utils.Dependancies;

public class LandingPagestepDefination {
	
	Dependancies Landingdep;
	LandingPage landingpage;
	
	public LandingPagestepDefination(Dependancies dep) {
		this.Landingdep = dep;
		this.landingpage = Landingdep.pageObjectManager.getLandingPage();
	}
	
	@Given("User is on GreenCart Landing Page")
	public void user_is_on_green_cart_landing_page() throws InterruptedException, IOException {
	    // Write code here that turns the phrase above into concrete actions
//		System.setProperty("webdriver.chrome.driver","/Users/prite/Downloads/chromedriver_win32/chromedriver.exe");
//		Landingdep.driver = new ChromeDriver();
//		Landingdep.driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		
//		Landingdep.testBase.WebDriverManager();
		
		Assert.assertTrue(landingpage.getTitleLandingPage().contains("GreenKart"));

		
	}
	@When("^User searched with shortname (.+) and extracted actual name of product$")
	public void user_searched_with_shortname_and_extracted_actual_name_of_product(String shortName) throws InterruptedException{
	    // Write code here that turns the phrase above into concrete actions
		
		landingpage.searchItem(shortName);
		Thread.sleep(2000);
		
//		Landingdep.driver.findElement(By.xpath("//input[@type='search']")).sendKeys(shortName);
//		Thread.sleep(2000);
		Landingdep.LandingProductName = landingpage.extractName().split("-")[0].trim();
		System.out.println(Landingdep.LandingProductName + " is extracted frome Home Page ");
		
	}
	
	@When("add {string} items of selected product to cart")
	public void add_items_of_selected_product_to_cart(String string) {
	    // Write code here that turns the phrase above into concrete actions
		landingpage.incrementCount(string);
		
		landingpage.addToCart();
		
		
	    
	}
}
