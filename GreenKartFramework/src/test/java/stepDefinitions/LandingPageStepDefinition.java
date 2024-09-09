package stepDefinitions;

import java.io.IOException;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import pageObjects.LandingPage;
import utils.BaseClass;
import utils.TestContextSetup;

public class LandingPageStepDefinition {
	
	public TestContextSetup testContextSetup;
	public BaseClass baseClass;
	public LandingPageStepDefinition(TestContextSetup testContextSetup) {
		this.testContextSetup=testContextSetup;
	}
	
	@Given("User is on GreenKart landing page")
	public void user_is_on_green_kart_landing_page() throws IOException {
		
		/*We don't need to write any code to invoke the browser here, because it is already handled in BaseClass.
		When control comes to this stepDefinition file, the constructor is called first.
		It has created an instance of TestContextSetup class.
		This in turn calls the webDriverManager() method in the BaseClass and the steps related to invoking the browser is carried out.
		*/
	}
	
	@When("User searched with shortname {string} and extracted actual name of product")
	public void user_searched_with_shortname_and_extracted_actual_name_of_product(String shortName) throws InterruptedException {
		LandingPage lp=testContextSetup.pom.getLandingPage();
		lp.enterSearchName(shortName);
		Thread.sleep(2000);
		testContextSetup.landingPageProdName=lp.getProductName();
		System.out.println(testContextSetup.landingPageProdName + " is extracted from HomePage");
	}

}
