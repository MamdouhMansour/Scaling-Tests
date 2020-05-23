package objectModels.gui.google;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.shaft.gui.element.ElementActions;

public class SearchResultsPage {
    private WebDriver browser;

    /*
     * This generic xpath for further use of all 9 results listed
     * also the following xpath can be used for the first 6 results:
     * "//div[@id='rso']//h2[@class='bNg8Rb']/following-sibling::div//div[@class='r']//a"
     */
    private String genericSearchResultXPath = "//div[@id='rso']/div[@class='g']//div//a/h3";

    public SearchResultsPage(WebDriver browser) {
	this.browser = browser;
    }

    /**
     * Method to take the desired result number as integer that represent the result
     * number in the list.
     * 
     * @return the text of that result
     */
    public String getSearchResultText(int resultNumber) {
	return ElementActions.getText(browser, By.xpath("(" + genericSearchResultXPath + ")[" + resultNumber + "]"));
    }
}
