package stepDefinitions;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.TestContextSetup;

public class LandingPageStepDefinition {
	
	public TestContextSetup testContextSetup;
	
	public LandingPageStepDefinition(TestContextSetup testContextSetup) {
		this.testContextSetup=testContextSetup;
	}
	
	@Given("User is on GreenKart landing page")
	public void user_is_on_green_kart_landing_page() {
		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver-win64\\chromedriver.exe");
		testContextSetup.driver=new ChromeDriver();
		testContextSetup.driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		testContextSetup.driver.manage().window().maximize();
	}
	
	@When("User searched with shortname {string} and extracted actual name of product")
	public void user_searched_with_shortname_and_extracted_actual_name_of_product(String shortName) throws InterruptedException {
		WebElement search=testContextSetup.driver.findElement(By.xpath("//input[@type='search']"));
		search.sendKeys(shortName);
		Thread.sleep(2000);
		WebElement product=testContextSetup.driver.findElement(By.cssSelector("h4.product-name"));
		testContextSetup.landingPageProdName=product.getText().split("-")[0].trim();
		System.out.println(testContextSetup.landingPageProdName + " is extracted from HomePage");
	}

}
