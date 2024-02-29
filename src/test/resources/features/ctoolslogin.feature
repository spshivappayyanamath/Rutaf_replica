Feature: Verify login page features
  Background:
    Given navigate to ct login url

    Scenario: verify login working for valid ct credentials
      When user enters username and password
      And clicks on signin button
      Then home page should show
      When click on username
      And click on logout
      Then login page should display

  Scenario: verify login working for invalid ct credentials
    When user enters wrong "username" and "password"
    And clicks on signin button
    Then home page should show
