import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class baseTests {

    WebDriver driver;
    SoftAssert soft = new SoftAssert();
    LoginLocators hook;
    ProductPageLocators productPageLocators;
    LogoutLocators logoutLocators;
    CartLocators cart;
    SortingLocators sorting;
    String baseURL;

    @BeforeClass
    public void openBrowser() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        baseURL = "https://www.saucedemo.com/";
        driver.get(baseURL);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        logoutLocators = new LogoutLocators(driver);
        hook = new LoginLocators(driver);
        productPageLocators = new ProductPageLocators(driver);
        cart = new CartLocators(driver);
        sorting = new SortingLocators(driver);
    }

    @AfterClass
    public void closeBrowser() {
        driver.quit();
    }
}
