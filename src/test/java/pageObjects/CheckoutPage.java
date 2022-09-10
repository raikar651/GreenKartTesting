package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage {
	public WebDriver driver;
	
	public CheckoutPage(WebDriver driver) {
		this.driver = driver;
	}
	
	
	By cartBag = By.cssSelector("[alt='Cart']");
	By checkoutButton = By.xpath("//button[contains(text(),'PROCEED TO CHECKOUT')]");
	By promoBtn = By.cssSelector(".promoBtn");
	By placeOrder = By.xpath("//button[contains(text(),'Place Order')]");
	By ProductName = By.cssSelector(".product-name");
	
	
	public void checkoutBag() {
		driver.findElement(cartBag).click();
		driver.findElement(checkoutButton).click();
	}
	
	public Boolean VerifyPromoBtn() {
		return driver.findElement(promoBtn).isDisplayed();
	}
	
	public Boolean VerifyPlaceOrder() {
		return driver.findElement(placeOrder).isDisplayed();
	}
	
	public String extractProductName() {
		return driver.findElement(ProductName).getText().split("-")[0].trim();
	}
}
