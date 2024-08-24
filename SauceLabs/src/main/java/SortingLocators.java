import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SortingLocators {

    WebDriver driver;

    SortingLocators(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement productSortContainer() {
        return driver.findElement(By.xpath("//select[contains(@class, \"product_sort_container\")]"));
    }

    public By inventoryItemPrice() {
        return By.xpath("//div[@class=\"inventory_item_price\"]");
    }
}
