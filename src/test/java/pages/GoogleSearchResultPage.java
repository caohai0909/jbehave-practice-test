package pages;
import core.Page;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GoogleSearchResultPage extends Page {

    @FindBy(xpath = "//div[@id='search']")
    WebElement results;

    public boolean doesSearchResultDisplayed(String searchResult){
        String searchResultsText = results.getText();
        if (searchResultsText.contains(searchResult)) {
            return true;
        } else {
            return false;
        }
    }
}
