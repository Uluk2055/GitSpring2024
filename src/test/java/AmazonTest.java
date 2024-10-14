import demoqa_tests.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class AmazonTest extends BaseTest {

    @Test
    public void amazonTest() throws InterruptedException {
        helpers.getBrowserManager().openURL("https://www.amazon.com/");
        Thread.sleep(10000);
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Iphone", Keys.ENTER);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

//        List<WebElement> brands = driver.findElements(By.xpath("//div[@id=\"brandsRefinements\"]/ul/span/span/li/span/a"));
//        for (int i = 0; i < brands.size(); i++) {
//            brands = driver.findElements(By.xpath("//div[@id=\"brandsRefinements\"]/ul/span/span/li/span/a"));
//            WebElement brand = brands.get(i);
//            wait.until(ExpectedConditions.elementToBeClickable(brand)).click();
//            Thread.sleep(5000);
//        }
        webElementActions.staleElementClick("//div[@id=\"brandsRefinements\"]/ul/span/span/li/span/a");
    }
}

