package tests;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class BaseTest {
    public WebDriver driver;

    @Before
    public void beforeSuite() {
        ChromeOptions chromeOptions = new ChromeOptions();
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver/chromedriver.exe");
        driver = new ChromeDriver(chromeOptions);
        }

    @After
    public void afterSuite() {
        if(null != driver) {
            driver.close();
            driver.quit();
        }
    }
}
