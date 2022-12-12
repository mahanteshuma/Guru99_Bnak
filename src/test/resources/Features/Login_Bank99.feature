Feature: Check Guru99 Bank Login Functionality

  Scenario Outline: Verify Login functionality with valid Credentials
    Given user opened Browser using <url>
    When User enters valid UserID as <userID> and Password as <pwd>
    And User Clicks Login Button
    Then User navigated to Guru99 Bank Home Page
    And User Logout the Application
    And User closed Browser

    Examples:
      | url                                    | userID       | pwd       |
      | "https://demo.guru99.com/v4/index.php" | mngr461887 | UmEgUru |
