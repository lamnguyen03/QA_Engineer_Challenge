Feature: SignUp

  @tc001
  Scenario Outline: Verify that the user can create an account successfully
    Given user is on the home page
    And user navigate to the sign up page
    When user enters <userName>,<email>,<password>
    And the user clicks on the Sign in button
    Then User should access the home page successfully
    Examples:
      | userName |  | email    |  | password |
      | <random> |  | <random> |  | <random> |