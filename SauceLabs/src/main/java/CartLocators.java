import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CartLocators {

    WebDriver driver;

    CartLocators(WebDriver driver){
        this.driver = driver;
    }

    public WebElement firstButton(){
        return driver.findElement(By.xpath("//button[contains(@class,\"btn btn_primary btn_small btn_inventory \")]"));
    }

    public WebElement shoppingCartBadge (){
        return driver.findElement(By.xpath("//span[@class=\"shopping_cart_badge\"]"));
    }

    public WebElement removeBtn () {
        return driver.findElement(By.cssSelector("button[class=\"btn btn_secondary btn_small cart_button\"]"));
    }

    public WebElement moveToCart () {
        return driver.findElement(By.xpath("//a[@class=\"shopping_cart_link\"]"));
    }

    public By emptyCart () {
        return By.cssSelector("div[class=\"cart_quantity\"]");
    }
}
