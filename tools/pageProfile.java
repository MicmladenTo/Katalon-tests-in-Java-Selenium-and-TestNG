package tools;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class pageProfile {

	WebDriver driver;
	JavascriptExecutor js;
	
	WebElement collectionBookTitle;
	WebElement deleteAllBooksButton;
	WebElement deletionConfirmationButton;
	WebElement deleteSingleBookButton;
	WebElement emptySpan;
	
	// Getters
	public WebElement getCollectionBookTitle() {
		return driver.findElement(By.xpath("//*[@id=\"see-book-Eloquent JavaScript, Second Edition\"]"));
	}
	
	public WebElement getDeleteAllBooksButton() {
		return driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div[2]/div[1]/div[3]/div[3]/button"));
	}
	
	public WebElement getDeletionConfirmationButton() {
		return driver.findElement(By.id("closeSmallModal-ok"));
	}
	
	public WebElement getDeleteSingleBookButton() {
		return driver.findElement(By.id("delete-record-undefined"));
	}	
	
	public WebElement getEmptySpan() {
		return driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[2]/div[2]/div[1]/div[2]/div[1]/div[2]/div[1]/div/div[1]/span"));
	}	
	
	
	

	

	// Konstruktor
	public pageProfile(JavascriptExecutor js, WebDriver driver) {
		super();
		this.js = (JavascriptExecutor)driver;
		this.driver = driver;
	}
	
	//Functions
	public void deleteAllBooks() {
		js.executeScript("arguments[0].scrollIntoView();", getDeleteAllBooksButton());
		getDeleteAllBooksButton().click();
	}
	
	public void confirmDeletion() {
		getDeletionConfirmationButton().click();
	}
	
	
}
