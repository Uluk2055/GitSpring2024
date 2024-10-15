package demoqa.drivers;

import demoqa.utils.ConfigReader;
import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.Getter;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v129.network.Network;
import org.openqa.selenium.devtools.v129.network.model.Request;
import org.openqa.selenium.devtools.v129.network.model.Response;

import java.time.Duration;
import java.util.Optional;

public class ChromeWebDriver {

    public static WebDriver driver;
    public static DevTools devTools;
    @Getter
    private static int responseStatusCode;


    public static WebDriver loadChromeDriver() {
        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--disable-extensions");
        options.addArguments("--window-size=1920,1080");
        options.addArguments("--disable-gpu");
        options.addArguments("--no-sandbox");

        options.setPageLoadStrategy(PageLoadStrategy.EAGER);

        if (Boolean.parseBoolean(ConfigReader.getValue("headless"))) {
            options.addArguments("--headless");
        }

        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


        devTools = ((ChromeDriver) driver).getDevTools();
        devTools.createSession();
        devTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));

        return driver;
    }

    // Метод для фильтрации запросов
    public static void filterRequestsByUrl(String keyword) {
        devTools.addListener(Network.requestWillBeSent(), request -> {
            Request req = request.getRequest();
            String url = req.getUrl();
            if (url.contains(keyword)) {
                System.out.println("Перехваченный запрос: ");
                System.out.println("URL: " + req.getUrl());
                System.out.println("Метод запроса: " + req.getMethod());
                System.out.println("Заголовки: " + req.getHeaders());
                System.out.println("===================================");
            }
        });
    }

    // Метод для фильтрации ответов
    public static void filterResponsesByUrl(String keyword) {
        devTools.addListener(Network.responseReceived(), responseReceived -> {
            Response response = responseReceived.getResponse();
            String url = response.getUrl();
            if (url.contains(keyword)) {
                responseStatusCode = response.getStatus(); // Сохраняем статус-код
                System.out.println("Перехваченный ответ: ");
                System.out.println("URL: " + url);
                System.out.println("Статус-код: " + responseStatusCode);
                System.out.println("Заголовки ответа: " + response.getHeaders());
                System.out.println("===================================");

            }
        });
    }


    public static void clearNetworkData() {
        devTools.send(Network.clearBrowserCache());
        devTools.send(Network.clearBrowserCookies());
    }

    public static void resetResponseStatusCode() {
        responseStatusCode = 0; // Сбрасываем перед каждым тестом
    }

}
