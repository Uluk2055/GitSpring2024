package demoqa.helper;

import demoqa.drivers.ChromeWebDriver;
import demoqa.drivers.DriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static demoqa.drivers.ChromeWebDriver.driver;

public class WebElementActions {

    Actions actions = new Actions(DriverManager.getDriver());

    public WebElementActions click(WebElement element) {
        scrollToElement(element);
        waitElementToBeVisible(element);
        waitElementToBeClickable(element);
        highlight(element);
        element.click();
        return this;
    }

    public WebElementActions jsClick(WebElement element) {
        ((JavascriptExecutor) DriverManager.getDriver()).executeScript("arguments[0].click();", element);
        return this;
    }

    public WebElementActions clickJS(WebElement element) {
        JavascriptExecutor executor = (JavascriptExecutor) DriverManager.getDriver();
        executor.executeScript("arguments[0].click();", element);
        return this;
    }

    public WebElementActions highlight(WebElement element) {
        JavascriptExecutor executor = (JavascriptExecutor) DriverManager.getDriver();
        executor.executeScript("arguments[0].style.border='3px solid violet'", element);
        return this;
    }

    public WebElementActions input(WebElement element, String txt) {
//        navigateToElement(element);
        scrollToElement(element);
        waitElementToBeVisible(element);
        highlight(element);
        element.sendKeys(txt);
        return this;
    }

    public WebElementActions navigateToElement(WebElement element) {
        actions.moveToElement(element).build().perform();
        return this;
    }

    public WebElementActions scrollToElement(WebElement element) {
        ((JavascriptExecutor) DriverManager.getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
        return this;
    }

    public WebElementActions inputAndEnter(WebElement element, String txt) {
        element.sendKeys(txt, Keys.ENTER);
        return this;
    }

    public WebElementActions waitElementToBeVisible(WebElement element) {
        new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOf(element));
        return this;
    }

    public WebElementActions waitElementToBeClickable(WebElement element) {
        new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(element));
        return this;
    }

    public String getTextFromElement(WebElement element) {
        waitElementToBeVisible(element);
        return element.getText();
    }

    public WebElementActions doubleClick(WebElement element) {
        waitElementToBeClickable(element);
        actions.doubleClick(element).build().perform();
        return this;
    }

    public WebElementActions rightClick(WebElement element) {
        waitElementToBeClickable(element);
        actions.contextClick(element).build().perform();
        return this;
    }

    public WebElementActions waitElementToBeClickable2(WebElement element) {
        FluentWait<WebDriver> wait = new FluentWait<>(DriverManager.getDriver())
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofSeconds(5))
                .ignoring(NoSuchElementException.class);
        WebElement element1 = wait.until(driver -> driver.findElement(By.id("elementId")));
        return this;
    }

    public void waitStatusCode() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until((ExpectedCondition<Boolean>) driver -> ChromeWebDriver.getResponseStatusCode() != 0);
    }

    public void staleElementClick(String xpath) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        List<WebElement> brands = driver.findElements(By.xpath(xpath));
        for (int i = 0; i < brands.size(); i++) {
            brands = driver.findElements(By.xpath(xpath));
            WebElement brand = brands.get(i);
            wait.until(ExpectedConditions.elementToBeClickable(brand)).click();
            Thread.sleep(5000);
        }

    }
}
