package advanced_locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;

public class CssSelectorDemo {

    @Test
    void cssSelectorDemoTest() {

        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://demoqa.com");

        WebElement cssByClass = driver.findElement(By.cssSelector(".w3-example")); //    by class     .
        WebElement cssById = driver.findElement(By.cssSelector("#userName"));   //    by id        #
        WebElement css = driver.findElement(By.cssSelector("input[type='text']"));   //    without // and @
        /*
        table[id='customers'] th:nth-child(1)
        span[class^='color']    -->   substring  Starts with ---> ^
        span[class$='color']    -->   substring  Ends with ---> $
        span[class*='color']    -->   contains   ---> *
        div[id='userName-wrapper']+div+div+div  ---> переключение на следующий ---> +
        table[id='customers'] th:nth-of-type(3)
        table[id='customers'] th:nth-child(3)
        */
    }
}
