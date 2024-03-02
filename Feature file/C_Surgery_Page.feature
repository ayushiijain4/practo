Feature: Surgery page

  Scenario: get popular surgery list
    Given user is on surgery page
    When page is scrolled to see lists
    Then popular surgery list is captured
