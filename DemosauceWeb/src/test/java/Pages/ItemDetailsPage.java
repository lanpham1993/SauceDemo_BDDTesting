package Pages;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class ItemDetailsPage {

	WebDriver driver=null;
	

	@FindBy (id="back-to-products")
	WebElement btnBackToHomepage;
	
	@FindBy(xpath="//button[contains(@class,'btn_inventory')]")
	WebElement btnAddToCart_Remove; 
	
	@FindBy(xpath="//div[@class='inventory_details_desc large_size']")
	WebElement description;
	
	@FindBy(className="inventory_details_price")
	WebElement price;
	
	@FindBy (css="div.inventory_details_name.large_size")
	WebElement itemName;

	public ItemDetailsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void clickBtnAddToCart_Remove() {
		btnAddToCart_Remove.click();
	}

	public void clickBtnBackToHomepage() {
		btnBackToHomepage.click();
	}
	
	//*******Check function*********
	
	
	public void checkDetail(String item) {
		for (String[] i : Homepage.desc) {
			if(i[0].equals(item)) {
				assertEquals(i[0],itemName.getText());
				assertEquals(i[1], description.getText());
				assertEquals(i[2], price.getText());
			}
		}
	}
	
}
