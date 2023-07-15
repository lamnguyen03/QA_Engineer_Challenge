Feature: Login

  @tc001
  Scenario Outline: Verify that a user cannot log in when entering a wrong email address or password
    Given open the home page
    And user navigate to the login page
    When user enters <email>,<password> to login
    And the user clicks on the login button
    Then user can not login and error message is displayed
    Examples:
      | email                                 |  | password  |
      | lam.thanh@positivethinking.tech       |  | 1234678a  |
      | lam.nguyenthanh@positivethinking.tech |  | 123456789 |