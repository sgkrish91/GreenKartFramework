package pageObjects;

import org.openqa.selenium.WebDriver;

public class PageObjectManager {
	
	public WebDriver driver;
	public LandingPage lp;
	public OfferPage op;
	
	public PageObjectManager(WebDriver driver) {
		this.driver=driver;
	}
	
	public LandingPage getLandingPage() {
		lp=new LandingPage(driver);
		return lp;
	}
	
	public OfferPage getOfferPage() {
		op=new OfferPage(driver);
		return op;
	}
}
