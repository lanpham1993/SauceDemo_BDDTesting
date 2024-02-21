package StepDefinitions;

import Pages.BrowserFactory;
import Pages.Homepage;
import Pages.ItemDetailsPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ItemDetailsSteps {

	Homepage home;
	ItemDetailsPage detail = new ItemDetailsPage(BrowserFactory.driver);
	
	@When("user clicks on link item")
	public void user_clicks_on_link_item() throws InterruptedException {
		home = new Homepage(BrowserFactory.driver);
	    home.clickLinkitem("item_0_title_link");
	    Thread.sleep(500);
	}

	@Then("detail of item is displayed")
	public void detail_of_item_is_displayed() {
	    detail.checkDetail("Sauce Labs Bike Light");
	}
	
	@When("user clicks on button Add to cart")
	public void user_clicks_on_button_add_to_cart() {
		detail.clickBtnAddToCart_Remove();
		Homepage.numberOfItems++;
		
	}

	@Then("button add to cart is changed to remove")
	public void button_add_to_cart_is_changed_to_remove() {
		
	}
}
