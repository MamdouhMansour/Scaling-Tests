package objectModels.gui.herokuapp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.shaft.gui.element.ElementActions;

public class DynamicLoadingExample2 {

    private WebDriver browser;
    private By startButton = By.cssSelector("#start button");
    private By successLoadingText = By.id("finish");

    public DynamicLoadingExample2(WebDriver browser) {
	this.browser = browser;
    }

    public void clickOnStartButton() {
	ElementActions.click(browser, startButton);
    }

    /**
     * Get success loading text Wait on this text to be present by 3
     * defaultElementIdentificationTimeout "5 seconds"
     * 
     * @return text shown after successful loading
     */
    public String getSuccessLoadingText() {
	ElementActions.waitForElementToBePresent(browser, successLoadingText, 3, true);
	return ElementActions.getText(browser, successLoadingText);
    }
}
