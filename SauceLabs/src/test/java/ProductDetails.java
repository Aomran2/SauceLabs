import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

public class ProductDetails extends baseTests {

    public WebDriver login(String username, String password) {
        hook.username().sendKeys(username);
        hook.password().sendKeys(password);
        hook.clickLogin().click();
        return hook.driver;
    }

    @Test
    public void validateProductDetails(){

        driver = login("visual_user", "secret_sauce");
        List<WebElement> products = driver.findElements(productPageLocators.productsDisplay());

        for (WebElement product : products) {

            String productName = product.findElement(productPageLocators.inventoryItemName()).getText();
            String productDescription = product.findElement(productPageLocators.inventoryItemDescription()).getText();
            String productPrice = product.findElement(sorting.inventoryItemPrice()).getText();

            System.out.println("----------------------------\n" + productName + "\n" + productDescription + "\n" + productPrice + "\n----------------------------");

            soft.assertTrue(productName != null && !productName.trim().isEmpty());
            soft.assertTrue(productDescription != null && !productDescription.trim().isEmpty());
            soft.assertTrue(priceIsFloatAndNotEmpty(productPrice));

            soft.assertAll();
        }
    }

    public boolean priceIsFloatAndNotEmpty(String priceString) {
        if (priceString == null || priceString.trim().isEmpty())
            return false;
        priceString = priceString.replace("$", "").trim();
        if (!priceString.isEmpty()) {
            try {
                float price = Float.parseFloat(priceString);
                System.out.println(price);
                return true;
            } catch (NumberFormatException e) {
                return false;
            }
        } else {
            return false;
        }
    }
}
