package utils;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import pageObjects.PageObjectManager;

public class TestContextSetup {
	
	public WebDriver driver;
	public String landingPageProdName;
	public PageObjectManager pom;
	public BaseClass baseClass;	//To create an object of BaseClass
	
	public TestContextSetup() throws IOException {
		baseClass=new BaseClass();	//Creating object of BaseClass
		pom=new PageObjectManager(baseClass.webDriverManager());
	}

}
