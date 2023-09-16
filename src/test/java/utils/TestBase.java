package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class TestBase {

	public WebDriver driver;

	public WebDriver getWebDriver() throws IOException {
		if (driver == null) {
			FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "//src//test//resources//global.properties");
			Properties prop = new Properties();
			prop.load(fis);

			String browser_properties = prop.getProperty("browser");
			String browser_maven = System.getProperty("browser");

			String browser = browser_maven != null ? browser_maven : browser_properties;

			if (browser.equalsIgnoreCase("chrome")) {
				System.setProperty("org.slf4j.simpleLogger.defaultLogLevel", "error");
				System.setProperty("webdriver.http.factory", "jdk-http-client");
				WebDriverManager.chromedriver().setup();
				ChromeOptions options = new ChromeOptions();
				options.addArguments("--remote-allow-origins=*");
				driver = new ChromeDriver(options);
			} else if (browser.equalsIgnoreCase("firefox")) {
				WebDriverManager.firefoxdriver().setup();
				FirefoxOptions options = new FirefoxOptions();
				// Specify the path to the Firefox browser binary
				options.setBinary("C:/Program Files/Mozilla Firefox");
				driver = new FirefoxDriver(options);
			}

			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		}
		return driver;
	}
}
