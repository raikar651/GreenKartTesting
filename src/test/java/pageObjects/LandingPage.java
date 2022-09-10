package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LandingPage {
	public WebDriver driver;
	
	public LandingPage(WebDriver driver) {
		this.driver = driver;
	}
	
	
	By search = By.xpath("//input[@type='search']");
	By productName = By.cssSelector("h4.product-name");
	By TopDealsPage = By.linkText("Top Deals");
	By incBtn = By.cssSelector("a.increment");
	By addToBtn = By.xpath("//button[contains(text(),'ADD TO CART')]");
	
	public void searchItem(String name) {
		driver.findElement(search).sendKeys(name);
	}
	
	public String extractName() {
		return driver.findElement(productName).getText();
	}
	
	public void TopDealspage() {
		driver.findElement(TopDealsPage).click();
	}
	
	public String getTitleLandingPage() {
		return driver.getTitle();
	}
	
	public void incrementCount(String str) {
		int quantity = Integer.parseInt(str);
		for(int i=0;i<quantity-1;i++) {
			
			driver.findElement(incBtn).click();
		}
	}
	
	public void addToCart() {
		driver.findElement(addToBtn).click();
	}
}
