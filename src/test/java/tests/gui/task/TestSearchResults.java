/*
 * Test google search results 
 */

package tests.gui.task;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.shaft.gui.browser.BrowserActions;
import com.shaft.gui.browser.BrowserFactory;
import com.shaft.validation.Assertions;
import com.shaft.validation.Assertions.AssertionComparisonType;
import com.shaft.validation.Assertions.AssertionType;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import objectModels.gui.google.GoogleHome;
import objectModels.gui.google.SearchResultsPage;
import test.data.GetTestData;

public class TestSearchResults extends GetTestData {

    private WebDriver browser;
    private GoogleHome homePage;
    private SearchResultsPage resultsPage;

    private String testDataFileName = "GoogleTestData.properties";

    /**
     * @param Query            search keyword
     * @param testDataFileName test data file name need to access
     */
    @Test(description = "TC001 - Check third search result text")
    @Description("Check that third search result have the correct text")
    @Severity(SeverityLevel.NORMAL)
    @Story("Given I am on Google home page When type search keywords and press search "
	    + "Then I can see suggested search list with the right length according to business that fetched from database correctly"
	    + "and page loads and redirect to search results page with the matching results that matched from the database")
    public void seaerchForQueryAndAssertThirdResultText() {
	homePage.searchForQuery(getTestData(testDataFileName, "Query"));

	Assertions.assertEquals(getTestData(testDataFileName, "Text_To_Assert"), resultsPage.getSearchResultText(3),
		AssertionComparisonType.CONTAINS, AssertionType.POSITIVE);
    }

    @BeforeMethod
    public void beforeMethod() {
	browser = BrowserFactory.getBrowser();
	homePage = new GoogleHome(browser);
	resultsPage = new SearchResultsPage(browser);

	BrowserActions.navigateToURL(browser, getTestData(testDataFileName, "URL"),
		getTestData(testDataFileName, "URL_After_Navigation"));
    }

    @AfterMethod
    public void afterMethod() {
	BrowserActions.closeCurrentWindow(browser);
    }
}
