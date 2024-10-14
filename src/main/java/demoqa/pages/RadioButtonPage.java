package demoqa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RadioButtonPage extends BasePage{

    @FindBy(xpath = "//label[@for='yesRadio']")
    public WebElement yesRadioBtn;

    @FindBy(xpath = "//label[@for='impressiveRadio']")
    public WebElement impressiveRadioBtn;

    @FindBy(xpath = "//span[@class='text-success' and text()='Yes']")
    public WebElement yesResult;

    @FindBy(xpath = "//span[@class='text-success' and text()='Impressive']")
    public WebElement impressiveResult;

//    public RadioButtonPage clickOnYes(WebElement element) {
//        yesRadioBtn.click();
//
//    }
}
