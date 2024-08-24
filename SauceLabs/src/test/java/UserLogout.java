import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class UserLogout extends baseTests{

    @Test
    public void logout() throws InterruptedException {

        hook.username().sendKeys("visual_user");
        hook.password().sendKeys("secret_sauce");
        hook.clickLogin().click();
        Thread.sleep(5000);

        logoutLocators.burgerMenuBtn().click();
        logoutLocators.logoutBtn().click();


        String currentUrl = driver.getCurrentUrl();
        soft.assertEquals(currentUrl, baseURL, "Logout assertion");

        Thread.sleep(5000);
        soft.assertAll();
    }
}
