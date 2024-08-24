import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;


import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortProductPriceByLowToHigh extends baseTests {

    public WebDriver login(String username, String password) {
        hook.username().sendKeys(username);
        hook.password().sendKeys(password);
        hook.clickLogin().click();
        return hook.driver;
    }

    @Test
    public void sortPriceByLowToHigh() throws InterruptedException {

        driver = login("visual_user", "secret_sauce");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(sorting.productSortContainer()));


        Select sort = new Select(sorting.productSortContainer());
        sort.selectByValue("lohi");

        List<WebElement> priceElements = driver.findElements(sorting.inventoryItemPrice());
        List<Double> actualPrice = new ArrayList<>();

        for (WebElement price : priceElements) {
            String priceText = price.getText().replace("$", "");
            actualPrice.add(Double.parseDouble(priceText));
        }

        List<Double> expectedPrices = new ArrayList<>(actualPrice);
        Collections.sort(expectedPrices);

        soft.assertEquals(actualPrice, expectedPrices, "Products are not sorted by price (low to high) correctly");
        soft.assertAll();
        Thread.sleep(5000);
    }
}
