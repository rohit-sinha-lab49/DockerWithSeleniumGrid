package DockerTutorial;

import PageClass.SauceLabsHomePage;
import PageClass.SauceLabsLoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class Demo {

    WebDriver driver;
    @Test
    public void test () throws MalformedURLException, InterruptedException {
        try {
            System.out.println ("Inside Chrome browser-1");
            ChromeOptions options = new ChromeOptions ();
            options.setAcceptInsecureCerts (true);

            DesiredCapabilities desiredCapabilities = new DesiredCapabilities ();
            desiredCapabilities.setCapability (ChromeOptions.CAPABILITY,options);

            URL url = new URL ("http://localhost:4444/wd/hub");
            //URL url = new URL ("http://localhost:4444");

            driver = new RemoteWebDriver (url,desiredCapabilities);
            driver.manage ().window ().maximize ();
            SauceLabsLoginPage sauceLabsLoginPage = new SauceLabsLoginPage (driver);
            SauceLabsHomePage sauceLabsHomePage = new SauceLabsHomePage (driver);
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
        }catch (Exception e){
            driver.quit ();
        }finally {
            System.out.println ("In final block for quitting driver");
            System.out.println ("Close Chrome browser-1");
            driver.quit ();
        }
    }
}
