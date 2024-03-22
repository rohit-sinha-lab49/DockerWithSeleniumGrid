package DockerTutorial;

import PageClass.SauceLabsCheckoutPage;
import PageClass.SauceLabsHomePage;
import PageClass.SauceLabsLoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class FirefoxTest1 {

    SauceLabsLoginPage sauceLabsLoginPage;
    SauceLabsHomePage sauceLabsHomePage;
    SauceLabsCheckoutPage sauceLabsCheckoutPage;
    WebDriver driver;

    @BeforeClass
    public void initializeFirefoxTestOne () throws MalformedURLException {
        System.out.println ("Inside Firefox browser-1");
        FirefoxOptions firefoxOptions = new FirefoxOptions ();
        firefoxOptions.setAcceptInsecureCerts (true);

        DesiredCapabilities desiredCapabilities = new DesiredCapabilities ();
        desiredCapabilities.setCapability (FirefoxOptions.FIREFOX_OPTIONS , firefoxOptions);

        URL url = new URL ("http://localhost:4444/wd/hub");

        driver = new RemoteWebDriver (url , desiredCapabilities);
        driver.manage ().window ().maximize ();
        sauceLabsLoginPage = new SauceLabsLoginPage (driver);
        sauceLabsHomePage = new SauceLabsHomePage (driver);
        sauceLabsCheckoutPage = new SauceLabsCheckoutPage (driver);
    }

    @Test
    public void test () {
        try {
            driver.get ("https://www.saucedemo.com/");
            Thread.sleep (20000);
            System.out.println ("Title : " + driver.getTitle ());
            System.out.println ("URL : " + driver.getCurrentUrl ());

            driver.get ("https://www.saucedemo.com/");
            Thread.sleep (20000);
            System.out.println ("Title : " + driver.getTitle ());
            System.out.println ("URL : " + driver.getCurrentUrl ());


            sauceLabsLoginPage.LoginToSauceLabsSite ();
            Thread.sleep (5000);


            sauceLabsHomePage.clickOnHamburgerMenu ();
            Thread.sleep (5000);

            sauceLabsHomePage.getListOfItemsOnHamburgerMenu ("Logout");
            Thread.sleep (5000);
        } catch (Exception e) {
            e.printStackTrace ();
        }

    }

    @AfterClass
    public void tearDown () {
        driver.quit ();
    }
}
