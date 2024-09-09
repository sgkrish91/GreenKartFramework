package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseClass {

	public WebDriver driver;

	public WebDriver webDriverManager() throws IOException {

		FileInputStream ip = new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\resources\\global.properties"); // Passing the location of the properties file
		Properties prop = new Properties(); // Creating an object of Properties class
		prop.load(ip); // Using load method to load the properties file into this java class

		if (driver == null) {
			if (prop.getProperty("browser").equalsIgnoreCase("chrome")) {
				System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\src\\test\\resources\\chromedriver.exe");
				driver = new ChromeDriver();
			}
			driver.get(prop.getProperty("QAUrl"));
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofMillis(2000));
		}
		return driver;
	}

}
