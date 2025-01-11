package searchPackage;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SearchTestClass {
    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        // Set up the driver
        driver = new ChromeDriver();
        driver.manage().window().maximize();

    }

    @AfterMethod
    public void tearDown(){
        // Quit the driver
        driver.quit();
    }

    @Test
    public void searchTest(){
        // Navigate to the website
        driver.get("https://www.noon.com/egypt-en/");

        // Perform the search
        driver.findElement(org.openqa.selenium.By.id("searchBar")).sendKeys("laptop"+ Keys.ENTER);
    }
}
