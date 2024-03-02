Feature: Corporate Wellness Page

  Scenario: verify Schedule a demo button navigation
    Given user is on Corporate Wellness Page
    When user enters invalid detail
    And user selects organizationsize and interest
    And clicks on submit button
    Then user enters valid detail
    And clicks on submit button again
