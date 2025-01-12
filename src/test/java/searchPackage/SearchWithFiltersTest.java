package searchPackage;


import org.testng.Assert;
import org.testng.annotations.Test;
import searchPages.Landing;
import searchPages.Results;
import taskTemplate.TestClass;


public class SearchWithFiltersTest extends TestClass {

    @Test
    public void searchAndFilterTest(){

        // Navigate and search
        new Landing(driver).navigate().search("laptob");

        // Wait for results and validate title
        wait.until(d -> {
            String resultTitle = new Results(driver).getSearchResultTitle(1);
            Assert.assertTrue(resultTitle.toLowerCase().contains("laptop"), "Filtered results do not match criteria!");
            return true;
        });

        // Apply price filter and validate price
        wait.until(d -> {
            String price = new Results(driver).priceFilter(10000, 20000)
                    .getSearchResultPrice(1)
                    .replaceAll("[^0-9]", "");
            int priceInt = Integer.parseInt(price);
            Assert.assertTrue(priceInt >= 10000 && priceInt <= 20000, "Filtered results do not match criteria!");
            return true;
        });
    }
}

