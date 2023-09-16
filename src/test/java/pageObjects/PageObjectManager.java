package pageObjects;

import org.openqa.selenium.WebDriver;

public class PageObjectManager {
	public WebDriver driver;
	public helperPageObject helper;
	
	public PageObjectManager(WebDriver driver)
	{
		this.driver = driver;
	}

	public helperPageObject getHelper()
	{
		helper = new helperPageObject(driver);
		return helper;
	}

}
