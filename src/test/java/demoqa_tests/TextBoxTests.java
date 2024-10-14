package demoqa_tests;

import demoqa.data.MockDataGenerator;
import demoqa.entities.TextBox;
import org.testng.annotations.Test;

public class TextBoxTests extends BaseTest{

    @Test
    void testBoxTest() throws InterruptedException {
        driver.get("https://demoqa.com/text-box");
        demoqaPages.getTextBoxPage().inputUserName("John Doe")
                .inputUserEmail("john@gmail.com")
                .inputCurrentAddress("Ave 123")
                .inputPermanentAddress("Bishkek 312")
                .clickSubmitBtn();
    }

    @Test
    void textBoxTest2()throws InterruptedException{
        helpers.getBrowserManager().openURL("https://demoqa.com/text-box");
        TextBox expectedTextBox = MockDataGenerator.randomTextBox();
        demoqaPages.getTextBoxPage().fillTextBoxForm(expectedTextBox);
        Thread.sleep(5000);
    }
}
