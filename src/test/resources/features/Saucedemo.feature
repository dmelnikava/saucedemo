Feature: As a customer I want to order selected items from the shopping cart

  Background: Login page should be opened
    Given I am on the site Login page

  Scenario: Success message should become when I try to order selected items from the shopping cart
    When I login as a standard_user
    And I add needed items to the shopping cart on the Home page
    And I checkout added items on the Cart page
    And I enter my personal information on the Checkout page
    And I finish ordering items on the Overview page
    Then the Complete page should be displayed
    And the "Thank you for your order!" message should be displayed