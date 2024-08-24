import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LogoutLocators {

    WebDriver driver;

     LogoutLocators(WebDriver driver){
        this.driver=driver;
    }


    public WebElement burgerMenuBtn (){
        return driver.findElement(By.xpath("//button[contains(@id, \"react-burger-menu-btn\")]"));
    }

    public WebElement logoutBtn (){
         return driver.findElement(By.cssSelector("a[id=\"logout_sidebar_link\"]"));
    }
}
