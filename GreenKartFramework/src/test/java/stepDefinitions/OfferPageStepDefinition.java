package stepDefinitions;

import org.testng.Assert;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import utils.TestContextSetup;

public class OfferPageStepDefinition {
	
	public TestContextSetup testContextSetup;
	public String topDealsProdName;
	
	public OfferPageStepDefinition(TestContextSetup testContextSetup) {
		
		this.testContextSetup=testContextSetup;
	}
	
	//Code to switch the control from parent window to child window which is Offers Page
	public void switchToOffersPage() {
		
		 WebElement topDeals=testContextSetup.driver.findElement(By.linkText("Top Deals"));
		 topDeals.click();
		 Set<String> s1=testContextSetup.driver.getWindowHandles();	//To get the list of all the windows opened
		 Iterator<String> i1=s1.iterator();	//To iterate through the list of all windows
		 String parentWindow=i1.next(); //To get the parent window
		 String childWindow=i1.next();	//To get the next child window
		 testContextSetup.driver.switchTo().window(childWindow);	//Switched control to child window
	}
	
	@Then("User searched for {string} shortname in offers page")
	public void user_searched_for_same_shortname_in_offers_page(String shortName) throws InterruptedException {
	    
		switchToOffersPage();
	    WebElement search=testContextSetup.driver.findElement(By.id("search-field"));
	    search.sendKeys(shortName);
	    Thread.sleep(2000);
	    topDealsProdName=testContextSetup.driver.findElement(By.cssSelector("tr td:nth-child(1)")).getText();
	    System.out.println(topDealsProdName + " is extracted from Top Deals page");
	}
	
	@And("Validate product name in offers page matches with landing page")
	public void validate_product_name_in_offers_page_matches_with_landing_page() {
		testContextSetup.driver.quit();
		Assert.assertEquals(topDealsProdName, testContextSetup.landingPageProdName);
	}

}
