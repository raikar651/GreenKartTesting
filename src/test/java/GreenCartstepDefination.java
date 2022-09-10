

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class GreenCartstepDefination {
	
	public WebDriver driver;
	public String LandingProductName;
	public String OfferPageProductName;
	

	@Given("User is on GreenCart Landing Page")
	public void user_is_on_green_cart_landing_page() throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
		System.setProperty("webdriver.chrome.driver","C:\\SeleniumChromeDriver/chromedriver");
		driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractice/#/");
		
	}
	@When("User searched with shortname {string} and extracted actual name of product")
	public void user_searched_with_shortname_and_extracted_actual_name_of_product(String shortName) throws InterruptedException{
	    // Write code here that turns the phrase above into concrete actions
		driver.findElement(By.xpath("//input[@type='search']")).sendKeys(shortName);
		String LandingProductName = driver.findElement(By.cssSelector("h4.product-name")).getText().split("-")[0].trim();
		System.out.println(LandingProductName + " is extracted frome Home Page ");
		
	}
	@Then("User searched for {string} shortname in offer page")
	public void user_searched_for_same_shortname_in_offer_page_to_check_if_product_exist(String shortName) throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
		driver.findElement(By.linkText("Top Deals")).click();
		Set<String> s1 = driver.getWindowHandles();
		Iterator<String> i1 = s1.iterator();
		String ChildWindow = i1.next();
		
		driver.switchTo().window(ChildWindow);
		driver.findElement(By.xpath("//input[@type='search']")).sendKeys(shortName);
		Thread.sleep(2000);
		OfferPageProductName = driver.findElement(By.cssSelector("tr td:nth-child(1)")).getText();
		
		
	}
	
	@And("Validate the product in landing page and offer page are same or not")
	public void Validate_product_name() {
		Assert.assertEquals(OfferPageProductName, LandingProductName);
	}

}
