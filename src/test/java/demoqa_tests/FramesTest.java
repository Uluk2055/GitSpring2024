package demoqa_tests;

import org.testng.annotations.Test;

public class FramesTest extends BaseTest{

    @Test
    void testFrames(){
        helpers.getBrowserManager().openURL("https://demoqa.com/frames");
        helpers.getiFrameHelper().switchToIFrame(demoqaPages.framesPage.frame1);
        System.out.println(demoqaPages.getFramesPage().sampleHeading.getText());
        System.out.println("------------------------");
        System.out.println(webElementActions.getTextFromElement(demoqaPages.getFramesPage().sampleHeading));
        helpers.getiFrameHelper().switchToDefaultIFrame();
        System.out.println(webElementActions.getTextFromElement(demoqaPages.getFramesPage().textCenter));

        helpers.getiFrameHelper().switchToFrameByIndex(1);
        System.out.println(webElementActions.getTextFromElement(demoqaPages.getFramesPage().sampleHeading));
    }
}
