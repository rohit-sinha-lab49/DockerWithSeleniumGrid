package PageClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class SauceLabsLoginPage {

    private WebDriver driver;
    public SauceLabsLoginPage(WebDriver driver){
        this.driver = driver;
        driver.manage ().timeouts ().implicitlyWait (10, TimeUnit.MILLISECONDS);
        driver.manage ().timeouts ().pageLoadTimeout (10,TimeUnit.SECONDS);
        System.out.println (driver);
    }

    public void LoginToSauceLabsSite(){
        WebElement username = driver.findElement (By.xpath ("//input[@id='user-name']"));
        WebElement password = driver.findElement (By.xpath ("//input[@id='password']"));

        WebElement loginBtn = driver.findElement (By.xpath ("//input[@id='login-button']"));

        username.sendKeys ("standard_user");
        password.sendKeys ("secret_sauce");

        loginBtn.click ();
    }
}
