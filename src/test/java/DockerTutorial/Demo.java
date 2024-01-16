package DockerTutorial;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class Demo {
    @Test
    public void test () throws MalformedURLException, InterruptedException {
        ChromeOptions options = new ChromeOptions ();
        options.setAcceptInsecureCerts (true);
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities ();
        desiredCapabilities.setCapability (ChromeOptions.CAPABILITY , options);

        URL url = new URL ("http://localhost:4444/wd/hub");

        WebDriver driver = new RemoteWebDriver (url , desiredCapabilities);
        driver.get ("https://www.google.com/");
        //Perform your test actions with the WebDriver instance
        driver.quit ();
    }
}
