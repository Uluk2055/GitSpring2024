package basic_locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;

public class ByClassDemo {
    @Test
    void byClassTest() throws InterruptedException{
        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://demoqa.com/webtables");

        WebElement addNewRecordBtn = driver.findElement(By.className("btn-primary"));
        addNewRecordBtn.click();

        Thread.sleep(3000);

        driver.close();
        driver.quit();
    }
}
