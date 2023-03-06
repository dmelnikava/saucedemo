Feature: As an admin
  In order to fill the database
  I want to insert items into database.

  Scenario: check
    Given I connect to database
    When I insert the items
    Then table items should be filled by inserted items