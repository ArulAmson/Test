Feature: Browser Launch and Search

  Scenario: Launch Browser and Navigate to URL
    Given I launch the browser
    When I navigate to the URL
    Then the browser should be open and URL should be loaded

  Scenario: User searches for a product
    Given I am on the login page
    When I search for a user
    And I select the first result
    And I go to the next page
    Then I should see the search results

  Scenario: Print Product Information
    Given I am on the product filter page
    When I filter for Apple Watches
    Then I should see at least 10 Apple Watches
    And print the 10th Apple Watch