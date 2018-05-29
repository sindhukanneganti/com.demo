package pages.Scripts;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.objects.BasePage;
import pages.objects.HomePageObjects;

public class HomePageTests {
	
	HomePageObjects homepage;//creating object for HomePageObjects.java class
	
	public HomePageTests() {
		homepage = new HomePageObjects(); 
	} 
	
	@Test
	public void verifyWomenTab() {
		Assert.assertTrue(homepage.getWomenLink().isDisplayed());
		
		//homepage.elementFound(homepage.getWomenLink());
	}
	
	
	@Test
	public void verifyDressesTab() {
		Assert.assertTrue(homepage.getDressesLink().isDisplayed());
	}
	
	@Test
	public void verifyTshirtsTab() {
		Assert.assertTrue(homepage.getTshirtsLink().isDisplayed());
	}
	
	@Test 
	public void navigate() {
		homepage.getWomenLink().click();
		Assert.assertTrue(homepage.getWomenPage().getText().contains("WOMEN"));
		
		homepage.getDressesLink().click();
		Assert.assertTrue(homepage.getDressesPage().getText().toLowerCase().contains("dresses"));
		
		homepage.getTshirtsLink().click();
		Assert.assertTrue(homepage.getTshirtsPage().getText().toLowerCase().contains("t-shirts "));	
	}
	
	/*@Test
	public void newsLetterSubscription() {
		homepage.setText(homepage.getNewLetter(), "test2890@gmail.com");
		homepage.submit().click();
		Assert.assertTrue(homepage.AlertSuccess().getText().contains(" Newsletter : You have successfully subscribed to this newsletter."));
	}*/
	
	/*@Test
	public void newsLetterSubscription() {
		homepage.setText(homepage.getNewLetter(), "test2399@gmail.com");
		homepage.submit().click();
		Assert.assertTrue(homepage.AlertSuccess().getText().equalsIgnoreCase("Newsletter : You have successfully subscribed to this newsletter."));
	}*/
	
	//To verify all products list
	@Test
	public void verifyProducts() {
		List<WebElement> products = homepage.getList();
		for(int i=0;i<products.size();i++) {
			
			Assert.assertTrue(homepage.verifyAddToCart(products.get(i)));
			Assert.assertTrue(homepage.verifyMore(products.get(i)));
			Assert.assertTrue(homepage.verifyPrice(products.get(i)));
			System.out.println(homepage.verifyAddToCart(products.get(i)));
			
		}
	}

	
	@Test
	public void verifyAddToCartFirstProduct() throws InterruptedException {
		
		homepage.getWomenLink().click();//goes to women page
		homepage.mouseHover(homepage.selectFirstImage());
		homepage.firstAddToCart().click();
		Thread.sleep(3000);
		homepage.closeWindow().click();
		homepage.cartPageNavigation().click();
		Assert.assertEquals(homepage.descriptionDis().getText(), "Faded Short Sleeve T-shirts");
			// System.out.println(homepage.descriptionDis().getText());
		}
	
	@Test
	public void verifySigninAfterCheckOut() {
		homepage.checkOut().click();
		Assert.assertTrue(homepage.signin().isDisplayed());
	}
	
	//Testing total price in add to cart page
	@Test
	public void verifyPriceInCartPage() {
		List<WebElement> allCartProducts= homepage.cartProducts();
		for(int i=0;i<allCartProducts.size()-1;i++) {
			allCartProducts.get(i).click();
			//Assert.assertEquals(allCartProducts.get(i), homepage.productCartPrice(allCartProducts.get(i)));
		}
	}
		
	}
