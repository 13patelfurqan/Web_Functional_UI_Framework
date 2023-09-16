Feature: Validation of the Functions implemented in the Framework

  @SampleTC_01
  Scenario Outline: Navigate to the Site and Test Login Functionality
    Given I navigate to the URL "https://www.saucedemo.com/v1/"
    When I enter text "<username>" on element with id "user-name"
    Then I enter text "<password>" on element with id "password"
    And I click on element with id "login-button"

    Examples:
      | username      | password     |
      | standard_user | secret_sauce |

  @SampleTC_02
  Scenario Outline: Validate Password field validation
    Given I navigate to the URL "https://www.saucedemo.com/v1/"
    When I enter text "<username>" on element with id "user-name"
    Then I click on element with id "login-button"
    And I get and print text from element with "xpath" "//h3[@data-test='error']"

    Examples:
      | username      |
      | standard_user |

  @SampleTC_03
  Scenario Outline:  Validate Username field validation
    Given I navigate to the URL "https://www.saucedemo.com/v1/"
    When I enter text "<password>" on element with id "password"
    Then I click on element with id "login-button"
    And I get and print text from element with "xpath" "//h3[@data-test='error']"

    Examples:
      | password     |
      | secret_sauce |

  @SampleTC_04
  Scenario Outline: Verify the URL once user logged in.
    Given I navigate to the URL "https://www.saucedemo.com/v1/"
    When I enter text "<username>" on element with id "user-name"
    Then I enter text "<password>" on element with id "password"
    And I click on element with id "login-button"
    Then the URL should be "https://www.saucedemo.com/v1/inventory.html"

    Examples:
      | username      | password     |
      | standard_user | secret_sauce |

  @SampleTC_05
  Scenario Outline: Verify the scroll down and scroll up the page.
    Given I navigate to the URL "https://www.saucedemo.com/v1/"
    When I enter text "<username>" on element with id "user-name"
    Then I enter text "<password>" on element with id "password"
    And I click on element with id "login-button"
    Then the URL should be "https://www.saucedemo.com/v1/inventory.html"
    When I scroll the page by 200 pixels
    And I scroll up the page by 200 pixels

    Examples:
      | username      | password     |
      | standard_user | secret_sauce |

  @SampleTC_06
  Scenario Outline: Scroll down to the specific element
    Given I navigate to the URL "https://www.saucedemo.com/v1/"
    When I enter text "<username>" on element with id "user-name"
    Then I enter text "<password>" on element with id "password"
    And I click on element with id "login-button"
    Then the URL should be "https://www.saucedemo.com/v1/inventory.html"
    When I scroll to the element with "classname" "footer_copy"

    Examples:
      | username      | password     |
      | standard_user | secret_sauce |

  @SampleTC_07
  Scenario Outline: Scroll down to the specific element and get its text
    Given I navigate to the URL "https://www.saucedemo.com/v1/"
    When I enter text "<username>" on element with id "user-name"
    Then I enter text "<password>" on element with id "password"
    And I click on element with id "login-button"
    Then the URL should be "https://www.saucedemo.com/v1/inventory.html"
    When I scroll to the element with "classname" "footer_copy" and get its text

    Examples:
      | username      | password     |
      | standard_user | secret_sauce |

  @SampleTC_08
  Scenario Outline: Select the dropdown menu and Validate the Option(s)
    Given I navigate to the URL "https://www.saucedemo.com/v1/"
    When I enter text "<username>" on element with id "user-name"
    Then I enter text "<password>" on element with id "password"
    And I click on element with id "login-button"
    When I select the option with value "za" from the dropdown with "classname" "product_sort_container"


    Examples:
      | username      | password     |
      | standard_user | secret_sauce |

  @SampleTC_09
  Scenario Outline: Validate new tab open
    Given I navigate to the URL "https://www.saucedemo.com/v1/"
    When I enter text "<username>" on element with id "user-name"
    Then I enter text "<password>" on element with id "password"
    And I click on element with id "login-button"
    When I open a new tab with URL "https://www.google.com"
    Then I open a new tab with URL "https://www.facebook.com"

    Examples:
      | username      | password     |
      | standard_user | secret_sauce |

  @SampleTC_10
  Scenario Outline: Validate Refresh the page
    Given I navigate to the URL "https://www.saucedemo.com/v1/"
    When I enter text "<username>" on element with id "user-name"
    Then I enter text "<password>" on element with id "password"
    And I click on element with id "login-button"
    When I refresh the page

    Examples:
      | username      | password     |
      | standard_user | secret_sauce |

  @SampleTC_11
  Scenario Outline: Validate Navigate back to the page
    Given I navigate to the URL "https://www.saucedemo.com/v1/"
    When I enter text "<username>" on element with id "user-name"
    Then I enter text "<password>" on element with id "password"
    And I click on element with id "login-button"
    When I navigate back to the previous page

    Examples:
      | username      | password     |
      | standard_user | secret_sauce |

  @SampleTC_12
  Scenario Outline: Validate Navigate forward to the page
    Given I navigate to the URL "https://www.saucedemo.com/v1/"
    When I enter text "<username>" on element with id "user-name"
    Then I enter text "<password>" on element with id "password"
    And I click on element with id "login-button"
    When I navigate back to the previous page
    Then I navigate forward to the next page

    Examples:
      | username      | password     |
      | standard_user | secret_sauce |

  @SampleTC_13
  Scenario Outline: Validate WAIT
    Given I navigate to the URL "https://www.saucedemo.com/v1/"
    When I enter text "<username>" on element with id "user-name"
    Then I enter text "<password>" on element with id "password"
    And I wait for element with "xpath //input[@id='login-buttonn']" locator to be clickable

    Examples:
      | username      | password     |
      | standard_user | secret_sauce |

  @SampleTC_14
  Scenario Outline: Validate ALL KEYS
    Given I navigate to the URL "https://www.saucedemo.com/v1/"
    When I enter text "<username>" on element with id "user-name"
    Then I press the "ENTER" key
    When I press the "BACKSPACE" key
    Then I press the "TAB" key
    When I press the "SPACE" key
    Then I press the "pagedown" key
    When I press the "pageup" key

    Examples:
      | username      |
      | standard_user |

  @SampleTC_15
  Scenario Outline: Verify the title of the Page
    Given I navigate to the URL "https://www.saucedemo.com/v1/"
    When I enter text "<username>" on element with id "user-name"
    Then I enter text "<password>" on element with id "password"
    And I click on element with id "login-button"
    Then the page title should be "Swag Labs"

    Examples:
      | username      | password     |
      | standard_user | secret_sauce |

  @SampleTC_16
  Scenario: Verify Drag and Drop
    Given I navigate to the URL "https://www.globalsqa.com/demo-site/draganddrop/"
    When I click on element with xpath "//li[@id='Photo Manager']"
