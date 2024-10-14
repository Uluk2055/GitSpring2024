package demoqa_tests;

import demoqa.drivers.DriverManager;
import demoqa.helper.WebElementActions;
import demoqa.module_import.DemoqaPages;
import demoqa.module_import.ImportHelpers;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.devtools.DevTools;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public abstract class BaseTest {

    public WebDriver driver;
    public WebElementActions webElementActions;
    public DemoqaPages demoqaPages;
    public ImportHelpers helpers;

    @BeforeClass(alwaysRun = true)
    public void setUp(){
        driver = DriverManager.getDriver();
        webElementActions = new WebElementActions();
        demoqaPages = new DemoqaPages();
        helpers = new ImportHelpers(driver);


    }

    @AfterClass(alwaysRun = true)
    public void tearDown(){
        DriverManager.closeDriver();

    }
}
