package StepDefinitions;


import Pages.BrowserFactory;
import Pages.Homepage;
import Pages.LoginPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps extends BrowserFactory{
	LoginPage login;

	@Before
	public void OpenBrowser() {
		driver = setupBrowser();
	}


	@Given("^user is on login page$")
	public void OpenLoginPage() {		
		driver.navigate().to("https://www.saucedemo.com");
	}

	@When("^user enters (.*) and (.*)$")
	public void user_enters_standard_user_and_secret_sauce(String username,String password) throws InterruptedException {
		login = new LoginPage(driver);
		login.enterUsername(username);
		login.enterPassword(password);
		Thread.sleep(1000);
	}

	@And("^user clicks on login$")
	public void user_clicks_on_login() {
		login.clickLogin();
	}

	@Then("^user is navigated to the home page$")
	public void user_is_navigated_to_the_home_page() throws InterruptedException {
		Homepage home = new Homepage(driver) ;
		home.checkTitle();
		home.checkMenuIconIsDisplayed();
	}


	@Then("Error will be displayed")
	public void error_will_be_displayed() {
		login.checkErrorMessage();
	}

	@After
	public void Teardown() throws InterruptedException {
		closeBrowser();

	}

}
