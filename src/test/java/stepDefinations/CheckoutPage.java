package stepDefinations;



import org.testng.Assert;

import io.cucumber.java.en.Then;

import utils.Dependancies;

public class CheckoutPage {
	
	Dependancies Checkoutdep;
	public pageObjects.CheckoutPage checkoutpage;
	public String CheckoutProductName;
	
	public CheckoutPage(Dependancies dep) {
		this.Checkoutdep = dep;
		checkoutpage = Checkoutdep.pageObjectManager.getcheckOutPage();
	}
	
	@Then("^User proceeds to checkout and validates the (.+) in checkout page$")
	public void user_proceeds_to_checkout_and_validates_the_tom_in_checkout_page(String str) throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
	    checkoutpage.checkoutBag();
//	    Thread.sleep(2000);
	    CheckoutProductName = checkoutpage.extractProductName();
	    System.out.println(CheckoutProductName);
	    Assert.assertEquals(CheckoutProductName,Checkoutdep.LandingProductName);
	    
//	    
	}
	@Then("Verify user has ability to enter promocode and place the order")
	public void verify_user_has_ability_to_enter_promocode_and_place_the_order() {
	    // Write code here that turns the phrase above into concrete actions
	    Assert.assertTrue(checkoutpage.VerifyPromoBtn());
	    Assert.assertTrue(checkoutpage.VerifyPlaceOrder());
	}
	
	

}
