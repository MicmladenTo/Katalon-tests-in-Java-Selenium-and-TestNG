package tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import pages.CartPage;
import pages.MainPage;
import pages.MyAccountPage;

public class BaseTests {
			
	WebDriver driver;
	MyAccountPage myAccountPage;
	MainPage mainPage;
	CartPage cartPage;
	LogInTests logInTests;
	ExcelCitac citacIzExcela;
	
	@BeforeClass
	public void preKlase() throws IOException {
		System.setProperty("webdriver.chrome.driver",
				"driver-lib\\chromedriver.exe");
		
		this.driver = new ChromeDriver();
		this.myAccountPage = new MyAccountPage(driver);
		this.mainPage = new MainPage(driver);
		this.cartPage = new CartPage(driver);
		citacIzExcela = new ExcelCitac("data/testplan.xlsx");
		driver.manage().window().maximize();
	}
	
	
	@BeforeMethod
	public void setup() throws InterruptedException {
		driver.navigate().to("http://cms.demo.katalon.com/");
		Thread.sleep(2000);
	}
	
	
	@AfterMethod
	public void afterTest() throws InterruptedException {
		driver.manage().deleteAllCookies();
		driver.navigate().refresh();
		Thread.sleep(2000);
	}
	
	@AfterClass
	public void pposleKlase() {
		driver.close();
		System.out.println("Izvrsava se posle klase");
	}
	
	
}
