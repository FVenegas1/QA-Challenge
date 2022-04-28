package sauceApplication;

import java.util.jar.Attributes.Name;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ISelect;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestSeries {

	ChromeDriver driver;
	String url ="https://www.saucedemo.com/";
	@BeforeMethod
	public void invokeBrowser() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\ferna\\Desktop\\Testing\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(url);
	}
//Validation for correct page
	@Test
	public void verifyTitleOfThePage() {
		String expectedTitle = "Swag Labs";
		String actualTitle = driver.getTitle();
		Assert.assertEquals(actualTitle,expectedTitle);
	}
//Test A: Login with a valid user
	@Test
	public void verifyLogin() {
		WebElement userId = driver.findElement(By.name("user-name"));
		WebElement userPassword = driver.findElement(By.name("password"));
		WebElement loginButton = driver.findElement(By.name("login-button"));
		userId.sendKeys("standard_user");
		userPassword.sendKeys("secret_sauce");
		loginButton.click();
//Correct login validation
		String expectedWebSite = "https://www.saucedemo.com/inventory.html";
		String actualWebSite = driver.getCurrentUrl();
		Assert.assertEquals(actualWebSite,expectedWebSite);			
	}
//Test B: Login with an invalid user
	@Test
	public void invalidLogin() {
		WebElement userId = driver.findElement(By.name("user-name"));
		WebElement userPassword = driver.findElement(By.name("password"));
		WebElement loginButton = driver.findElement(By.name("login-button"));
		userId.sendKeys("standaruser");
		userPassword.sendKeys("secret_sauce");
		loginButton.click();
//Test B Validation
//		WebElement invalidUserPop = driver.findElement(By.className("error-message-container error")); 
//		System.out.println("Invalid User box -" + invalidUserPop);				
	}
//Test C: Logout from main page
	@Test
	public void correctLogout() {
		WebElement userId = driver.findElement(By.name("user-name"));
		WebElement userPassword = driver.findElement(By.name("password"));
		WebElement loginButton = driver.findElement(By.name("login-button"));
		userId.sendKeys("standard_user");
		userPassword.sendKeys("secret_sauce");
		loginButton.click();
//Starting logout
		WebElement menuBtn = driver.findElement(By.id("react-burger-menu-btn"));
		menuBtn.click();
		WebElement logoutBtn = driver.findElement(By.id("logout_sidebar_link"));
		logoutBtn.click();
//Validation for correct logout
		String expectedWebSite = "https://www.saucedemo.com/";
		String actualWebSite = driver.getCurrentUrl();
		Assert.assertEquals(actualWebSite,expectedWebSite);	
		}
//Test D: Classify products by price
	@Test
	public void sortProducts() {
//Starting logout
		WebElement sortBtn = driver.findElement(By.cssSelector("product_sort_container"));
		sortBtn.click();
		WebElement sortOption = driver.findElement(By.cssSelector("lohi"));
		sortOption.click();
	}
//Test E&F: Add different items to cart
	@Test
	public void addItems2Cart() {
		WebElement userId = driver.findElement(By.name("user-name"));
		WebElement userPassword = driver.findElement(By.name("password"));
		WebElement loginButton = driver.findElement(By.name("login-button"));
		userId.sendKeys("standard_user");
		userPassword.sendKeys("secret_sauce");
		loginButton.click();
		WebElement onesie2cartBtn = driver.findElement(By.name("add-to-cart-sauce-labs-onesie"));
		onesie2cartBtn.click();
		WebElement bikeLight2cartBtn = driver.findElement(By.name("add-to-cart-sauce-labs-bike-light"));
		bikeLight2cartBtn.click();
		WebElement backpack2cartBtn = driver.findElement(By.name("add-to-cart-sauce-labs-backpack"));
		backpack2cartBtn.click();
		WebElement jacket2cartBtn = driver.findElement(By.name("add-to-cart-sauce-labs-fleece-jacket"));
		jacket2cartBtn.click();		
	}
//Test G: Complete purchase
	@Test
	public void purchaseComplete() {
		verifyLogin();
		addItems2Cart();
//Starting purchase at cart
		WebElement cartBtn = driver.findElement(By.className("shopping_cart_link"));
		cartBtn.click();
		WebElement checkoutBtn = driver.findElement(By.name("checkout"));
		checkoutBtn.click();
//Filling with personal info
		WebElement firstName = driver.findElement(By.name("firstName"));
		WebElement lastName = driver.findElement(By.name("lastName"));
		WebElement zipCode = driver.findElement(By.name("postalCode"));
		WebElement continuePrchseBtn = driver.findElement(By.name("continue"));
		WebElement finishBtn = driver.findElement(By.name("finish"));
		firstName.sendKeys("Fernando");
		lastName.sendKeys("Venegas");
		zipCode.sendKeys("76246");
        continuePrchseBtn.click();
        finishBtn.click();       
}
}
