package demoqa_tests;

import demoqa.drivers.DriverManager;
import demoqa.pages.PracticeFormPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class PracticeFormTest {

    WebDriver driver;
    PracticeFormPage practiceFormPage;

    @BeforeTest
    public void setUp(){
        driver = DriverManager.getDriver();
        practiceFormPage = new PracticeFormPage();
    }

    @Test
     void practiceFormTest() throws InterruptedException {

        driver.get("https://demoqa.com/automation-practice-form");
        practiceFormPage.inputFirstName("Salma")
                .inputLastName("Hayek")
                .inputEmail("salma@gmail.com")
                .clickOnGender("other")
                .inputMobileNumber("0556505050")
                .clickDOB()
                .selectDOBDay()
//                .inputSubjects("Maths")
//                .clickOnHobbies(2)
//                .inputCurrentAddress("Ave 123")
//                .selectStateAndCity(1,2)
                .clickOnSubmit();
    }

//    @AfterTest
//    public void tearDown() {
//        driver.close();
//        driver.quit();
//    }
}
