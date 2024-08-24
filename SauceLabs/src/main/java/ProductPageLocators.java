import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ProductPageLocators {

    WebDriver driver;

    ProductPageLocators(WebDriver driver) {
        this.driver = driver;
    }


    public By productsDisplay() {
        return By.xpath("//div[@data-test=\"inventory-item\"]");
    }

    public By inventoryItemName() {
        return By.xpath(".//div[contains(@class, \"inventory_item_name \")]");
    }

    public By inventoryItemDescription() {
        return By.xpath(".//div[@class=\"inventory_item_desc\"]");
    }

}
