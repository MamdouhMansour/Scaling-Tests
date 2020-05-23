package objectModels.gui.google;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import com.shaft.gui.element.ElementActions;

public class GoogleHome {
    private WebDriver browser;

    private By searchbox_text = By.name("q");

    public GoogleHome(WebDriver browser) {
	this.browser = browser;
    }

    /**
     * Searching for keywords in google home page.
     * 
     * @param query this will be provided from the test
     * @return the search results page and provide the browser to the new page
     */
    public SearchResultsPage searchForQuery(String query) {
	new ElementActions(browser).type(searchbox_text, query).keyPress(searchbox_text, Keys.ENTER);
	return new SearchResultsPage(browser);
    }
}
