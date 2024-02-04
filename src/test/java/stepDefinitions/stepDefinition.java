package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.helperPageObject;
import utils.TestContextSetup;

import static org.testng.Assert.assertTrue;

public class stepDefinition {

    public helperPageObject helperPO;
    TestContextSetup testContextSetup;

    public stepDefinition(TestContextSetup testContextSetup) {
        this.testContextSetup = testContextSetup;
        this.helperPO = testContextSetup.pageObjectManager.getHelper();
    }

    @When("^I click on element with (id|name|xpath|css|linktext|partiallinktext|classname|tagname) \"([^\"]*)\"$")
    public void performActionOnElement(String locatorType, String locatorValue) {
        helperPO.performActionOnElement(locatorType, locatorValue);
    }

    @When("^I enter text \"([^\"]*)\" on element with (id|name|xpath|css|linktext|partiallinktext|classname|tagname) \"([^\"]*)\"$")
    public void enterTextOnElement(String text, String locatorType, String locatorValue) {
        helperPO.enterTextOnElement(text, locatorType, locatorValue);
    }

    @When("^I navigate to the URL \"([^\"]*)\"$")
    public void navigateToURL(String url) {
        helperPO.navigateToURL(url);
    }

    @When("I get and print text from element with {string} {string}")
    public void i_get_and_print_text_from_element(String locatorType, String locatorValue) {
        helperPO.getAndPrintTextFromElement(locatorType, locatorValue);
    }

    @When("I scroll to the element with {string} {string}")
    public void i_scroll_to_element_with(String locatorType, String locatorValue) {
        helperPO.scrollToElement(locatorType, locatorValue);
    }

    @When("I scroll to the element with {string} {string} and get its text")
    public void i_scroll_to_element_with_and_get_text(String locatorType, String locatorValue) {
        helperPO.scrollToElementAndGetText(locatorType, locatorValue);
    }

    @Then("the URL should be {string}")
    public void the_url_should_be(String expectedURL) {
        helperPO.assertURL(expectedURL);
    }

    @When("I scroll the page by {int} pixels")
    public void i_scroll_the_page_by_pixels(int pixelsToScroll) {
        helperPO.scrollPage(pixelsToScroll);
    }

    @When("I scroll up the page by {int} pixels")
    public void i_scroll_up_the_page_by_pixels(int pixelsToScroll) {
        helperPO.scrollUp(pixelsToScroll);
    }

    @When("I select the option with value {string} from the dropdown with {string} {string}")
    public void i_select_option_from_dropdown(String optionValue, String locatorType, String locatorValue) {
        helperPO.selectOptionFromDropdownByValue(locatorType, locatorValue, optionValue);
    }

    @When("I open a new tab with URL {string}")
    public void openNewTabWithUrl(String url) {
        helperPO.openNewTabWithUrl(url);
    }

    @When("I refresh the page")
    public void i_refresh_the_page() {
        helperPO.refreshPage();
    }

    @When("I navigate back to the previous page")
    public void i_navigate_back_to_previous_page() {
        helperPO.navigateBack();
    }

    @When("I navigate forward to the next page")
    public void i_navigate_forward_to_next_page() {
        helperPO.navigateForward();
    }

    @When("I wait for element with {string} locator to be clickable")
    public void i_wait_for_element_with_locator_to_be_clickable(String locator) {
        String[] locatorParts = locator.split(" "); // Split the locator string, e.g., "id username"
        if (locatorParts.length != 2) {
            throw new IllegalArgumentException("Invalid locator format: " + locator);
        }
        String locatorType = locatorParts[0];
        String locatorValue = locatorParts[1];
        helperPO.waitForElementToBeClickable(locatorType, locatorValue);
    }

    @When("I press the {string} key")
    public void iPressKey(String keyName) {
        helperPO.pressKey(keyName);
    }

    @Then("the page title should be {string}")
    public void thePageTitleShouldBe(String expectedTitle) {
        helperPO.assertPageTitle(expectedTitle);
    }

    @When("I drag element with locator type {string} and locator value {string} to element with locator type {string} and locator value {string}")
    public void iDragElementToAnother(String sourceLocatorType, String sourceLocatorValue, String targetLocatorType, String targetLocatorValue) {
        helperPO.dragAndDropElement(sourceLocatorType, sourceLocatorValue, targetLocatorType, targetLocatorValue);
    }

    @When("I select the checkbox with {string} {string}")
    public void iSelectTheCheckbox(String locatorType, String locatorValue) {
        helperPO.selectCheckbox(locatorType, locatorValue);
    }

    @When("I select the radio button with {string} and locator value {string}")
    public void iSelectTheRadioButton(String locatorType, String locatorValue) {
        helperPO.selectRadioButton(locatorType, locatorValue);
    }

    @Then("the element with {string} and locator value {string} should be visible")
    public void theElementShouldBeVisible(String locatorType, String locatorValue) {
        boolean isVisible = helperPO.isElementVisible(locatorType, locatorValue);
        assertTrue(isVisible, "Element is not visible");
    }

    @When("I clear text from element with {string} {string}")
    public void iClearTextFromElement(String locatorType, String locatorValue) {
        helperPO.clearTextFromElement(locatorType, locatorValue);
    }

    @When("I switch to frame with {string} {string}")
    public void iSwitchToFrame(String locatorType, String locatorValue) {
        helperPO.switchToFrame(locatorType, locatorValue);
    }

    @When("I switch back to default content")
    public void iSwitchToDefaultContent() {
        helperPO.switchToDefaultContent();
    }

    @When("I accept the alert")
    public void iAcceptAlert() {
        helperPO.acceptAlert();
    }

    @When("I dismiss the alert")
    public void iDismissAlert() {
        helperPO.dismissAlert();
    }

    @Then("I should see the page source containing {string}")
    public void iShouldSeePageSourceContaining(String expectedText) {
        helperPO.assertPageSourceContains(expectedText);
    }

    @Then("I should see the text {string} in the element with {string} {string}")
    public void iShouldSeeTextInElement(String expectedText, String locatorType, String locatorValue) {
        helperPO.assertElementText(expectedText, locatorType, locatorValue);
    }

    @Then("the element with {string} {string} should have the attribute {string} with value {string}")
    public void elementShouldHaveAttributeWithValue(String locatorType, String locatorValue, String attributeName, String expectedValue) {
        helperPO.assertElementAttribute(locatorType, locatorValue, attributeName, expectedValue);
    }

    @And("^I wait for (\\d+) seconds$")
    public void iWaitForSeconds(int seconds) {
        helperPO.sleep(seconds);
    }

    @When("I refresh the page until element with {string} {string} is visible")
    public void iRefreshPageUntilElementVisible(String locatorType, String locatorValue) {
        helperPO.refreshUntilElementVisible(locatorType, locatorValue);
    }


}
