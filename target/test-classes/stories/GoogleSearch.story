Story: Google Search
As a user
I want to search for a keyword on Google
So that I can find relevant information

Scenario: Search for the keyword "JBehave"
Given I am on the Google home page
When I enter <keyword> in the search bar
And I click the search button
Then I should see results that include the text <expectedText>
Examples:
|keyword|expectedText    |
|JBehave|What is JBehave?|