package searchPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class Results {

    private WebDriver driver;
    private By dynamicResult;

    public Results(WebDriver driver){
        this.driver = driver;
    }


    By priceDropdown = By.xpath("//div[@data-qa='Price (EGP)']");
    By priceMin = By.xpath("//div[contains(@class,'sc-335f151d-0 bCHxB')] //input[@name='min']");
    By priceMax = By.xpath("//div[contains(@class,'sc-335f151d-0 bCHxB')] //input[@name='max']");
    By applyPrice = By.xpath("//button[@data-qa='filter-price-btn']");

    public String getSearchResultTitle(int targetSearchResult){
        dynamicResult = By.xpath("(//*[@data-qa='product-name'])[" + targetSearchResult + "]");
        return driver.findElement(dynamicResult).getText();
    }

    public int getSearchResultPrice(int targetSearchResult){
        dynamicResult = By.xpath("(//strong[@class='amount'])[" + targetSearchResult + "]");
        String priceText = driver.findElement(dynamicResult).getText().replaceAll("[^0-9]", "");
        return Integer.parseInt(priceText);
    }

    public Results priceFilter (int minPrice, int maxPrice){
        driver.findElement(priceDropdown).click();
        driver.findElement(priceMin).clear();
        driver.findElement(priceMin).sendKeys(String.valueOf(minPrice));
        driver.findElement(priceMax).clear();
        driver.findElement(priceMax).sendKeys(String.valueOf(maxPrice));
        driver.findElement(applyPrice).click();
        return this;
    }


}
