package demoqa.pages;

import demoqa.drivers.DriverManager;
import demoqa.helper.WebElementActions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ButtonsPage extends BasePage{

    @FindBy(id="doubleClickBtn")
    public WebElement doubleClickButton;

    @FindBy(id="rightClickBtn")
    public WebElement rightClickButton;

    @FindBy(xpath = "//button[text()='Click Me']")
    public WebElement clickClickButton;

}
