Feature: Check Guru99 Bank Login Functionality

  Scenario Outline: Verify Login functionality with valid Credentials
    Given user opened Browser using <url>
    When User enters valid UserID as <userID> and Password as <pwd>
    And User Clicks Login Button
    Then User navigated to Guru99 Bank Home Page
    And User closed Browser
    Examples:
      | url                                    | userID       | pwd       |
      | "https://demo.guru99.com/v3/index.php" | "mngr461859" | "mUnemEm" |
