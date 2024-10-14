package demoqa_tests;

import org.testng.annotations.Test;

public class CheckBoxTest extends BaseTest {

    @Test
    void checkBoxTest() throws InterruptedException {
        driver.get("https://demoqa.com/checkbox");
        demoqaPages.getCheckBoxPage().clickOnExpandAll()
                .clickOnNotes()
                .clickOnNotes()
                .clickOnDocuments()
                .clickOnCollapseAll();
    }
}
