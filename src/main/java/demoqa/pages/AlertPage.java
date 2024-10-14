package demoqa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AlertPage extends BasePage {

    @FindBy(id = "alertButton")
    public WebElement alertBtn;

    @FindBy(id = "timerAlertButton")
    public WebElement timerAlertBtn;

    @FindBy(id = "confirmButton")
    private WebElement confirmBtn;

    @FindBy(id = "promtButton")
    public WebElement promptBtn;
}
