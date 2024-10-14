package advanced_locators;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class XpathDemo {

    @Test
    void absoluteXpathDemoTest() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://demoqa.com/webtables");

        WebElement submitBtn = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[2]/div[2]/form/div[5]/div/button"));
        submitBtn.click();

        Thread.sleep(3000);

        driver.close();
        driver.quit();
    }

    @Test
    void relativeXpathDemoTest() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://demoqa.com/webtables");

        WebElement submitBtn = driver.findElement(By.xpath("//button[@id='submit']"));
        WebElement submitBtn2 = driver.findElement(By.xpath("//button[@type='button' and text()='Submit']"));
        WebElement submitBtn3 = driver.findElement(By.xpath("(//button[@type='button'])[2]"));
        submitBtn.click();

        WebElement inputFullName = driver.findElement(By.xpath("//input[@placeholder='Full Name']"));
        WebElement inputFullName2 = driver.findElement(By.xpath("//input[@placeholder='Full Name' and @type='text' or @id='userName']"));
        WebElement inputFullName3 = driver.findElement(By.xpath("//*[@placeholder='Full Name']"));

        // to the inner div
        WebElement output = driver.findElement(By.xpath("//div[@id='output']/div/p[@id='email']"));

        // to the parent div /..
        WebElement output2 = driver.findElement(By.xpath("//p[@id='email']/../../"));

        //methods of the Xpath
        //h1[text()='Text Box']  -->  text()
        //h1[contains(text(),'Text Box')]  --> contains( 1st , 2nd )
        //input[starts-with(@id,'userE')]

        ////////      https://glovoapp.com/kg/ru/bishkek/   ///////////
        //h3[normalize-space()='Фаиза / Faiza']  --> normalize-space() is for trim
        //span[starts-with(text(),'Перед')]

        ///////      https://www.amazon.com/s?k=iphone&crid=1M4ADPB4SJMG6&sprefix=iphone%2Caps%2C259&ref=nb_sb_noss_2
        //div[@id='brandsRefinements']/ul[1]/span/span[position()=3]  --> position()
        //div[@id='brandsRefinements']/ul[1]/span/span[last()]  --> last()
        //span[round(text())='999'] --> 1000
        //span[floor(text())='999'] --> 999
        //input[starts-with(@id,'user') and not(@type='text')] --> and not


        Thread.sleep(3000);

        driver.close();
        driver.quit();
    }

    @Test
    void amazonXpathDemoTest() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.amazon.com/");

        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Iphone" + Keys.ENTER);
        Thread.sleep(5000);

        List<WebElement> brands = driver.findElements(By.xpath("//div[@id='brandsRefinements']/ul/span/span/li/span/a/span"));
        for (WebElement brand : brands) {
            System.out.println(brand.getText());
        }
        driver.close();

    }

    //Xpath Axes
    // 1. parent --> //div[@id='brandsRefinements']/ul/span/span/parent::span   OR   /..
    // 2. child -->  //div[@id='brandsRefinements']/ul[position()=1]/span/child::span
    // 3. ancestor --> //span[text()='Apple' and @class='a-size-medium a-color-base']/ancestor::ul
    // 4. descendant --> //div[@id="brandsRefinements"]/descendant::span
    // 5. following-sibling -> ////div[@id="brandsRefinements"]/ul/span/span/following-sibling::span[2]
    // 6. preceding --> //tbody/tr[2]/td[3]/preceding::td ==>          w3schools(table)
    // 6. preceding --> //tbody/tr[2]/td[3]/preceding-sibling::td[2] ==>          w3schools(table)
}
