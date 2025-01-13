package searchPackage;

import org.testng.Assert;
import org.testng.annotations.Test;
import searchPages.Landing;
import searchPages.Results;
import taskTemplate.TestClass;
import org.json.JSONObject;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class SearchWithFiltersTest extends TestClass {

    @Test
    public void searchAndFilterTest() throws IOException {
        // Load test data from the JSON file (located in src/test/resources)
        String jsonContent = new String(Files.readAllBytes(Paths.get("src/test/resources/testInputs.json")));
        JSONObject jsonObject = new JSONObject(jsonContent);

        // Extract data from the JSON
        String searchTerm = jsonObject.getString("searchTerm");
        int minPrice = jsonObject.getJSONObject("priceRange").getInt("min");
        int maxPrice = jsonObject.getJSONObject("priceRange").getInt("max");

        // Perform search and filter operations
        Results resultsPage = new Landing(driver)
                .navigate()
                .search(searchTerm);

        // Wait for search result title to contain the search term
        wait.until(driver -> {
            String resultTitle = resultsPage.getSearchResultTitle(1);
            Assert.assertTrue(resultTitle.toLowerCase().contains(searchTerm.toLowerCase()),
                    "Search result title does not contain the expected keyword!");
            return true;
        });

        // Apply price filter and wait for result validation
        resultsPage.priceFilter(minPrice, maxPrice);
        wait.until(driver -> {
            int price = resultsPage.getSearchResultPrice(1);
            Assert.assertTrue(price >= minPrice && price <= maxPrice,
                    "Filtered result price is outside the specified range!");
            return true;
        });
    }
}