#      When I wait for element with "xpath //img[@alt='The peaks of High Tatras']" locator to be clickable
    Then I drag element with locator type "xpath" and locator value "(//li[@class='ui-widget-content ui-corner-tr ui-draggable ui-draggable-handle'])[1]" to element with locator type "xpath" and locator value "//div[@id='trash']"

  @SampleTC_17
  Scenario: Verify Checkbox selection
    Given I navigate to the URL "https://www.globalsqa.com/samplepagetest/"
    When I scroll the page by 100 pixels
    When I select the checkbox with "xpath" "//label[normalize-space()='Functional Testing']"
    Then I select the checkbox with "xpath" "//label[normalize-space()='Automation Testing']"
    And I select the checkbox with "xpath" "//label[normalize-space()='Manual Testing']"

  @SampleTC_18
  Scenario: Verify Radiobox selection
    Given I navigate to the URL "https://www.globalsqa.com/samplepagetest/"
    When I scroll the page by 100 pixels
    Then I select the radio button with "xpath" and locator value "//div[@class='grunion-field-wrap grunion-field-radio-wrap']//label[3]"

  @SampleTC_19
  Scenario: Verify Visibility of an element
    Given I navigate to the URL "https://www.saucedemo.com/"
    Then the element with "xpath" and locator value "//input[@id='user-name']" should be visible

  @SampleTC_20
  Scenario Outline: Verify clear text
    Given I navigate to the URL "https://www.saucedemo.com/v1/"
    When I enter text "<username>" on element with id "user-name"
    Then I enter text "<password>" on element with id "password"
    And I clear text from element with "id" "user-name"
    Then I clear text from element with "id" "password"

    Examples:
      | username      | password     |
      | standard_user | secret_sauce |

  @SampleTC_21
  Scenario: Verify iframes handling - Verify 2 iframe on the Page with the inner elements
    Given I navigate to the URL "https://demoqa.com/frames"
    When I switch to frame with "id" "frame1"
    Then I get and print text from element with "xpath" "//h1[@id='sampleHeading']"
    And I switch back to default content
    When I switch to frame with "id" "frame2"
    Then I get and print text from element with "xpath" "//h1[@id='sampleHeading']"
    And I switch back to default content

  @SampleTC_22
  Scenario: Verify Alerts handling - Accept Alert
    Given I navigate to the URL "https://demoqa.com/alerts"
    When I click on element with id "confirmButton"
    Then I accept the alert
    And I get and print text from element with "id" "confirmResult"

  @SampleTC_23
  Scenario: Verify Alerts handling - Dismiss Alert
    Given I navigate to the URL "https://demoqa.com/alerts"
    When I click on element with id "confirmButton"
    Then I dismiss the alert
    And I get and print text from element with "id" "confirmResult"

  @SampleTC_24
  Scenario: Verify get Page Source Assertion
    Given I navigate to the URL "https://demoqa.com/alerts"
    When I should see the page source containing "Click mButton to see alert"
    Then I click on element with id "confirmButton"

  @SampleTC_25
  Scenario Outline: Verify the Assert Element Text
    Given I navigate to the URL "https://www.toolsqa.com/"
    Then I should see the text <Assert_Text> in the element with "xpath" "//div[@class='new-training__heading']"

    Examples:
      | Assert_Text                 |
      | "Selenium Online Trainings" |

  @SampleTC_26
  Scenario: Verify the Assert Element Attribute with its value
    Given I navigate to the URL "https://www.toolsqa.com/"
    Then the element with "xpath" "//div[@class='new-training__heading']" should have the attribute "class" with value "new-training__heading"


