package objectModels.gui.herokuapp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.shaft.gui.element.ElementActions;

public class HerokuappHomePage {

    private WebDriver browser;

    public HerokuappHomePage(WebDriver browser) {
	this.browser = browser;
    }

    public FileUpload clickOnFileUpload() {
	clickLink("File Upload");
	return new FileUpload(browser);
    }

    public DynamicLoading clickOnDynamicLoading() {
	clickLink("Dynamic Loading");
	return new DynamicLoading(browser);
    }

    /**
     * Generic Method to click on any link in the Herokuapp home page.
     * 
     * @param linkText the link text of the required link to open
     */
    public void clickLink(String linkText) {
	ElementActions.click(browser, By.linkText(linkText));
    }

}
