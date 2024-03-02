Feature: doctor detail

  Scenario: get doctor detail
    Given user is on search doctor page
    When user selects patient story filter
    And user selects doctor experience  filter
    And user selects filter for fee and availablity
    And user clicks on sortBy dropDown
    And user selects the sortBy option
    Then top five doctors name is captured
    And top five doctors experience is captured
    And top five clinic name is captured
    And top five doctors practice locality is captured
    And top five doctors consultation fee is captured
