package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.GeneralUtilities;

public class OfferPage {
	
	WebDriver driver;
	GeneralUtilities gu=new GeneralUtilities();
	
	public OfferPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "search-field")
	private WebElement search;
	
	@FindBy(css = "tr td:nth-child(1)")
	private WebElement topDealsProdName;
	
	public void switchToOffersPage(WebDriver driver) {
		gu.switchWindow(driver);
	}
	
	public void enterSearchName(String name) {
		gu.enterText(search, name);
	}
	
	public String getProductName() {
		return gu.getTextFromElement(topDealsProdName);
	}

}
