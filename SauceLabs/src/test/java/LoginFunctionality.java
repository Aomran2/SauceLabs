import org.testng.annotations.Test;


public class LoginFunctionality extends baseTests {

    @Test
    public void invalidCredentials() throws InterruptedException {
        hook.username().sendKeys("visual_user");
        hook.password().sendKeys("secret");
        hook.clickLogin().click();
        String expectedErrorMessage = "Epic sadface: Username and password do not match any user in this service";
        String actualErrorMessage = hook.errorMessage().getText();
        soft.assertEquals(actualErrorMessage, expectedErrorMessage, "Invalid credentials assertion");
        Thread.sleep(3000);
        soft.assertAll();
    }


    @Test
    public void validCredentials() throws InterruptedException {
        driver.navigate().refresh();
        hook.username().sendKeys("visual_user");
        hook.password().sendKeys("secret_sauce");
        hook.clickLogin().click();
        String currentUrl = driver.getCurrentUrl();
        String homePage = "https://www.saucedemo.com/inventory.html";
        soft.assertEquals(currentUrl, homePage, "Login assertion");
        Thread.sleep(3000);
        soft.assertAll();
    }

}
