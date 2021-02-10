package tools;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class pageBooks {
	JavascriptExecutor js;
	WebDriver driver;
	
	WebElement loginButton;
	WebElement aBook;
	WebElement addToCollectionButton;
	WebElement profileButton;
	
	

	//Getters
	public WebElement getABook() {
		return driver.findElement(By.id("see-book-Eloquent JavaScript, Second Edition"));
	} 
	
	public WebElement getLoginButton() {
		return driver.findElement(By.id("login"));
	}
	
	public WebElement addToCollectionButton() {
//		return driver.findElement(By.id("addNewRecordButton"));
//		return driver.findElement(By.xpath("//*[@id=\"addNewRecordButton\"]"));
		return driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div[2]/div[1]/div[2]/div[9]/div[2]/button"));
		
	}
	
	public WebElement getProfileButton() {
		return driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div[1]/div/div/div[6]/div/ul/li[3]"));
	}
	
	// Konstruktor
	public pageBooks(JavascriptExecutor js, WebDriver driver) {
		super();
		this.js = (JavascriptExecutor)driver;
		this.driver = driver;
	}


	//funkcije
	public void clickLoginButton() {
		this.getLoginButton().click();
	}
	
	public void clickOnABook() {
		js.executeScript("arguments[0].scrollIntoView();", getABook());
		this.getABook().click();
	}
	
	public void addToCollection() throws InterruptedException {
		js.executeScript("arguments[0].scrollIntoView();", addToCollectionButton());
		this.addToCollectionButton().click();
	}
	
	public void clickOnProfileButton() throws InterruptedException {
		js.executeScript("arguments[0].scrollIntoView();", getProfileButton());
		Thread.sleep(2000);
		this.getProfileButton().click();
	}
	
}
