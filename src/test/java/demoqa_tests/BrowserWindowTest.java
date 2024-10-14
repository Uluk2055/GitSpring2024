package demoqa_tests;

import org.testng.annotations.Test;

public class BrowserWindowTest extends BaseTest{

    @Test
    void windowTest() throws InterruptedException {
        helpers.getBrowserManager().openURL("https://demoqa.com/browser-windows");
        for (int i = 0; i < 3; i++) {
            webElementActions.click(demoqaPages.getBrowserWindowsPage().newTab);
        }
        helpers.getWindowHelper().switchToWindow(1);
    }
}
