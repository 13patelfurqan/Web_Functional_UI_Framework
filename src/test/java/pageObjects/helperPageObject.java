package pageObjects;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.ArrayList;

public class helperPageObject {

    public WebDriver driver;
    public WebDriverWait wait;

    public helperPageObject(WebDriver driver) {
        this.driver = driver;
        System.out.println("Before WebDriverWait");
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        System.out.println("After WebDriverWait");
    }

    // Method to click on the specific element
    public void performActionOnElement(String locatorType, String locatorValue) {
        By by;
        switch (locatorType.toLowerCase()) {
            case "id":
                by = By.id(locatorValue);
                break;
            case "name":
                by = By.name(locatorValue);
                break;
            case "xpath":
                by = By.xpath(locatorValue);
                break;
            case "css":
                by = By.cssSelector(locatorValue);
                break;
            case "linktext":
                by = By.linkText(locatorValue);
                break;
            case "partiallinktext":
                by = By.partialLinkText(locatorValue);
                break;
            case "classname":
                by = By.className(locatorValue);
                break;
            case "tagname":
                by = By.tagName(locatorValue);
                break;
            default:
                throw new IllegalArgumentException("Invalid locator type: " + locatorType);
        }

        driver.findElement(by).click();

    }

    // Method to send text to the specific element
    public void enterTextOnElement(String text, String locatorType, String locatorValue) {
        By by;
        switch (locatorType.toLowerCase()) {
            case "id":
                by = By.id(locatorValue);
                break;
            case "name":
                by = By.name(locatorValue);
                break;
            case "xpath":
                by = By.xpath(locatorValue);
                break;
            case "css":
                by = By.cssSelector(locatorValue);
                break;
            case "linktext":
                by = By.linkText(locatorValue);
                break;
            case "partiallinktext":
                by = By.partialLinkText(locatorValue);
                break;
            case "classname":
                by = By.className(locatorValue);
                break;
            case "tagname":
                by = By.tagName(locatorValue);
                break;
            default:
                throw new IllegalArgumentException("Invalid locator type: " + locatorType);
        }

        driver.findElement(by).sendKeys(text);

    }

    // Method to open the URL
    public void navigateToURL(String url) {
        driver.get(url);
    }

    // Method to print the text for specific element
    public void getAndPrintTextFromElement(String locatorType, String locatorValue) {
        WebElement element = locateElement(locatorType, locatorValue);
        String elementText = element.getText();
        System.out.println("Text from element: " + elementText);
    }

    // Method to scroll down to the specific element
    public void scrollToElement(String locatorType, String locatorValue) {
        WebElement element = locateElement(locatorType, locatorValue);
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    // Method to scroll down to the specific element and get its text
    public void scrollToElementAndGetText(String locatorType, String locatorValue) {
        WebElement element = locateElement(locatorType, locatorValue);
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].scrollIntoView(true);", element);

        // Check if the element has text
        if (element.getText() != null && !element.getText().isEmpty()) {
            System.out.println(element.getText());
        } else {
            System.out.println("No text found for this element");
        }
    }

    // Method to select the option from the dropdown menu
    public void selectOptionFromDropdownByValue(String locatorType, String locatorValue, String optionValue) {
        WebElement dropdown = locateElement(locatorType, locatorValue);

        // Create a Select object
        Select select = new Select(dropdown);

        // Select the option by its value
        select.selectByValue(optionValue);
    }

    // Method to wait for an element until clickable
    public void waitForElementToBeClickable(String locatorType, String locatorValue) {
        wait.until(ExpectedConditions.elementToBeClickable(locateElement(locatorType, locatorValue)));
    }

    // Method for all 8 types of locators - Reusable function for any step and implementation
    private WebElement locateElement(String locatorType, String locatorValue) {
        By by;
        switch (locatorType.toLowerCase()) {
            case "id":
                by = By.id(locatorValue);
                break;
            case "name":
                by = By.name(locatorValue);
                break;
            case "xpath":
                by = By.xpath(locatorValue);
                break;
            case "css":
                by = By.cssSelector(locatorValue);
                break;
            case "linktext":
                by = By.linkText(locatorValue);
                break;
            case "partiallinktext":
                by = By.partialLinkText(locatorValue);
                break;
            case "classname":
                by = By.className(locatorValue);
                break;
            case "tagname":
                by = By.tagName(locatorValue);
                break;
            default:
                throw new IllegalArgumentException("Invalid locator type: " + locatorType);
        }

        return driver.findElement(by);
    }

    // Method to assert the URL
    public void assertURL(String expectedURL) {

        String actualURL = driver.getCurrentUrl();

        if (actualURL.equals(expectedURL)) {
            System.out.println("URL assertion passed. Actual URL: " + actualURL);
        } else {
            throw new AssertionError("URL assertion failed. Expected URL: " + expectedURL + ", Actual URL: " + actualURL);
        }
    }

