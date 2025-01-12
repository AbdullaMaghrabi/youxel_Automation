package searchPages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class Landing {
    private WebDriver driver;
    private String url = "https://www.noon.com/egypt-en/";

    public Landing(WebDriver driver){
        this.driver = driver;
    }

    By searchBox = By.id("searchBar");

    public Landing navigate(){
        driver.navigate().to(url);
        return this;
    }


    public Landing search(String searchQuery){
        driver.findElement(searchBox).sendKeys(searchQuery + Keys.ENTER);
        return this;
    }




}
