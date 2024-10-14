package demoqa_tests;

import org.testng.annotations.Test;

public class AlertTest extends BaseTest{

    @Test
    void alertTest() throws InterruptedException {
        helpers.getBrowserManager().openURL("https://demoqa.com/alerts");
        webElementActions.click(demoqaPages.getAlertPage().alertBtn);
        helpers.getAlertHelper().acceptAlert();
    }
}
