package tests;

import base.Tests;
import com.codeborne.selenide.WebDriverRunner;
import listeners.CustomWebDriverListener;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.testng.annotations.Test;
import java.net.MalformedURLException;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class FirstTest extends Tests{
    @Test
    public void testOne() throws MalformedURLException {
        ChromeOptions chromeOptions = new ChromeOptions();
        //WebDriver driver = new RemoteWebDriver(new URL("http://192.168.1.224:4444"), chromeOptions);

        //WebDriver set-up:
        WebDriver driver = new ChromeDriver(chromeOptions);
        CustomWebDriverListener eventListener = new CustomWebDriverListener();
        EventFiringDecorator<WebDriver> decorator = new EventFiringDecorator<>(eventListener);
        WebDriver webDriver = decorator.decorate(driver);
        WebDriverRunner.setWebDriver(webDriver);

        //Actual test begins here:
        open("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        $(By.name("username")).setValue("Admin");
        $(By.name("password")).setValue("admin123");
        $(By.xpath("//button[@type='submit']")).click();
        $(By.xpath("//h6")).shouldHave(exactText("Dashboard"));
        webDriver.quit();
    }
}
