package tests;

import org.testng.Assert;

import org.testng.annotations.Test;

public class LogInTests extends BaseTests {
	
//	WebDriver driver;
//	MyAccountPage myAccountPage;
//	MainPage mainPage;
//	CartPage cartPage;
	

	
	@Test (priority = 0)
	public void logIn() throws InterruptedException {
		
		String username = citacIzExcela.getStringData("loginCorrect", 4, 5);
		String password = String.valueOf(citacIzExcela.getIntData("loginCorrect", 5, 5));
		String logOutText = citacIzExcela.getStringData("loginCorrect", 6, 5);
		
		mainPage.navigateToMyAccount();
		Thread.sleep(2000);
		//myAccountPage.logIn("customer","123456789");
		myAccountPage.insertUsername(username);
		Thread.sleep(2000);
		myAccountPage.insertPassword(password);
		Thread.sleep(2000);
		myAccountPage.logInButtonClick();
		Thread.sleep(2000);
		
		String textForAssert = myAccountPage.getLogOutLabel().getText();
		Assert.assertEquals(textForAssert, logOutText);
		}
	
	//@Test (priority = 3)
	public void logInWithWrongCredentials() throws InterruptedException {
		mainPage.navigateToMyAccount();
		Thread.sleep(2000);
		myAccountPage.insertUsername("custome");
		Thread.sleep(2000);
		myAccountPage.insertPassword("123456789");
		myAccountPage.logInButtonClick();
		Thread.sleep(2000);
		
		String textForAssert = myAccountPage.getErrorLabel().getText();
		Assert.assertEquals(textForAssert, "ERROR: Invalid username. Lost your password?");
	}
	
	//@Test (priority = 4)
	public void logInWithoutCredentials() throws InterruptedException {
		mainPage.navigateToMyAccount();
		Thread.sleep(2000);
//		myAccountPage.insertUsername("");
//		Thread.sleep(2000);
//		myAccountPage.insertPassword("");
		myAccountPage.logInButtonClick();
		Thread.sleep(2000);
		
		String textForAssert = myAccountPage.getErrorLabel().getText();
		Assert.assertEquals(textForAssert, "Error: Username is required.");
	}
	
	//@Test (priority = 10)
	public void logOutConfirm() throws InterruptedException {
		logIn();
		
		myAccountPage.getLogOutLabel().click();
		
		String loginText = myAccountPage.getLoginLabel().getText();
		Assert.assertEquals(loginText, "Login");
	}
}

//test; logovanje s pogresnim kredencijalima
//
//test: logovanje da niste uneli kredencijale
//
//test: izlogovati se

// U My Account page se mogu uneti .clear() metode da se obrisu eventualni prethodni unosi u svakom polju
//(pre nego sto getter vrati rezultat)

// dodatiProizvodUKorpu