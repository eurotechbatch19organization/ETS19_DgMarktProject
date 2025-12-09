package com.dgmarkt.pages;

import com.dgmarkt.utilities.BrowserUtils;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortingPage extends BasePage {

    @FindBy(id = "input-sort")
    private WebElement sortByDropdown;

    @FindBy(css = ".product-thumb h4 a")
    private List<WebElement> productNameElements;

    @FindBy(css = ".price")
    private List<WebElement> productPriceElements;

    @FindBy(css = ".product-thumb .rating")
    private List<WebElement> productRatingElements;

    /**
     * Bu method Sort By dropdown'ından istenen sorting tipini seçer
     * @param sortType - "Default", "Name (A - Z)", "Price (Low > High)" vb.
     */
    public void selectSortByOption(String sortType) {
        Select select = new Select(sortByDropdown);
        select.selectByVisibleText(sortType);
    }

    /**
     * Bu method dropdown'da seçili olan sorting tipini döndürür
     * @return Seçili olan sort option
     */
    public String getSelectedSortByOption() {
        Select select = new Select(sortByDropdown);
        return select.getFirstSelectedOption().getText();
    }

    /**
     * Bu method sayfadaki tüm ürün isimlerini liste olarak döndürür
     * @return Ürün isimleri listesi
     */
    public List<String> getProductNames() {
        return BrowserUtils.getElementsText(productNameElements);
    }

    /**
     * Bu method sayfadaki tüm ürün fiyatlarını liste olarak döndürür
     * @return Ürün fiyatları listesi (Double)
     */
    public List<Double> getProductPrices() {
        List<Double> prices = new ArrayList<>();
        for (WebElement element : productPriceElements) {
            String priceText = element.getText()
                    .replace("$", "")
                    .replace("€", "")
                    .replace("£", "")
                    .replace(",", "")
                    .trim();
            try {
                prices.add(Double.parseDouble(priceText));
            } catch (NumberFormatException e) {
                System.out.println("Invalid price format: " + element.getText());
            }
        }
        return prices;
    }

    /**
     * Ürünlerin rating değerlerini döndürür
     * @return Rating listesi (Double)
     */
    public List<Double> getProductRatings() {
        List<Double> ratings = new ArrayList<>();

        for (WebElement element : productRatingElements) {
            try {
                String ratingText = element.getAttribute("data-rating");
                ratings.add(ratingText != null ? Double.parseDouble(ratingText) : 0.0);
            } catch (Exception e) {
                ratings.add(0.0);
            }
        }

        return ratings;
    }

    /**
     * Ürünlerin model değerlerini döndürür
     * Not: Sitede Model sıralaması ürün ismine göre yapıldığı için getProductNames() kullanılıyor
     * @return Model listesi (String)
     */
    public List<String> getProductModels() {
        return getProductNames();
    }

    /**
     * Belirtilen sort type'a göre ürünlerin doğru sıralandığını kontrol eder
     * @param sortType Sıralama tipi (örn: "Name (A - Z)", "Price (Low > High)")
     * @param category Kategori adı (hata mesajı için)
     */
    public void verifyProductsSortedBy(String sortType, String category) {
        BrowserUtils.waitFor(1);

        if (sortType.contains("Name")) {
            verifyNameSorting(sortType, category);
        }
        else if (sortType.contains("Price")) {
            verifyPriceSorting(sortType, category);
        }
        else if (sortType.contains("Rating")) {
            verifyRatingSorting(sortType, category);
        }
        else if (sortType.contains("Model")) {
            verifyModelSorting(sortType, category);
        }
        else if (sortType.equals("Default")) {
            verifyDefaultSorting(category);
        }
    }

    /**
     * Bu method Sort By dropdown'da seçili olan option'ın beklenenle aynı olduğunu doğrular
     * @param expectedSortType Beklenen sort type
     */
    public void verifySelectedSortOption(String expectedSortType) {
        Assert.assertEquals(
                "Sort By dropdown does not show the correct selected option!",
                expectedSortType,
                getSelectedSortByOption()
        );
    }

    /**
     * Name (A-Z) veya (Z-A) sıralamasını doğrular
     */
    private void verifyNameSorting(String sortType, String category) {
        List<String> actualNames = getProductNames();
        List<String> sortedNames = new ArrayList<>(actualNames);

        if (sortType.contains("A - Z")) {
            sortedNames.sort(String.CASE_INSENSITIVE_ORDER);
            Assert.assertEquals(
                    category + " - Products are not sorted by Name (A-Z)!",
                    sortedNames,
                    actualNames
            );
        } else if (sortType.contains("Z - A")) {
            sortedNames.sort(Collections.reverseOrder(String.CASE_INSENSITIVE_ORDER));
            Assert.assertEquals(
                    category + " - Products are not sorted by Name (Z-A)!",
                    sortedNames,
                    actualNames
            );
        }
    }

    /**
     * Price (Low > High) veya (High > Low) sıralamasını doğrular
     */
    private void verifyPriceSorting(String sortType, String category) {
        List<Double> actualPrices = getProductPrices();
        List<Double> sortedPrices = new ArrayList<>(actualPrices);

        if (sortType.contains("Low > High")) {
            sortedPrices.sort(Double::compareTo);
            Assert.assertEquals(
                    category + " - Products are not sorted by Price (Low > High)!",
                    sortedPrices,
                    actualPrices
            );
        } else if (sortType.contains("High > Low")) {
            sortedPrices.sort(Collections.reverseOrder());
            Assert.assertEquals(
                    category + " - Products are not sorted by Price (High > Low)!",
                    sortedPrices,
                    actualPrices
            );
        }
    }

    /**
     * Rating (Highest) veya (Lowest) sıralamasını doğrular
     */
    private void verifyRatingSorting(String sortType, String category) {
        List<Double> actualRatings = getProductRatings();
        List<Double> sortedRatings = new ArrayList<>(actualRatings);

        if (sortType.contains("Highest")) {
            sortedRatings.sort(Collections.reverseOrder());
            Assert.assertEquals(
                    category + " - Products are not sorted by Rating (Highest)!",
                    sortedRatings,
                    actualRatings
            );
        } else if (sortType.contains("Lowest")) {
            sortedRatings.sort(Double::compareTo);
            Assert.assertEquals(
                    category + " - Products are not sorted by Rating (Lowest)!",
                    sortedRatings,
                    actualRatings
            );
        }
    }

    /**
     * Model (A-Z) veya (Z-A) sıralamasını doğrular
     */
    private void verifyModelSorting(String sortType, String category) {
        List<String> actualModels = getProductModels();
        List<String> sortedModels = new ArrayList<>(actualModels);

        if (sortType.contains("A - Z")) {
            sortedModels.sort(String.CASE_INSENSITIVE_ORDER);
            Assert.assertEquals(
                    category + " - Products are not sorted by Model (A-Z)!",
                    sortedModels,
                    actualModels
            );
        } else if (sortType.contains("Z - A")) {
            sortedModels.sort(Collections.reverseOrder(String.CASE_INSENSITIVE_ORDER));
            Assert.assertEquals(
                    category + " - Products are not sorted by Model (Z-A)!",
                    sortedModels,
                    actualModels
            );
        }
    }

    /**
     * Default sıralama için ürünlerin yüklendiğini doğrular
     */
    private void verifyDefaultSorting(String category) {
        List<String> productNames = getProductNames();
        Assert.assertFalse(
                category + " - No products found on the page!",
                productNames.isEmpty()
        );
    }
}
