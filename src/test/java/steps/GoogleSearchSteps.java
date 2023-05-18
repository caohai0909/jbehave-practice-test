package steps;
import core.BaseSteps;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.junit.Assert;
import pages.GoogleSearchPage;
import pages.GoogleSearchResultPage;

public class GoogleSearchSteps extends BaseSteps {
    private GoogleSearchPage googleSearchPage;
    private GoogleSearchResultPage googleSearchResultPage;
    private String googleUrl = "https://www.google.com/";

    @Given("I am on the Google home page")
    public void goToGoogleHomePage() {
        googleSearchPage = new GoogleSearchPage();
        googleSearchPage.navigateToGooglePage(googleUrl);
    }

    @When("I enter $keyword in the search bar")
    public void enterSearchKeyword(String keyword) {
        googleSearchPage = new GoogleSearchPage();
        googleSearchPage.searchByKeyword(keyword);
    }

    @When("I click the search button")
    public void clickSearchButton() {
        googleSearchPage = new GoogleSearchPage();
        googleSearchPage.clickToSearchButton();
    }

    @Then("I should see results that include the text $expectedText")
    public void verifySearchResults(String expectedText) {
        googleSearchResultPage = new GoogleSearchResultPage();
        boolean doesSearchResultDisplayed = googleSearchResultPage.doesSearchResultDisplayed(expectedText);
        Assert.assertTrue("Failed to Search", doesSearchResultDisplayed);
    }
}
