package tools;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class pageTools {
	
	WebDriver driver;
	
	WebElement bookStore;
	
	public WebElement getBookStore() {
		return driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[2]/div/div[6]"));
	}

	public pageTools(WebDriver driver) {
		this.driver = driver;
	}
	
	public void goToBookStore() {
		this.getBookStore().click();
	}

}
