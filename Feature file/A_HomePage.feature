Feature: Home Page of website

  Scenario: Navigate to website
    Given user is on homepage
    And user clicks on find doctor button
    When user enters location
    And user selects area
    Then user enters speciality
    And user selects doctor