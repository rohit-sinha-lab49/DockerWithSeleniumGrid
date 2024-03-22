package PageClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class SauceLabsCheckoutPage {

    private WebDriver driver;

    public SauceLabsCheckoutPage(WebDriver driver){
        this.driver = driver;
        driver.manage ().timeouts ().implicitlyWait (10, TimeUnit.MILLISECONDS);
        driver.manage ().timeouts ().pageLoadTimeout (10,TimeUnit.SECONDS);
        System.out.println (driver);
    }

    //Sauce Labs Backpack
    public void validateAddedItemInCheckout(String expectedName){
        WebElement ele = driver.findElement (By.xpath ("//div[@class='cart_list']//div[@class='cart_item_label']/a/div"));
        String actualValue = ele.getText ().trim ();
        Assert.assertEquals (expectedName,actualValue,"Validate name of added item");
    }

    //carry.allTheThings() with the sleek, streamlined Sly Pack that melds uncompromising style with unequaled laptop and tablet protection.
    public void validateDescriptionOfAddedItemInCheckout(String expectedDescription){
        WebElement ele = driver.findElement (By.xpath ("//div[@class='cart_list']//div[@class='cart_item_label']/div[@class='inventory_item_desc']"));
        String actualValue = ele.getText ().trim ();
        Assert.assertEquals (expectedDescription,actualValue,"Validate description of added item");
    }

    //$29.99
    public void validatePriceOfAddedItemInCheckout(String expectedPrice){
        WebElement ele = driver.findElement (By.xpath ("//div[@class='cart_list']//div[@class='cart_item_label']/div[@class='item_pricebar']/div"));
        String actualValue = ele.getText ().trim ();
        Assert.assertEquals (expectedPrice,actualValue,"Validate price of added item");
    }

    public void validateRemoveBtn(){
        WebElement ele = driver.findElement (By.xpath ("//div[@class='cart_list']//div[@class='cart_item_label']/div[@class='item_pricebar']/button"));
        ele.click ();
    }

    public void clickOnCheckoutBtn(){
       WebElement checkoutEle =  driver.findElement (By.xpath ("//button[@id='checkout']"));
       checkoutEle.click ();
    }

    public void inputCustomerDetails(List<String> list){
        WebElement firstNameEle = driver.findElement (By.xpath ("//input[@id='first-name']"));
        WebElement lastNameEle = driver.findElement (By.xpath ("//input[@id='last-name']"));
        WebElement zipEle = driver.findElement (By.xpath ("//input[@id='postal-code']"));

        List<WebElement> listOfEle = List.of (new WebElement[]{firstNameEle , lastNameEle , zipEle});
        for (int i = 0; i < list.size (); i++) {
            System.out.println ("Input values in textbox for user information : " + list.get (i) + " for field " + listOfEle.get (i).getAttribute ("placeholder"));
            listOfEle.get (i).sendKeys (list.get (i));
        }
    }

    public void clickOnContinueBtn(){
        WebElement ele = driver.findElement (By.xpath ("//input[@id='continue']"));
        ele.click ();
    }

    public void clickONCancelButton(){
        WebElement ele = driver.findElement (By.xpath ("//button[@id='cancel']"));
        ele.click ();
    }

    public void clickOnFinishButton(){
        WebElement ele = driver.findElement (By.xpath ("//button[@id='finish']"));
        ele.click ();
    }

    public void validateOrderSuccessMsg(String expectedMsg){
        WebElement ele = driver.findElement (By.xpath ("//h2[contains(text(),'Thank you for your order!')]"));
        String actualMsg = ele.getText ().trim ();
        Assert.assertEquals (actualMsg,expectedMsg,"Validate success message");
    }

    public void clickOnHomeLink(){
        WebElement ele = driver.findElement (By.xpath ("//button[@id='back-to-products']"));
        ele.click ();
    }
}
