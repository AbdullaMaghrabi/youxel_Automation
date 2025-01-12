package searchPackage;


import org.testng.Assert;
import org.testng.annotations.Test;
import searchPages.Landing;
import searchPages.Results;
import taskTemplate.TestClass;


public class SearchWithFiltersTest extends TestClass {

    @Test
    public void searchAndFilterTest() {

        // Navigate to site and search
        Results resultsPage = new Landing(driver)
                .navigate()
                .search("laptop");

        // Validate search result title
        wait.until(d -> {
        String resultTitle = resultsPage.getSearchResultTitle(1);
        Assert.assertTrue(
                resultTitle.toLowerCase().contains("laptop"),
                "Search result title does not contain expected keyword!");

        // Apply price filter and validate results
        int price = resultsPage
                .priceFilter(10000, 20000)
                .getSearchResultPrice(1);
        Assert.assertTrue(
                price >= 10000 && price <= 20000,
                "Filtered result price is outside the specified range!");
            return true;
        });
    }
}

