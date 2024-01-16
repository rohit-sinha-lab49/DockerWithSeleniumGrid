package DockerTutorial;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class FirefoxTest2 {

    @Test
    public void test() throws MalformedURLException, InterruptedException {
        WebDriver driver = null;
        System.out.println ("Inside Firefox browser");
        try {
            FirefoxOptions firefoxOptions = new FirefoxOptions ();
            firefoxOptions.setAcceptInsecureCerts  (true);

            DesiredCapabilities desiredCapabilities = new DesiredCapabilities ();
            desiredCapabilities.setCapability (FirefoxOptions.FIREFOX_OPTIONS,firefoxOptions);

            URL url = new URL ("http://localhost:4444/wd/hub");

            driver = new RemoteWebDriver (url , desiredCapabilities);
            driver.manage ().window ().maximize ();

            driver.get ("https://flipkart.com");
            Thread.sleep (2000);
            System.out.println ("Title : " + driver.getTitle ());
            System.out.println ("URL : " + driver.getCurrentUrl ());
        }catch (Exception e) {
            driver.quit ();
        } finally {
            System.out.println ("In final block for quitting driver");
            System.out.println ("CLose Firefox browser");
            driver.quit ();
        }

    }
}
