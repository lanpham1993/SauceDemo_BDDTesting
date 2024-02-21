package Pages;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.bouncycastle.its.jcajce.JceITSPublicEncryptionKey;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Homepage {
	WebDriver driver =null;

	@FindBy(xpath="//button[contains(@class,'btn_inventory')]")
	List<WebElement> btnAddToCart; 

	@FindBy (css="btn.btn_secondary.btn_small.btn_inventory")
	List<WebElement> btnRemove;  

	@FindBy(xpath="//a[@class='shopping_cart_link']")
	WebElement itemInCart;

	@FindBy(id="react-burger-menu-btn")
	WebElement btnMenu;

	@FindBy(id="inventory_sidebar_link")
	WebElement linkMenu_AllItem;

	@FindBy(id="about_sidebar_link")
	WebElement linkMenu_About;

	@FindBy(id="logout_sidebar_link")
	WebElement linkManu_Logout;

	@FindBy(id="reset_sidebar_link")
	WebElement linkManu_ResetApp;


	@FindBy (xpath="//div[@class='inventory_item_label']/a")
	List<WebElement> linkItem;
	
	public static Integer numberOfItems = 0;

	public static String[][] desc = {{"Sauce Labs Backpack", "carry.allTheThings() with the sleek, streamlined Sly Pack that melds uncompromising style with unequaled laptop and tablet protection.","$29.99"}, 
			{"Sauce Labs Bike Light", "A red light isn't the desired state in testing but it sure helps when riding your bike at night. Water-resistant with 3 lighting modes, 1 AAA battery included.","$9.99"},
			{"Sauce Labs Bolt T-Shirt", "Get your testing superhero on with the Sauce Labs bolt T-shirt. From American Apparel, 100% ringspun combed cotton, heather gray with red bolt.","$15.99"},
			{"Sauce Labs Fleece Jacket", "It's not every day that you come across a midweight quarter-zip fleece jacket capable of handling everything from a relaxing day outdoors to a busy day at the office.","$49.99"},
			{"Sauce Labs Onesie", "Rib snap infant onesie for the junior automation engineer in development. Reinforced 3-snap bottom closure, two-needle hemmed sleeved and bottom won't unravel.","$7.99"},
			{"Test.allTheThings() T-Shirt (Red)", "This classic Sauce Labs t-shirt is perfect to wear when cozying up to your keyboard to automate a few tests. Super-soft and comfy ringspun combed cotton.","$15.99"}
	};
	
	public Homepage(WebDriver driver) {
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}

	public void ClickAddToCart_Remove(String item) {
		for(WebElement btn: btnAddToCart) {
			if(btn.getAttribute("id").equals(item) ) {
				btn.click();
			}
		}
	}


	public void clickMenu() {
		btnMenu.click();
	}

	public void clickShoppingCartIcon() {
		itemInCart.click();
	}

	// click link item to open detail page
	public void clickLinkitem(String item) {
		for(WebElement link: linkItem) {
			if(link.getAttribute("id").equals(item) ) {
				link.click();
				break;
			}
		}
	}

	//*******Check function*********

	public void checkTitle() {
		assertEquals("https://www.saucedemo.com/inventory.html", driver.getCurrentUrl());
	}
	public void checkMenuIconIsDisplayed() {
		btnMenu.isDisplayed();
	}

	public void checkMenuContent() {
		linkMenu_AllItem.isDisplayed();
		assertEquals("All Items", linkMenu_AllItem.getText());


		linkMenu_About.isDisplayed();
		assertEquals("About", linkMenu_About.getText());

		linkManu_Logout.isDisplayed();
		assertEquals("Logout", linkManu_Logout.getText());

		linkManu_ResetApp.isDisplayed();
		assertEquals("Reset App State", linkManu_ResetApp.getText());
	}

	//check button of item is changed from Add to cart to remove
	public void checkNameBtnRemove(String item) {
		//System.out.print("*************" + btnRemove.size());
		for(WebElement btn: btnAddToCart) {
			if(btn.getAttribute("id").equals(item) ) {
				assertEquals("Remove", btn.getText());
			}
		}
	}

	//check button of item is changed from Remove to Add to cart
	public void checkNameBtnAddToCart(String item) {
		for(WebElement btn: btnAddToCart) {
			if(btn.getAttribute("id").equals(item) ) {
				assertEquals("Add to cart", btn.getText());
			}
		}
	}

	public void checkCartIcon(Integer numOfItems) {
		String shoppingCart=itemInCart.getText();
		if (shoppingCart == "") {
			shoppingCart = "0";
		}
		assertEquals( numOfItems.toString(), shoppingCart);
	}
}
