package stepDefinations;



import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pageObjects.LandingPage;
import pageObjects.OfferPage;
import pageObjects.PageObjectManager;
import utils.Dependancies;

public class OfferPagestepDefination {
	
	public String OfferPageProductName;
	public Dependancies dep;
	public PageObjectManager pageObjectManager; 
	
	public OfferPagestepDefination(Dependancies dep) {
		this.dep = dep;
	}
	
	@Then("^User searched for (.+) shortname in offer page$")
	public void user_searched_for_same_shortname_in_offer_page_to_check_if_product_exist(String shortName) throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
//		dep.driver.findElement(By.linkText("Top Deals")).click();
//		Set<String> s1 = dep.driver.getWindowHandles();
//		Iterator<String> i1 = s1.iterator();
//		i1.next();
//		String ChildWindow = i1.next();
//		
//		dep.driver.switchTo().window(ChildWindow);
		switchToOfferPage();
		
		
		
		OfferPage offerpage = dep.pageObjectManager.getOfferPage();
		offerpage.searchItem(shortName);
		
//		dep.driver.findElement(By.xpath("//input[@type='search']")).sendKeys(shortName);
		Thread.sleep(2000);
		OfferPageProductName = offerpage.extractName();
		
		
	}
	
	public void switchToOfferPage() {
		LandingPage landingpage = dep.pageObjectManager.getLandingPage();
		landingpage.TopDealspage();
//		Set<String> s1 = dep.testBase.driver.getWindowHandles();
//		Iterator<String> i1 = s1.iterator();
//		i1.next();
//		String ChildWindow = i1.next();
//		
//		dep.testBase.driver.switchTo().window(ChildWindow);
		
		dep.genericUtils.switchWindowToChild();
	}
	
	@And("Validate the product in landing page and offer page are same or not")
	public void Validate_product_name() {
//		System.out.println(OfferPageProductName);
//		System.out.println(dep.LandingProductName);
		Assert.assertEquals(OfferPageProductName, dep.LandingProductName);
	}

}
