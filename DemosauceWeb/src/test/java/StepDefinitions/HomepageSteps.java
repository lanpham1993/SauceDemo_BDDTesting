package StepDefinitions;


import Pages.BrowserFactory;
import Pages.Homepage;
import Pages.ItemDetailsPage;
import Pages.LoginPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class HomepageSteps {

	LoginPage login;
	Homepage home;
	ItemDetailsPage detail;
	

	@When("user logins susscessful")
	public void user_logins_susscessful() throws InterruptedException {
		login =  new LoginPage(BrowserFactory.driver);
		login.enterUsername("standard_user");
		login.enterPassword("secret_sauce");
		Thread.sleep(500);
		login.clickLogin();
		home = new Homepage(BrowserFactory.driver);
		
	}

	@Then("button Add to cart is changed to Remove")
	public void buttonAddToCartChangeToRemove() {
		home.checkNameBtnRemove("remove-sauce-labs-backpack");
		home.checkNameBtnRemove("remove-sauce-labs-fleece-jacket");
	}

	@When("user adds some items to cart")
	public void user_adds_some_items_to_cart() throws InterruptedException {
		home.ClickAddToCart_Remove("add-to-cart-sauce-labs-backpack");
		Homepage.numberOfItems++;
		home.ClickAddToCart_Remove("add-to-cart-sauce-labs-fleece-jacket");
		Homepage.numberOfItems++;
		Thread.sleep(500);
	}

	@Then("number of items is displayed corresponding in shopping cart icon")
	public void number_of_items_is_displayed_in_shopping_cart_icon() {
		home.checkCartIcon(Homepage.numberOfItems);
	}


	@When("user adds item to cart")
	public void user_adds_item_to_cart() throws InterruptedException {
		home.ClickAddToCart_Remove("add-to-cart-sauce-labs-onesie");
		Homepage.numberOfItems++;
		Thread.sleep(500);
	}


	@When("clicks Remove item has just added")
	public void clicks_remove_item_has_just_added() {
		home.ClickAddToCart_Remove("remove-sauce-labs-onesie");
		Homepage.numberOfItems--;
	}

	@Then("button Remove is changed to Add To Cart")
	public void button_remove_is_changed_to_add_to_cart() {
		home.checkNameBtnAddToCart("add-to-cart-sauce-labs-onesie");
	}

	
}
