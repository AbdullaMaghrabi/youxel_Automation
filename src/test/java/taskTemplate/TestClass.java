package taskTemplate;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class TestClass {
   public WebDriver driver;
   public Wait<WebDriver> wait;
    @BeforeMethod
    public void setUp() {
        // Set up the driver
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(20))
                .pollingEvery(Duration.ofMillis(300))
                .ignoring(NotFoundException.class)
                .ignoring(StaleElementReferenceException.class)
                .ignoring(ElementNotInteractableException.class)
                .ignoring(AssertionError.class);

    }
    @AfterMethod
    public void tearDown(){
        // Quit the driver
        driver.quit();
    }
}
