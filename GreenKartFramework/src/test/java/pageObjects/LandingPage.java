package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.GeneralUtilities;

public class LandingPage {
	
	WebDriver driver;
	GeneralUtilities gu=new GeneralUtilities();
	
	public LandingPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[@type='search']")
	private WebElement search;
	
	@FindBy(css="h4.product-name")
	private WebElement product;
	
	@FindBy(linkText = "Top Deals")
	private WebElement topDeals;
	
	public void enterSearchName(String name) {
		gu.enterText(search, name);
	}
	
	public String getProductName() {
		return gu.getTrimmedText(product, "-", 0);
	}
	
	public void clickTopDealsLink() {
		gu.clickElement(topDeals);
		System.out.println("Clicked Top Deals");
	}

}
