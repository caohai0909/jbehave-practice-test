package pages;
import core.Page;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class GoogleSearchPage extends Page {

    @FindBy(name = "btnK")
    WebElement searchBtn;

    @FindBy (name = "q")
    WebElement searchFld;

    public void navigateToGooglePage(String url) {
        navigateTo(url);
        maximizeWindow();
    }

    public void searchByKeyword(String keyword) {
        click(searchFld);
        enter(searchFld, keyword);
    }

    public void clickToSearchButton(){
        click(searchBtn);
    }
}
