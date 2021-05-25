@GoogleSearch

Feature: Google Search Scenarios

  @GoogleSearchTC1
  Scenario: Search "ducks" in Google
    When I open "https://google.com/"
    Then  I input search word: "ducks"
    And  I verify that search result include Wikipedia link by "Duck"

  @GoogleSearchTC2
  Scenario: Search "ducks" in Google with click "Enter" on the keyboard
    When I open "https://google.com/"
    Then  I input search word "ducks" and click Enter on the keyboard
    And  I verify that search result include Wikipedia link by "Duck" (second way)

  @GoogleSearchTC3
  Scenario: Search "ducks" in Google
    When I open "https://google.com/"
    Then  I input search word: "ducks"
    And  I verify that there is a search word on the page with the search result

  @GoogleSearchTC4
  Scenario: Search "ducks" in Google
    When I open "https://google.com/"
    Then  I input search word: "ducks"
    And  I verify that the title of the page contains the search word