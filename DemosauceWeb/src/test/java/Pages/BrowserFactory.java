package Pages;

import java.time.Duration;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserFactory {

	public static WebDriver driver;

	public WebDriver setupBrowser() {
		System.out.print("***************** Browser is started ***************");

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();

		return driver;
	}

	 
	public void closeBrowser() throws InterruptedException {
		System.out.print("----------------- Browser is closed!! --------------------");
		Thread.sleep(1000);
		driver.quit();
	}



}
