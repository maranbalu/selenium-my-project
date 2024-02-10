package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;
import java.net.MalformedURLException;
import java.net.URL;

public class FirstTest {

    @Test
    public void testOne() throws MalformedURLException {
        ChromeOptions chromeOptions = new ChromeOptions();
        WebDriver driver = new RemoteWebDriver(new URL("http://192.168.1.224:4444"), chromeOptions);
        //WebDriver driver = new ChromeDriver(chromeOptions);
        driver.get("http://www.google.com");
        driver.quit();
    }
}
