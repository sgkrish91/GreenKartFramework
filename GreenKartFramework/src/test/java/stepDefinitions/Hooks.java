package stepDefinitions;

import java.io.IOException;

import io.cucumber.java.After;
import utils.TestContextSetup;

public class Hooks {
	
	public TestContextSetup testContextSetup;
	
	public Hooks(TestContextSetup testContextSetup) {
		this.testContextSetup=testContextSetup;
	}
	
	@After
	public void afterScenario() throws IOException {
		testContextSetup.baseClass.webDriverManager().quit();	//We are taking the driver from the webDriverManager() method inside the BaseClass
		
	}

}
