package pages.objects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.gargoylesoftware.htmlunit.javascript.host.media.webkitMediaStream;

public class HomePageObjects extends BasePage{
	
	@FindBy(xpath = "//div[@id='block_top_menu']//ul[contains(@class,'menu-content')]/li[1]/a")
	private WebElement women;
	
	@FindBy(xpath = "//div[@id='block_top_menu']//ul[contains(@class,'menu-content')]/li[2]/a")
	private WebElement dresses;
	
	@FindBy(xpath = "//div[@id='block_top_menu']//ul[contains(@class,'menu-content')]/li[3]/a")
	private WebElement tshirts;
	
	//To check corresponding page is navigated or not
	@FindBy(className="cat-name")
	private WebElement womenPage;
	
	@FindBy(xpath = "//div[@id='categories_block_left']/h2")
	private WebElement dressesPage;
	
	@FindBy(className = "cat-name")
	private WebElement tshirtsPage;
	
	//finding element for newsLetter textbox
	@FindBy(id = "newsletter-input")
	private WebElement newsLetterField;
	
	//finding element of submit button in newsLetter
	@FindBy(name = "submitNewsletter")
	private WebElement submitButton;
	
	//finding alert success message
	@FindBy(className = "alert-success")
	private WebElement alertSuccessMsg;
	
	//finding element of each image
	@FindBy(xpath = "//ul[@id='homefeatured']/li")
	List<WebElement> productList;
	
	//finding first AddToCart Button
	@FindBy(xpath = "//ul[@class=\"product_list grid row\"]//li[1]//div[@class=\"right-block\"]//div[@class=\"button-container\"]/a[@title=\"Add to cart\"]/span")
	private WebElement AddtoCart;
	
	//finding first image
	@FindBy(xpath = "//img[@title = \"Faded Short Sleeve T-shirts\"]")
	private WebElement firstImage;
	
	//xpath for cross window
	@FindBy(xpath = "//span[@class='cross']")
	private WebElement closeWindowButton;
	
	//xpath for finding description row in cart page
	@FindBy(xpath = "//td[@class='cart_description']/p[@class='product-name']/a")
	private WebElement description;
	
	//xpath for cart page navigation button
	@FindBy(xpath = "//div[@class='shopping_cart']/a")
	private WebElement cartPageNav;
	
	//xpath for checkout button
	@FindBy (xpath = "//p[@class='cart_navigation clearfix']//span")
	private WebElement checkOutButton;
	
	//xpath for signin button
	@FindBy (id = "SubmitLogin")
	private WebElement signinBut;
	
	//xpath to find all the products in womens page
	@FindBy (xpath = "//ul[@class='product_list grid row']/li")
	private List<WebElement> allProducts;
	
	//xpath for table body in cart page
	@FindBy (xpath = "//tbody")
	private List<WebElement> cartProductsInfo;
	
	public HomePageObjects() {
		PageFactory.initElements(driver, this);
}

	
	public WebElement getWomenLink() {
		return women;
	}
	
	public WebElement getDressesLink() {

		return dresses;
	}
	
	public WebElement getTshirtsLink() {
		return tshirts;
	}
	
	//method to check corresponding women page is navigated or not
	public WebElement getWomenPage() {
			return womenPage;
	}
	
	public WebElement getDressesPage() {
		return dressesPage;
	}
	
	public WebElement getTshirtsPage() {
		return tshirtsPage;
	}
	
	public WebElement getNewLetter() {
		return newsLetterField;
	}
	
	public WebElement submit() {
		return submitButton;
	}
	
	public WebElement AlertSuccess() {
		return alertSuccessMsg;
	}
	
	public WebElement firstAddToCart() {
		return AddtoCart;
	}
	
	public WebElement selectFirstImage() {
		return firstImage;
	}
	
	public WebElement closeWindow() {
		return closeWindowButton;
	}
	
	public WebElement descriptionDis(){
		return description;
	}
	
	public WebElement cartPageNavigation() {
		return cartPageNav;
	}
	
	public WebElement checkOut() {
		return checkOutButton; 
	}
	
	public WebElement signin() {
		return signinBut;
	}
	
	public List<WebElement> getList(){
		return allProducts;
	}
	
	public boolean verifyAddToCart(WebElement product) {
		return product.findElement(By.xpath(".//*[text()='Add to cart']")).isDisplayed();
	}
	
	public boolean verifyMore(WebElement product) {
		return product.findElement(By.xpath(".//*[text()='More']")).isDisplayed();
	}
	
	public boolean verifyPrice(WebElement product) {
		return product.findElement(By.xpath("//span[@class='price product-price']")).isDisplayed();
	}
	
	public List<WebElement> cartProducts(){
		return cartProductsInfo;
	}
	
	//finding price of products in cart page
	public List<WebElement> productCartPrice(WebElement cartProduct){
		return cartProduct.findElements(By.xpath("//td[@class='cart_total']"));
	}
}
