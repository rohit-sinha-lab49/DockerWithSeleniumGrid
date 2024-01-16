package DockerTutorial;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class ChromeTest3 {

    @Test
    public void test() throws MalformedURLException, InterruptedException {

        System.out.println ("Inside Chrome browser-3");
        ChromeOptions options = new ChromeOptions ();
        options.setAcceptInsecureCerts (true);

        DesiredCapabilities desiredCapabilities = new DesiredCapabilities ();
        desiredCapabilities.setCapability (ChromeOptions.CAPABILITY,options);

        URL url = new URL ("http://localhost:4444/wd/hub");

        WebDriver driver = new RemoteWebDriver (url,desiredCapabilities);
        driver.manage ().window ().maximize ();

        try {
            driver.get ("https://ultimateqa.com/automation");
            Thread.sleep (5000);
            System.out.println ("Title : " + driver.getTitle ());
            System.out.println ("URL : " + driver.getCurrentUrl ());
        }catch (Exception e){
            driver.quit ();
        }finally {
            System.out.println ("In final block for quitting driver");
            System.out.println ("Close Chrome browser-3");
            driver.quit ();
        }

    }
}
