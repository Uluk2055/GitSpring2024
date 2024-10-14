package demoqa.pages;

import demoqa.entities.TextBox;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class TextBoxPage extends BasePage{


    @FindBy(id = "userName")
    public WebElement userName;

    @FindBy(id = "userEmail")
    public WebElement userEmail;

    @FindBy(id = "currentAddress")
    public WebElement currentAddress;

    @FindBy(id = "permanentAddress")
    public WebElement permanentAddress;

    @FindBy(id = "submit")
    public WebElement submitBtn;

    @Step("Input Full Name {0}")
    public TextBoxPage inputUserName(String userName) {
        webElementActions.input(this.userName, userName);
        return this;
    }

    @Step("Input User Email {0}")
    public TextBoxPage inputUserEmail(String userEmail) {
        webElementActions.input(this.userEmail, userEmail);
        return this;
    }

    @Step("Input Current Address {0}")
    public TextBoxPage inputCurrentAddress(String currentAddress) {
        webElementActions.input(this.currentAddress, currentAddress);
        return this;
    }

    @Step("Input Permanent Address {0}")
    public TextBoxPage inputPermanentAddress(String permanentAddress) {
        webElementActions.input(this.permanentAddress, permanentAddress);
        return this;
    }

    @Step("Click Submit Button")
    public TextBoxPage clickSubmitBtn() {
        webElementActions.scrollToElement(this.submitBtn).click(this.submitBtn);
        return this;
    }

    @Step("Fill the Text Box {0}")
    public TextBoxPage fillTextBoxForm(TextBox textBox) {
        inputUserName(textBox.getFullName())
                .inputUserEmail(textBox.getEmail())
                .inputCurrentAddress(textBox.getCurrentAddress())
                .inputPermanentAddress(textBox.getPermanentAddress())
                .clickSubmitBtn();
        return this;
    }














}
