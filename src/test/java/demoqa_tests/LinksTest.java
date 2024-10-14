package demoqa_tests;

import demoqa.drivers.ChromeWebDriver;
import demoqa.drivers.DriverManager;
import demoqa.pages.LinksPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.time.Duration;

import static org.testng.Assert.assertEquals;

public class LinksTest extends BaseTest {


    String url = "https://demoqa.com/links";

//    @BeforeMethod
    public LinksTest getUrl() {
        helpers.getBrowserManager().openURL(url);
        return this;
    }


    @Test
    void createdAPITest() {
        ChromeWebDriver.resetResponseStatusCode();
        ChromeWebDriver.filterResponsesByUrl("https://demoqa.com/created");
        getUrl();
        helpers.getBrowserManager().openURL("https://demoqa.com/links");
        webElementActions.click(demoqaPages.getLinksPage().created);
        webElementActions.waitStatusCode();

        int statusCode = ChromeWebDriver.getResponseStatusCode();
        assertEquals(statusCode, 201, "Expected status code is 201");
        System.out.println(demoqaPages.getLinksPage().linkResponse.getText());
    }

    @Test(singleThreaded = true)
    void noContentAPITest() {
        ChromeWebDriver.resetResponseStatusCode();
        ChromeWebDriver.filterResponsesByUrl("https://demoqa.com/no-content");
        helpers.getBrowserManager().openURL("https://demoqa.com/links");
        webElementActions.click(demoqaPages.getLinksPage().noContent);
        webElementActions.waitStatusCode();
        int statusCode = ChromeWebDriver.getResponseStatusCode();
        assertEquals(statusCode, 204, "Unauthorized");
        System.out.println(demoqaPages.getLinksPage().linkResponse.getText());
    }

    @Test
    void movedAPITest() {
        ChromeWebDriver.resetResponseStatusCode();
        ChromeWebDriver.filterResponsesByUrl("https://demoqa.com/moved");
        helpers.getBrowserManager().openURL(url);
        webElementActions.click(demoqaPages.getLinksPage().moved);

        // Wait for the status code to change from 0
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(driver -> ChromeWebDriver.getResponseStatusCode() != 0);

        // Verify the response status code
        int statusCode = ChromeWebDriver.getResponseStatusCode();
        assertEquals(statusCode, 301, "Expected status code 301");

        System.out.println(demoqaPages.getLinksPage().linkResponse.getText());
    }


    @Test
    void badRequestAPITest() {
        ChromeWebDriver.resetResponseStatusCode();
        // Фильтрация ответов с ключевым словом "demoqa"
        ChromeWebDriver.filterResponsesByUrl("https://demoqa.com/bad-request");
        helpers.getBrowserManager().openURL("https://demoqa.com/links");
//        getUrl();
        webElementActions.click(demoqaPages.getLinksPage().badRequest);

        // Используем WebDriverWait для явного ожидания обновления статус-кода
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                return ChromeWebDriver.getResponseStatusCode() != 0; // Ждем, пока статус-код изменится с 0
            }
        });

        // Получаем статус-код ответа после того, как ожидание завершится
        int statusCode = ChromeWebDriver.getResponseStatusCode();
        assertEquals(statusCode, 400, "Ожидаемый статус-код 401 для несанкционированного доступа");

        System.out.println(demoqaPages.getLinksPage().linkResponse.getText());
    }

    @Test
    void unauthorizedAPITest() {
        ChromeWebDriver.resetResponseStatusCode();
        ChromeWebDriver.filterResponsesByUrl("https://demoqa.com/unauthorized");
        helpers.getBrowserManager().openURL("https://demoqa.com/links");
//        getUrl();
        webElementActions.click(demoqaPages.getLinksPage().unauthorized);
        webElementActions.waitStatusCode();
        int statusCode = ChromeWebDriver.getResponseStatusCode();
        assertEquals(statusCode, 401, "Ожидаемый статус-код 401 для несанкционированного доступа");
    }

    @Test
    void forbiddenAPITest() {
        ChromeWebDriver.resetResponseStatusCode();
        ChromeWebDriver.filterResponsesByUrl("https://demoqa.com/forbidden");
        helpers.getBrowserManager().openURL("https://demoqa.com/links");
//        getUrl();
        webElementActions.click(demoqaPages.getLinksPage().forbidden);
        webElementActions.waitStatusCode();
        int statusCode = ChromeWebDriver.getResponseStatusCode();
        assertEquals(statusCode, 403, "Forbidden");
    }

    @Test
    void notFoundAPITest() {
        ChromeWebDriver.resetResponseStatusCode();
        ChromeWebDriver.filterResponsesByUrl("https://demoqa.com/invalid-url");
        helpers.getBrowserManager().openURL("https://demoqa.com/links");
//        getUrl();
        webElementActions.click(demoqaPages.getLinksPage().notFound);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until((ExpectedCondition<Boolean>) driver -> ChromeWebDriver.getResponseStatusCode() != 0);
        int statusCode = ChromeWebDriver.getResponseStatusCode();
        assertEquals(statusCode, 404, "Not Found");
    }


    @AfterMethod
    public void tearDown() {
        ChromeWebDriver.clearNetworkData();

    }

    @AfterClass
    private void closeDriver() {
        driver.close();
    }


}