    // Method to scroll down the page
    public void scrollPage(int pixelsToScroll) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("window.scrollBy(0, " + pixelsToScroll + ");");
    }

    // Method to scroll up the page
    public void scrollUp(int pixelsToScroll) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("window.scrollBy(0, -" + pixelsToScroll + ");");
    }

    // Method to open a new tab with a specific URL and switch to it
    public void openNewTabWithUrl(String url) {
        ((JavascriptExecutor) driver).executeScript("window.open()");

        // Switch to the new tab
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(tabs.size() - 1));

        // Navigate to the specified URL
        driver.get(url);
    }

    // Method to refresh the page
    public void refreshPage() {
        driver.navigate().refresh();
    }

    // Method to navigate back to the page
    public void navigateBack() {
        driver.navigate().back();
    }

    // Method to navigate forward to the next page
    public void navigateForward() {
        driver.navigate().forward();
    }

    public void pressKey(String keyName) {
        Actions actions = new Actions(driver);

        switch (keyName.toLowerCase()) {
            case "enter":
                actions.sendKeys(Keys.ENTER).perform();
                break;
            case "tab":
                actions.sendKeys(Keys.TAB).perform();
                break;
            case "backspace":
                actions.sendKeys(Keys.BACK_SPACE).perform();
                break;
            case "esc":
                actions.sendKeys(Keys.ESCAPE).perform();
                break;
            case "space":
                actions.sendKeys(Keys.SPACE).perform();
                break;
            case "pagedown":
                actions.sendKeys(Keys.PAGE_DOWN).perform();
                break;
            case "pageup":
                actions.sendKeys(Keys.PAGE_UP).perform();
                break;
            case "up":
                actions.sendKeys(Keys.ARROW_UP).perform();
                break;
            case "down":
                actions.sendKeys(Keys.ARROW_DOWN).perform();
                break;
            case "right":
                actions.sendKeys(Keys.ARROW_RIGHT).perform();
                break;
            case "left":
                actions.sendKeys(Keys.ARROW_LEFT).perform();
                break;
            default:
                throw new IllegalArgumentException("Invalid key: " + keyName);
        }
    }

    public void assertPageTitle(String expectedTitle) {
        wait.until(ExpectedConditions.titleIs(expectedTitle));
        String actualTitle = driver.getTitle();
        if (actualTitle.equals(expectedTitle)) {
            System.out.println("Page Title has matched: " + expectedTitle);
        } else {
            throw new AssertionError("Page title does not match the expected title: " + expectedTitle);
        }
    }

    public void dragAndDropElement(String sourceLocatorType, String sourceLocatorValue, String targetLocatorType, String targetLocatorValue) {
        Actions actions = new Actions(driver);

        // Wait for the source and target elements to be present
        WebElement sourceElement = wait.until(ExpectedConditions.presenceOfElementLocated((By) locateElement(sourceLocatorType, sourceLocatorValue)));
        WebElement targetElement = wait.until(ExpectedConditions.presenceOfElementLocated((By) locateElement(targetLocatorType, targetLocatorValue)));

        // Perform drag and drop
        actions.dragAndDrop(sourceElement, targetElement).build().perform();
    }

    public void selectCheckbox(String locatorType, String locatorValue) {
        WebElement checkbox = locateElement(locatorType, locatorValue);

        if (!checkbox.isSelected()) {
            Actions actions = new Actions(driver);
            actions.moveToElement(checkbox).click().perform();
        }
    }

    public void selectRadioButton(String locatorType, String locatorValue) {
        WebElement radioButton = locateElement(locatorType, locatorValue);

        if (!radioButton.isSelected()) {
            Actions actions = new Actions(driver);
            actions.moveToElement(radioButton).click().perform();
        }
    }

    public boolean isElementVisible(String locatorType, String locatorValue) {
        WebElement element = locateElement(locatorType, locatorValue);

        try {
            wait.until(ExpectedConditions.visibilityOf(element));
            System.out.println("Element visible/found");
            return true;
        } catch (TimeoutException e) {
            System.out.println("Element not visible/found");
            return false;
        }
    }

    public void clearTextFromElement(String locatorType, String locatorValue) {
        WebElement element = locateElement(locatorType, locatorValue);
        element.clear();
    }

    public void switchToFrame(String locatorType, String locatorValue) {
        WebElement frameElement = locateElement(locatorType, locatorValue);
        driver.switchTo().frame(frameElement);
    }

    public void switchToDefaultContent() {
        driver.switchTo().defaultContent();
    }

    public void acceptAlert() {
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }

    public void dismissAlert() {
        Alert alert = driver.switchTo().alert();
        alert.dismiss();
    }

    public void assertPageSourceContains(String expectedText) {
        String pageSource = driver.getPageSource();
        Assert.assertTrue(pageSource.contains(expectedText), "Expected text '" + expectedText + "' is not present on the page.");
        System.out.println("The Expected Text to be match is: " + expectedText);
    }


    public void assertElementText(String expectedText, String locatorType, String locatorValue) {
        WebElement element = locateElement(locatorType, locatorValue);
        String actualText = element.getText().trim(); // Trim leading and trailing whitespace

        System.out.println("Actual Text: " + actualText); // Print the actual text

        if (!expectedText.equals(actualText)) {
            System.out.println("Expected Text: " + expectedText);
            Assert.assertEquals("Element text does not match the expected text. Expected: " + expectedText + " Actual: " + actualText, expectedText, actualText);
        }
    }

    public void assertElementAttribute(String locatorType, String locatorValue, String attributeName, String expectedValue) {
        WebElement element = locateElement(locatorType, locatorValue);
        String actualValue = element.getAttribute(attributeName);

        if (expectedValue.equals(actualValue)) {
            System.out.println("PASS: Expected value '" + expectedValue + "' matched the actual value. '" + actualValue + "'.");
        } else {
            System.out.println("FAIL: Expected value '" + expectedValue + "' did not match the actual value '" + actualValue + "'.");
            Assert.assertEquals("Element attribute value does not match the expected value.", expectedValue, actualValue);
        }
    }














}
