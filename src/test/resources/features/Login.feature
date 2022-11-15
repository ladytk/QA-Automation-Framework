Feature: Login feature

  Scenario: Login Success
    Given I open Login Page
    Then I enter email "dcabdi@gmail.com"
    And I enter password "te$t$tdent"
    And I submit
    Then I am logged in