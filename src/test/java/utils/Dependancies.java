package utils;



import java.io.IOException;

import pageObjects.PageObjectManager;


public class Dependancies {
	
//	public WebDriver driver;
	public String LandingProductName;
	public PageObjectManager pageObjectManager;
	public TestBase testBase;
	public GenericUtils genericUtils;
	
	
	public Dependancies() throws IOException {
		testBase = new TestBase();
		pageObjectManager = new PageObjectManager(testBase.WebDriverManager());
		genericUtils = new GenericUtils(testBase.WebDriverManager());
	}
}
