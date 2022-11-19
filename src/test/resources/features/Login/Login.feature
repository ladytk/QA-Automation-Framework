Feature:

  Scenario: Login Success
    Given I open Browser
    And I open Login Page
    When I enter email "tasiakwiggins@gmail.com"
    And I enter password "te$t$udent"
    And I submit
    Then I am logged in