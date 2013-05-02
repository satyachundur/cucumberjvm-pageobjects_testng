Feature: Amazon Price check

  Scenario: Search for Ipad and check price 
    Given I am on Amazon Homepage
    When I search for "ipad"
    Then the search results should display first price as "295.00"