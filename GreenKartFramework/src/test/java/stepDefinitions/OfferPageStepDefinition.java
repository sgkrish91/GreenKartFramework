package stepDefinitions;

import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pageObjects.LandingPage;
import pageObjects.OfferPage;
import utils.TestContextSetup;

public class OfferPageStepDefinition {
	
	public TestContextSetup testContextSetup;
	public String topDealsProdName;
	
	public OfferPageStepDefinition(TestContextSetup testContextSetup) {
		this.testContextSetup=testContextSetup;
	}
	
	@Then("User searched for {string} shortname in offers page")
	public void user_searched_for_same_shortname_in_offers_page(String shortName) throws InterruptedException {
	    OfferPage op=new OfferPage(testContextSetup.driver);
	    LandingPage lp=new LandingPage(testContextSetup.driver);
	    lp.clickTopDealsLink();
	    Thread.sleep(2000);
	    op.switchToOffersPage(testContextSetup.driver);
	    op.enterSearchName(shortName);
	    topDealsProdName=op.getProductName();
	    System.out.println(topDealsProdName + " is extracted from Top Deals page");
	}
	
	@And("Validate product name in offers page matches with landing page")
	public void validate_product_name_in_offers_page_matches_with_landing_page() {
		testContextSetup.driver.quit();
		Assert.assertEquals(topDealsProdName, testContextSetup.landingPageProdName);
	}

}
