package tools;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class testTools {

	WebDriver driver;
	JavascriptExecutor js = (JavascriptExecutor)driver;
	
	pageLogin PageLogin;
	pageBooks PageBooks;
	pageTools PageTools;
	pageProfile PageProfile;

	@BeforeClass
	public void preKlase() {
		System.setProperty("webdriver.chrome.driver",
				"driver-lib\\chromedriver.exe");
		
		this.driver = new ChromeDriver();
		this.PageLogin = new pageLogin(driver);
		this.PageTools = new pageTools(driver);
		this.PageBooks = new pageBooks(js, driver);
		this.PageProfile = new pageProfile(js, driver);

		driver.manage().window().maximize();
	}
	
	/*
	@BeforeMethod
	public void goToWebsite() throws InterruptedException {
//		driver.navigate().to("https://demoqa.com/");
//		Thread.sleep(2000);

	}
	*/
	
	@Test (priority = 1)
	public void logIntoBookstore() throws InterruptedException {
		driver.navigate().to("https://demoqa.com/");
		PageTools.goToBookStore();
		Thread.sleep(4000);
		PageBooks.clickLoginButton();
		PageLogin.insertUsername();
		PageLogin.insertPassword();
		PageLogin.clickLoginButton();
		Thread.sleep(5000);
		
		String logOutButtonText = PageLogin.getLogOutButton().getText();
		Assert.assertEquals(logOutButtonText, "Log out");
	}
	
	@Test (priority = 2)
	public void addBookToCollection() throws InterruptedException {
		Thread.sleep(2000);
		PageBooks.clickOnABook();
		Thread.sleep(4000);
		PageBooks.addToCollection();
		Thread.sleep(2000);
		driver.switchTo().alert().accept();
		
//		Actions builder = new Actions(driver);
//	    builder.moveToElement(producCategorytMenu).perform();
//	    builder.click(producCategorytMenu).perform();
	    
		Thread.sleep(4000);
		PageBooks.clickOnProfileButton();
		Thread.sleep(5000);
		Thread.sleep(2000);
		
		//Compare book titles
		Assert.assertEquals(PageProfile.getCollectionBookTitle().getText(), PageBooks.getABook().getText());
		Thread.sleep(5000);
	}
	
	@Test (priority = 3)
	public void deleteAllBooksFromCollection() throws InterruptedException {
	
		PageProfile.deleteAllBooks();
		Thread.sleep(2000);
		PageProfile.confirmDeletion();
		Thread.sleep(5000);
		driver.switchTo().alert().accept();
		Thread.sleep(2000);
		
		Assert.assertEquals(PageProfile.getEmptySpan().getText(), " ");
		
//		Assert.assertNull(PageProfile.getDeleteSingleBookButton());
	
	}
	
	
	@Test (priority = 10)
	public void logOutOfBookstore() throws InterruptedException {
//		logIntoBookstore();
		PageLogin.clickLogoutButton();
		
		String loginButtonText = PageLogin.getLoginButton().getText();
		Assert.assertEquals(loginButtonText, "Login");
		
	}

	
	@AfterClass
	public void pposleKlase() throws InterruptedException {
		driver.manage().deleteAllCookies();
		driver.navigate().refresh();
		Thread.sleep(2000);
//		driver.close();
		System.out.println("Kraj programa.");
	}

	
	
}
