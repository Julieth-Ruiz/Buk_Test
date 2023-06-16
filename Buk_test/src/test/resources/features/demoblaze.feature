Feature: Navigate to the DemoBlaze main page

  Scenario: Add a product from the laptops category to the cart
    Given I navigate to the DemoBlaze main page
    When I click on the laptops category link
    Then I should see the correct products of laptops category
    And I click on the product
    And I click in Add to cart

  Scenario: Enter the shopping cart and make the purchase
    Given I navigate to the DemoBlaze cart page
    When I click on the place order button
    Then I complete all fills in the form
      | input             | value                    |
      | name_order_input  | Julieth Ruiz             |
      | country_input     | Colombia                 |
      | city_input        | Bogota                   |
      | credit_card_input | 5555511455               |
      | month_input       | 04                       |
      | year_input        | 2022                     |
    And I click on the purchase button

  Scenario: Validate successful submission - contact
    Given I navigate to the DemoBlaze main page
    When I click on the contact link
    Then I complete all fills in the form
      | input             | value                    |
      | email_input       | julieth@gmail.com        |
      | name_input        | Julieth Ruiz             |
      | message_input     | Me gustan los productos  |
    And I click on the send message
    And I should be presented with a successful contact submission message and accept






