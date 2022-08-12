package qaautomation.Tugas4_juli;

import org.testng.Assert;
import org.testng.annotations.Test;



public class SaucedemoTest extends BaseWebSaucedemo{
	String username = "standard_user";
	String password = "secret_sauce";
	String errorUsername = "standru";
	String errorPassword = "ok";
	String usernameNull = "";
	String passwordNull = "";
	String firstName = "Silviani";
	String lastName = "Putri";
	String postalCode = "36472";
	 
	@Test 
	public void Login() {
		LoginPage loginPage = new LoginPage(getDriver(), getExplicitWait());
		CatalogPage catalogPage = new CatalogPage(getDriver(), getExplicitWait());
		
		loginPage.loginWeb(username,password);
		
		String actualText = catalogPage.getCatalogText();
//		System.out.println("actualText "+actualText);
		String expectedText = "PRODUCTS";
		Assert.assertTrue(actualText.contains(expectedText));
		Utility.hardWait(3);
	}
	
	@Test
	public void LoginFailed() {
		LoginPage loginPage = new LoginPage(getDriver(), getExplicitWait());
		
		
		loginPage.loginWeb(errorUsername,errorPassword);
		
		String actualMessageError = loginPage.getMessageError();
//		System.out.println("actualMessageError"+ actualMessageError);
		String expectedMessageText = "Username and password do not match any user in this service";
		Assert.assertTrue(actualMessageError.contains(expectedMessageText));
		Utility.hardWait(3);
	}
	
	@Test
	public void LoginFailedUsernameNull() {
		LoginPage loginPage = new LoginPage(getDriver(), getExplicitWait());
		
		
		loginPage.loginWeb(usernameNull,password);
		
		String actualMessageError = loginPage.getMessageErrorUsername();
//		System.out.println("actualMessageError"+ actualMessageError);
		String expectedMessageText = "Epic sadface: Username is required";
		Assert.assertTrue(actualMessageError.contains(expectedMessageText));
		Utility.hardWait(3);
	}
	
	@Test
	public void LoginFailedPasswordNull() {
		LoginPage loginPage = new LoginPage(getDriver(), getExplicitWait());
		
		
		loginPage.loginWeb(username,passwordNull);
		
		String actualMessageError = loginPage.getMessageErrorPassword();
//		System.out.println("actualMessageError"+ actualMessageError);
		String expectedMessageText = "Epic sadface: Password is required";
		Assert.assertTrue(actualMessageError.contains(expectedMessageText));
		Utility.hardWait(3);
	}
	
	
	@Test
	public void FinishOrder() {
		LoginPage loginPage = new LoginPage(getDriver(), getExplicitWait());
		CatalogPage catalogPage = new CatalogPage(getDriver(), getExplicitWait());
		CartPage cartPage = new CartPage(getDriver(), getExplicitWait());
		CheckoutPage checkoutPage = new CheckoutPage(getDriver(), getExplicitWait());
		
		//LOGIN 
		loginPage.loginWeb(username,password);
		String actualText = catalogPage.getCatalogText();
		String expectedText = "PRODUCTS";
		Assert.assertTrue(actualText.contains(expectedText));
		
		//CHOOSE & ADD CART
		catalogPage.clickAddCart();
		catalogPage.clickCart();
		String cartPageText = cartPage.getCartText();
		String expectedCartText = "YOUR CART";
		Assert.assertTrue(cartPageText.contains(expectedCartText));
		Utility.hardWait(1);
		
		// CHECKOUT & NEXT PAGE CHECKOUT
		cartPage.clickCheckout();
		String actualInformationText = checkoutPage.getInformationText();
//		System.out.println("actualInformationText "+actualInformationText);
		String expectedInformationText = "CHECKOUT: YOUR INFORMATION";
		Assert.assertTrue(actualInformationText.contains(expectedInformationText));
		
		// CHECKOUT INFORMATION & OVERVIEW 
		
		checkoutPage.checkOutPage(firstName, lastName, postalCode);
		String actualTextOverview = checkoutPage.getOverviewText();
//		System.out.println("actualTextOverview "+actualTextOverview);
		String expectedTextOverview = "CHECKOUT: OVERVIEW";
		Assert.assertTrue(actualTextOverview.contains(expectedTextOverview));
		
		// DONE CHECKOUT 
		checkoutPage.clickFinishButton();
		String actualCompleteText = checkoutPage.getCompleteText();
//		System.out.println("actualCompleteText "+actualCompleteText);
		String expectedCompleteText = "THANK YOU FOR YOUR ORDER";
		Assert.assertTrue(actualCompleteText.contains(expectedCompleteText));
		
		Utility.hardWait(3);
	}
}
