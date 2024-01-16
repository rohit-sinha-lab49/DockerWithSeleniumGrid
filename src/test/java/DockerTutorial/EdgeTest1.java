package DockerTutorial;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class EdgeTest1 {

    @Test
    public void test() throws MalformedURLException, InterruptedException {

        System.out.println ("Inside Edge browser-1");
        EdgeOptions edgeOptions = new EdgeOptions ();
        edgeOptions.setAcceptInsecureCerts(true);

        URL url = new URL ("http://localhost:4444/wd/hub");

        WebDriver driver = new RemoteWebDriver (url,edgeOptions);
        driver.manage ().window ().maximize ();

        try {
            driver.get ("https://ultimateqa.com/automation");

            Thread.sleep (20000);
            System.out.println ("Title : " + driver.getTitle ());
            System.out.println ("URL : " + driver.getCurrentUrl ());
        }catch (Exception e){
            driver.quit ();
        }finally {
            System.out.println ("In final block for quitting driver");
            System.out.println ("Close Edge browser-1");
            driver.quit ();
        }

    }
}
