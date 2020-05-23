package objectModels.gui.herokuapp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.shaft.gui.element.ElementActions;

public class DynamicLoading {

    private WebDriver browser;
    private By example2 = By.xpath("//a[@href = '/dynamic_loading/2']");

    public DynamicLoading(WebDriver browser) {
	this.browser = browser;
    }

    /**
     * Pass the browser to the new page opened "Dynamic Loading Example2".
     * 
     * @return this new page "Dynamic Loading Example2".
     */
    public DynamicLoadingExample2 clickOnExample2() {
	ElementActions.click(browser, example2);
	return new DynamicLoadingExample2(browser);
    }
}
