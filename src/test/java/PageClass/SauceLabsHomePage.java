package PageClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public class SauceLabsHomePage {

    private WebDriver driver;
    List<WebElement> list;

    public SauceLabsHomePage(WebDriver driver){
        this.driver = driver;
        driver.manage ().timeouts ().implicitlyWait (10, TimeUnit.MILLISECONDS);
        driver.manage ().timeouts ().pageLoadTimeout (10,TimeUnit.SECONDS);
        System.out.println (driver);
    }

    public void clickOnHamburgerMenu(){
        WebElement hamburgerMenu = driver.findElement (By.xpath ("//button[@id='react-burger-menu-btn']"));
        hamburgerMenu.click ();
    }

    public void getListOfItemsOnHamburgerMenu(String val){
        List<WebElement> list = driver.findElements (By.xpath ("//div[@class='bm-menu']//a"));
        List<String> listOfVal = list.stream ().map (a->a.getText ().trim ()).collect(Collectors.toList());
        System.out.println ("Items on the tray is : "+listOfVal);
        if(list.size ()==4){
            try {
                for (int i = 0; i < list.size (); i++) {
                    if (list.get (i).getText ().trim ().equalsIgnoreCase (val)) {
                        list.get (i).click ();
                        break;
                    }
                }
            }catch (Exception e){
                e.printStackTrace ();
            }
        }else{
            Assert.fail ("Size of items on hamburger menu link is not correct : "+list.size ());
        }
    }

    public void getListOfAvailableItemsFromInventory(){
        list = driver.findElements (By.xpath ("//div[@class='inventory_list']/div/div[@class='inventory_item_description']"));
        if(list.size ()==6){
                List<WebElement> descEle = driver.findElements (By.xpath ("//div[@class='inventory_list']/div/div[@class='inventory_item_description']/div[contains(@class,'label')]/div[contains(@class,'desc')]"));
                for(WebElement e : descEle) {
                    System.out.println ("Description of all the items in inventory should be : " + e.getText ().trim ());
                }

                List<WebElement> priceEle = driver.findElements (By.xpath ("//div[@class='inventory_list']/div/div[@class='inventory_item_description']/div[contains(@class,'pricebar')]/div"));
                for(WebElement e : priceEle) {
                    System.out.println ("Price of all the items in inventory should be : " + e.getText ().trim ());
                }
        }else{
            Assert.fail ("List of items on inventory is not correct : "+list.size ());
        }
    }

    public Boolean addItemToCartFromInventory(String val){
        boolean flag = false;
            List<WebElement> buttonEle = driver.findElements (By.xpath ("//div[@class='inventory_list']/div/div[@class='inventory_item_description']/div[contains(@class,'pricebar')]/button"));
            for(WebElement element : buttonEle){
                String itemName = element.getAttribute ("name").trim ();
                System.out.println ("Itemname is : "+itemName);
                if(itemName.contains (val)){
                    System.out.println ("User adds item to inventory : "+itemName);
                    flag = true;
                    element.click ();
                }

                if(flag){
                    break;
                }
            }
        return flag;
    }

    public void checkIfItemIsAddedToCart(boolean val,String expectedItem) throws InterruptedException {
        if(val){
            WebElement cartEle = driver.findElement (By.xpath ("//a[@class='shopping_cart_link']"));
            cartEle.click ();

            Thread.sleep (5000);

            WebElement ele = driver.findElement (By.xpath ("//div[@class='inventory_item_name']"));
            String actualItem = ele.getText ().trim ();
            if(actualItem.contains (expectedItem)){
                System.out.println ("Item is added to the cart successfully");
            }
        }else{
            Assert.fail ("Item is not added to cart");
        }
    }
}
