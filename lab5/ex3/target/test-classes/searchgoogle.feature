Feature: Search in Google

  Scenario: Register flight in BlazeDemo
    When I navigate through "https://google.com"
    And type in the searchbar "BlazeDemo"
    And press Enter
    And I should enter the BlazeDemo website and register my flight