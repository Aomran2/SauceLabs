import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;


import java.util.List;

public class ProductsDisplay extends baseTests{

    public WebDriver login(String username, String password) {
        hook.username().sendKeys(username);
        hook.password().sendKeys(password);
        hook.clickLogin().click();
        return hook.driver;
    }

    @Test
    public void validateProductsDisplay() throws InterruptedException {

        driver = login("visual_user", "secret_sauce");

        List<WebElement> products = driver.findElements(productPageLocators.productsDisplay());
        int actualProductsCount = products.size();
        int expectedProductsCount = products.size();
        soft.assertEquals(actualProductsCount, expectedProductsCount, "products assertion");

        boolean allProductsDisplayed = false;

        for (WebElement product : products) {
            if (product.isDisplayed()) {
                allProductsDisplayed = true;
            } else System.out.println("Product is not displayed" + product.getText());
        }

        if (allProductsDisplayed) {
            System.out.println("products are displayed successfully");
        } else System.out.println("Not all products displayed");

        soft.assertAll();
        Thread.sleep(10000);
    }

}
