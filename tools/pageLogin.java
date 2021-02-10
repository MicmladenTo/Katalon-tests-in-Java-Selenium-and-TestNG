package tools;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class pageLogin {

	WebDriver driver;
	
	WebElement usernameField;
	WebElement passwordField;
	WebElement loginButton;
	WebElement logOutButton;
	
	//Getters
	public WebElement getUsernameField() {
		return driver.findElement(By.id("userName"));
	}

	public WebElement getPasswordField() {
		return driver.findElement(By.id("password"));
	}

	public WebElement getLoginButton() {
		return driver.findElement(By.id("login"));
	}
	
	public WebElement getLogOutButton() {
		return driver.findElement(By.id("submit"));
	}

	// Constructor
	public pageLogin(WebDriver driver) {
		this.driver = driver;
	}
	
	//Functions
	
	public void insertUsername() {
		this.getUsernameField().sendKeys("Micmladento");
	}
	
	public void insertPassword() {
		this.getPasswordField().sendKeys("RandomPass.10!");
	}
	
	public void clickLoginButton() {
		this.getLoginButton().click();
	}
	
	public void clickLogoutButton() {
		this.getLogOutButton().click();
	}
	

}
