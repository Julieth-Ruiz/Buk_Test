Feature: Navigate to the DemoBlaze main page

  Scenario: Validate URL of Home page
    Given I navigate to the DemoBlaze main page
    Then I should be in the "home" page
    And The url page should be equal to the next "https://www.demoblaze.com/index.html" url


  Scenario: Validate successful submission - contact
    Given I navigate to the Demoblaze main page
    Then I should be in the "home" page
    When I click on the "contact" "link"
    Then I enter a contact email
    And I enter a contact name
    And I enter a message
    And I click on the send message
    Then I should be presented with a successful contact submission message

