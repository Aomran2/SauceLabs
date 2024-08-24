import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginLocators {

    WebDriver driver;

    LoginLocators(WebDriver driver) {
        this.driver = driver;
    }


    public WebElement username() {
        return driver.findElement(By.xpath("//input[@placeholder=\"Username\"]"));
    }

    public WebElement password() {
        return driver.findElement(By.xpath("//input[@placeholder=\"Password\"]"));
    }

    public WebElement clickLogin(){
        return driver.findElement(By.xpath("//input[@name=\"login-button\"]"));
    }

    public WebElement errorMessage(){
        return  driver.findElement(By.xpath("//h3[@data-test=\"error\"]"));
    }
}
