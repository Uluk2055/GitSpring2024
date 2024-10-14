package demoqa_tests;

import org.testng.annotations.Test;

import java.util.List;

import static demoqa.OldStyleSelectMenuValues.BLACK;
import static demoqa.OldStyleSelectMenuValues.GREEN;

public class SelectMenuTest extends BaseTest{

    @Test
    void selectMenuTest() throws InterruptedException {
        helpers.getBrowserManager().openURL("https://demoqa.com/select-menu");
        webElementActions.scrollToElement(demoqaPages.getSelectMenuPage().oldStyleSelectMenu);
        helpers.getDropdownHelper().selectByText(demoqaPages.getSelectMenuPage().oldStyleSelectMenu, GREEN.getColor());
        helpers.getDropdownHelper().selectByIndex(demoqaPages.getSelectMenuPage().oldStyleSelectMenu, 9);
        helpers.getDropdownHelper().selectByValue(demoqaPages.getSelectMenuPage().oldStyleSelectMenu, "red");
        List<String> colors = helpers.getDropdownHelper().getAllDropdownValues(demoqaPages.getSelectMenuPage().oldStyleSelectMenu);
        for (String color : colors){
            System.out.println(color);
        }
    }
}
