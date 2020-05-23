package objectModels.gui.herokuapp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.shaft.gui.element.ElementActions;

public class FileUpload {

    private WebDriver browser;

    private By chooseFile = By.id("file-upload");
    private By uploadButton = By.id("file-submit");
    private By fileUploaded = By.id("uploaded-files");

    public FileUpload(WebDriver browser) {
	this.browser = browser;
    }

    public void chooseFileToUpload(String path) {
	ElementActions.typeFileLocationForUpload(browser, chooseFile, path);
    }

    public void clickOnUploadButton() {
	ElementActions.click(browser, uploadButton);
    }

    public String getUploadedFileText() {
	return ElementActions.getText(browser, fileUploaded);
    }
}