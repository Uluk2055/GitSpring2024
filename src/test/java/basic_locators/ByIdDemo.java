package basic_locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class ByIdDemo {

    @Test
    void byIdTest() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://demoqa.com/text-box");

        WebElement fullNameInput = driver.findElement(By.id("userName"));
        fullNameInput.sendKeys("Bob Silent");
        Thread.sleep(500);

        WebElement emailInput = driver.findElement(By.id("userEmail"));
        emailInput.sendKeys("bob_silent@gmail.com");
        Thread.sleep(500);

        WebElement currentAddressInput = driver.findElement(By.xpath("//textarea[@placeholder]"));
        currentAddressInput.sendKeys("Avenue 123");
        Thread.sleep(500);

        WebElement permanentAddressInput = driver.findElement(By.xpath("//textarea[@id='permanentAddress']"));
        permanentAddressInput.sendKeys("Chicago 321");
        Thread.sleep(500);

        WebElement submitButton = driver.findElement(By.id("submit"));
        Actions actions = new Actions(driver);
        actions.moveToElement(submitButton).perform();
        submitButton.click();
        Thread.sleep(1000);

        WebElement name = driver.findElement(By.id("name"));
        String actualName = name.getText().substring(5);
        WebElement email = driver.findElement(By.id("email"));
        String actualEmail = email.getText().substring(6);
        WebElement currentAddress = driver.findElement(By.xpath("//p[@id='currentAddress']"));
        String actualCurrentAddress = currentAddress.getText().substring(17);
        WebElement permanentAddress = driver.findElement(By.xpath("//p[@id='permanentAddress']"));
        String actualPermanentAddress = permanentAddress.getText().substring(20);

        String expectedFullName = "Bob Silent";
        String expectedEmail = "bob_silent@gmail.com";
        String expectedCurrentAddress = "Avenue 123";
        String expectedPermanentAddress = "Chicago 321";

        Assert.assertEquals(actualName, expectedFullName);
        Assert.assertEquals(actualEmail, expectedEmail);
        Assert.assertEquals(actualCurrentAddress, expectedCurrentAddress);
        Assert.assertEquals(actualPermanentAddress, expectedPermanentAddress);

        driver.close();
        driver.quit();
    }

    @Test
    void homeWorkCalendar() throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://demoqa.com");

        WebElement widgets = driver.findElement(By.xpath("//h5[text()='Widgets']"));
        widgets.click();
        Thread.sleep(2000);

        WebElement datePicker = driver.findElement(By.xpath("//span[@class=\"text\" and text()=\"Date Picker\"]"));
        datePicker.click();
        Thread.sleep(2000);

        WebElement dateAndTime = driver.findElement(By.xpath("//input[@type=\"text\" and @id=\"datePickerMonthYearInput\"]"));
        dateAndTime.click();
        Thread.sleep(2000);

//        List<WebElement> weeks = driver.findElements(By.xpath("//div[@class=\"react-datepicker__week\"]"));
        List<WebElement> weeks = driver.findElements(By.xpath("//div[contains(@class,\"react-datepicker__day react-datepicker__day\") and not (contains(@class,\"react-datepicker__day--outside-month\"))]"));

        for (WebElement week : weeks){

            System.out.println(week.getText());
        }
        Thread.sleep(5000);
        ////div[@class="react-datepicker__month-container"]
    }
}