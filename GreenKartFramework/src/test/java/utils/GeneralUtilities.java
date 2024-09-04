package utils;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GeneralUtilities {
	
	public void enterText(WebElement element, String text) {
		element.sendKeys(text);
	}
	
	public String getTextFromElement(WebElement element) {
		return element.getText();
	}
	
	public String getTrimmedText(WebElement element, String value, int index) {
		return element.getText().split(value)[index].trim();
	}
	
	public void clickElement(WebElement element) {
		element.click();
	}
	
	public void switchWindow(WebDriver driver) {
		 Set<String> s1=driver.getWindowHandles();	//To get the list of all the windows opened
		 Iterator<String> i1=s1.iterator();	//To iterate through the list of all windows
		 String parentWindow=i1.next(); //To get the parent window
		 String childWindow=i1.next();	//To get the next child window
		 driver.switchTo().window(childWindow);	//Switched control to child window	
	}
	
	

}
