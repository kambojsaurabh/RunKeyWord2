package Run;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Library {
	public WebDriver driver;
	
	public Library(WebDriver driver) {
		this.driver=driver;
	}
	
	public boolean elementExist(String xpath) {
		try {
			driver.findElement(By.xpath(xpath));
			return true;
		}
		catch(Exception e) {
			return false;
		}
	}
	
	public void verifyTitle(String expectedTitle) {
		String actualTitle = driver.getTitle();
		if(actualTitle.equals(expectedTitle)) {
			System.out.println("Title is correct");
		}
		else {
			System.out.println("Title is Incorrect");
		}
	}
	
	public void sendKeys( String xpath, String value) {
			driver.findElement(By.xpath(xpath)).sendKeys(value);
	}
	
	public void click(String xpath) {
		driver.findElement(By.xpath(xpath)).click();
	}
	
	// Below Method Overrides for css elements
	
	public boolean elementExist(String css,String cssSelector) {
		try {
			driver.findElement(By.cssSelector(css));
			return true;
		}
		catch(Exception e) {
			return false;
		}
	}
	
	public void verifyTitle(String expectedTitle, String cssSelector) {
		String actualTitle = driver.getTitle();
		if(actualTitle.equals(expectedTitle)) {
			System.out.println("Title is correct");
		}
		else {
			System.out.println("Title is Incorrect");
		}
	}
	
	public void sendKeys( String css, String value, String cssSelector) {
		driver.findElement(By.cssSelector(css)).sendKeys(value);
	}
	
	public void click(String css, String cssSelector) {
		driver.findElement(By.cssSelector(css)).click();
	}
	
	
}


