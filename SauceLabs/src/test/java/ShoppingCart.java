import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;


import java.time.Duration;

public class ShoppingCart extends baseTests{


    public WebDriver login(String username, String password) {
        hook.username().sendKeys(username);
        hook.password().sendKeys(password);
        hook.clickLogin().click();
        return hook.driver;
    }


    @Test
    public void addProductToCart() throws InterruptedException {
        driver = login("visual_user", "secret_sauce");

        WebElement firstCartBtn = cart.firstButton();
        scrollTillVisible(driver, firstCartBtn);
        firstCartBtn.click();
        String expectedCartBadge = "1";
        String actualCartBadge = cart.shoppingCartBadge().getText();
        soft.assertEquals(actualCartBadge, expectedCartBadge, "Assertion to ensure that the cart is updated");
        Thread.sleep(3000);

    }


    @Test
    public void removeProductFromCart() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOf(cart.moveToCart()));

        cart.moveToCart().click();
        cart.removeBtn().click();
        boolean isCartEmpty = driver.findElements(cart.emptyCart()).isEmpty();
        soft.assertTrue(isCartEmpty, "Assertion to ensure the cart is empty");
        soft.assertAll();
        Thread.sleep(3000);
    }


    public void scrollTillVisible(WebDriver driver, WebElement Element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", Element);
    }

}
