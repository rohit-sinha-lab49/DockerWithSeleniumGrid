package DockerTutorial;

import PageClass.SauceLabsCheckoutPage;
import PageClass.SauceLabsHomePage;
import PageClass.SauceLabsLoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class ChromeTest1 {
    SauceLabsLoginPage sauceLabsLoginPage;
    SauceLabsHomePage sauceLabsHomePage;
    SauceLabsCheckoutPage sauceLabsCheckoutPage;
    WebDriver driver;

    @BeforeClass
    public void initializeChromeTestOne() throws MalformedURLException {
        System.out.println ("Inside Chrome browser-1");
        ChromeOptions options = new ChromeOptions ();
        options.setAcceptInsecureCerts (true);

        DesiredCapabilities desiredCapabilities = new DesiredCapabilities ();
        desiredCapabilities.setCapability (ChromeOptions.CAPABILITY,options);

        URL url = new URL ("http://localhost:4444/wd/hub");

        driver = new RemoteWebDriver (url,desiredCapabilities);
        driver.manage ().window ().maximize ();
        sauceLabsLoginPage = new SauceLabsLoginPage (driver);
        sauceLabsHomePage = new SauceLabsHomePage (driver);
        sauceLabsCheckoutPage = new SauceLabsCheckoutPage (driver);
    }

    @Test
    public void test()  {
        try {
            driver.get ("https://www.saucedemo.com/");
            Thread.sleep (20000);
            System.out.println ("Title : " + driver.getTitle ());
            System.out.println ("URL : " + driver.getCurrentUrl ());


            sauceLabsLoginPage.LoginToSauceLabsSite ();
            Thread.sleep (5000);


            //sauceLabsHomePage.clickOnHamburgerMenu ();
            //Thread.sleep (5000);

            //sauceLabsHomePage.getListOfItemsOnHamburgerMenu ("Logout");
            //Thread.sleep (5000);

            sauceLabsHomePage.getListOfAvailableItemsFromInventory ();
            Thread.sleep (5000);

            String[] expectedItemsName = {"backpack","bike-light","bolt-t-shirt","jacket","onesie","t-shirt-(red)"};

            boolean flag = sauceLabsHomePage.addItemToCartFromInventory ("backpack");
            System.out.println ("Value of flag is : "+flag);
            Thread.sleep (5000);

            sauceLabsHomePage.checkIfItemIsAddedToCart (flag,"Backpack");
            Thread.sleep (5000);

            String[] itemsInfoArr = {"Sauce Labs Backpack" , "carry.allTheThings() with the sleek, streamlined Sly Pack that melds uncompromising style with unequaled laptop and tablet protection." , "$29.99"};
            sauceLabsCheckoutPage.validateAddedItemInCheckout (itemsInfoArr[0]);
            sauceLabsCheckoutPage.validateDescriptionOfAddedItemInCheckout (itemsInfoArr[1]);
            sauceLabsCheckoutPage.validatePriceOfAddedItemInCheckout (itemsInfoArr[2]);
            sauceLabsCheckoutPage.clickOnCheckoutBtn ();

            Thread.sleep (5000);

            List<String> listOfInformationOfUser = new ArrayList<> ();
            listOfInformationOfUser.add ("userfirstname");
            listOfInformationOfUser.add ("usersecondname");
            listOfInformationOfUser.add ("10001");

            sauceLabsCheckoutPage.inputCustomerDetails (listOfInformationOfUser);
            Thread.sleep (5000);
            sauceLabsCheckoutPage.clickOnContinueBtn ();

            Thread.sleep (5000);
            sauceLabsCheckoutPage.clickOnFinishButton ();

            Thread.sleep (5000);

            sauceLabsCheckoutPage.validateOrderSuccessMsg ("Thank you for your order!");
            Thread.sleep (5000);

        }catch (Exception e){
            e.printStackTrace ();
        }

    }

    @AfterClass
    public void tearDown(){
        driver.quit ();
    }
}
