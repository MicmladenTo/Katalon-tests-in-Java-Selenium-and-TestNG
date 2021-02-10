package tests;
import org.testng.Assert;
import org.testng.annotations.Test;


public class CartTests extends BaseTests {	
	
	@Test (priority = 5)
	public void addProduct() throws InterruptedException {
		
		cartPage.getAddToCartButton().click();
		Thread.sleep(2000);
		cartPage.getCartTab().click();
		Thread.sleep(2000);
		
		String removeButtonText = cartPage.getRemoveProductButton().getText();
		Assert.assertEquals(removeButtonText, "×");
	}
	
	@Test (priority = 6)
	public void deleteproduct() throws InterruptedException {
		addProduct();
		Thread.sleep(2000);
		cartPage.removeProduct();
		Thread.sleep(2000);
		
		String productRemovalVerification = cartPage.cartEmptyNotification().getText();
		Assert.assertEquals(productRemovalVerification, citacIzExcela.getStringData("productRemoval", 5, 5));
	}
	
	@Test (priority = 10)
	public void addThreeProducts() throws InterruptedException {
		
		cartPage.addThreeProducts();
		Thread.sleep(2000);
		cartPage.getCartTab().click();
		Thread.sleep(2000);
		
		Assert.assertEquals(cartPage.getFirstProductURL(), "http://cms.demo.katalon.com/product/flying-ninja/");
		Assert.assertEquals(cartPage.getSecondProductURL(), "http://cms.demo.katalon.com/product/happy-ninja-2/");
		Assert.assertEquals(cartPage.getThirdProductURL(), "http://cms.demo.katalon.com/product/happy-ninja/");

		Assert.assertEquals(cartPage.getRemoveProductButtons().size(), 3);
		
		cartPage.assertSingleItem();
	}
	
	@Test (priority = 11)
	public void addTwoProducts() throws InterruptedException {
		
		cartPage.addTwoProducts();
		Thread.sleep(2000);
		cartPage.getCartTab().click();
		Thread.sleep(2000);
		
		Assert.assertEquals(cartPage.getFirstProductURL(), "http://cms.demo.katalon.com/product/flying-ninja/");
		Assert.assertEquals(cartPage.getSecondProductURL(), "http://cms.demo.katalon.com/product/happy-ninja-2/");
		
		Assert.assertEquals(cartPage.getRemoveProductButtons().size(), 2);
		cartPage.assertSingleItem();
		
		cartPage.removeProduct();
		Thread.sleep(2000);
		
		Assert.assertEquals(cartPage.getRemoveProductButtons().size(), 1);
		cartPage.assertSingleItem();
	}
}
