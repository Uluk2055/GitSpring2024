package demoqa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LinksPage extends BasePage{

    @FindBy(xpath = "//a[@id='simpleLink']")
    public WebElement simpleHomeLink;

    @FindBy(id="dynamicLink")
    public WebElement dynamicHomeLink;

    @FindBy(id="created")
    public WebElement created;

    @FindBy(id="no-content")
    public WebElement noContent;

    @FindBy(id="moved")
    public WebElement moved;

    @FindBy(id="bad-request")
    public WebElement badRequest;

    @FindBy(id="unauthorized")
    public WebElement unauthorized;

    @FindBy(id="forbidden")
    public WebElement forbidden;

    @FindBy(id="invalid-url")
    public WebElement notFound;

    @FindBy(id="linkResponse")
    public WebElement linkResponse;
}
