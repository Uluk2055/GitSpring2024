package demoqa_tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class RadioButtonTest extends BaseTest{

    String url = "https://demoqa.com/radio-button";

    @Test
    void clickOnYesBtn() {
        helpers.getBrowserManager().openURL(url);
        webElementActions.click(demoqaPages.getRadioButtonPage().yesRadioBtn);
        Assert.assertEquals(demoqaPages.getRadioButtonPage().yesResult.getText(), "Yes");
    }

    @Test
    void clickOnImpressiveBtn() {
        helpers.getBrowserManager().openURL(url);
        webElementActions.click(demoqaPages.getRadioButtonPage().impressiveRadioBtn);
        Assert.assertEquals(demoqaPages.getRadioButtonPage().impressiveResult.getText(), "Impressive");
    }

}
