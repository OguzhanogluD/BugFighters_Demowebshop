package US_208_Negatif_Hediye_Karti_Ve_Kuponu_Kulanimi;

import Utility.BaseDriver;
import Utility.MyFunc;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.awt.*;
import java.awt.event.KeyEvent;


public class TC_0801_Kupon_Hediye_Karti_Negatif extends BaseDriver {

    @Test
    public void Test8() throws AWTException {
        driver.get("https://demowebshop.tricentis.com");
        WebElement login= driver.findElement(By.xpath("//a[@class='ico-login']"));

        Actions aksiyonDriver=new Actions(driver);

        Action aksiyon1=aksiyonDriver.moveToElement(login).click().build();
        aksiyon1.perform();

        WebElement email= driver.findElement(By.xpath("//div[@class='form-fields']//input[@class='email']"));
        Action aksiyon2=aksiyonDriver.moveToElement(email).sendKeys("bugfighter123456@gmail.com").build();
        wait.until(ExpectedConditions.visibilityOf(email));
        aksiyon2.perform();

        WebElement password= driver.findElement(By.xpath("//div[@class='form-fields']//input[@class='password']"));
        Action aksiyon3=aksiyonDriver.moveToElement(password).click().sendKeys("asdfgh").build();
        wait.until(ExpectedConditions.visibilityOf(password));
        aksiyon3.perform();

        WebElement loginBtn=driver.findElement(By.xpath("//div[@class='form-fields']//input[@value='Log in']"));
        Action aksiyon4=aksiyonDriver.moveToElement(loginBtn).click().build();
        wait.until(ExpectedConditions.visibilityOf(loginBtn));
        aksiyon4.perform();

        WebElement computers=driver.findElement(By.xpath("//div[@class='header-menu']//li[2][1]//a[1]"));
        Action aksiyon5=aksiyonDriver.moveToElement(computers).build();
        wait.until(ExpectedConditions.visibilityOf(computers));
        aksiyon5.perform();

        WebElement noteBooks=driver.findElement(By.xpath("/html[1]/body[1]/div[4]/div[1]/div[2]/ul[1]/li[2]/ul[1]/li[2]/a[1]"));
        Action aksiyon6=aksiyonDriver.moveToElement(noteBooks).click().build();
        wait.until(ExpectedConditions.elementToBeClickable(noteBooks));
        aksiyon6.perform();

        WebElement addToCart= driver.findElement(By.xpath("//div[@class='item-box']//input[@value='Add to cart']"));
        Action aksiyon7=aksiyonDriver.moveToElement(addToCart).click().build();
        wait.until(ExpectedConditions.elementToBeClickable(addToCart));
        aksiyon7.perform();

        WebElement shoppingCart=driver.findElement(By.xpath("(//div[@class='header-links-wrapper']//span[@class='cart-label'])[1]"));
        Action aksiyon8=aksiyonDriver.moveToElement(shoppingCart).click().build();
        wait.until(ExpectedConditions.elementToBeClickable(shoppingCart));
        aksiyon8.perform();

        WebElement applyCoupons=driver.findElement(By.xpath("(//div[@class='cart-footer']//input)[2]"));
        Action aksiyon9=aksiyonDriver.moveToElement(applyCoupons).click().build();
        wait.until(ExpectedConditions.elementToBeClickable(applyCoupons));
        aksiyon9.perform();

        WebElement message1Apply=driver.findElement(By.xpath("//div[@class='cart-footer']//div[@class='message']"));
        Action aksiyon10=aksiyonDriver.moveToElement(message1Apply).build();
        wait.until(ExpectedConditions.visibilityOf(message1Apply));
        aksiyon10.perform();

        Assert.assertTrue ("Beklenen message ayni degil",message1Apply.isDisplayed());
        System.out.println("message1.getText() = " + message1Apply.getText());

        WebElement addGiftCard=driver.findElement(By.xpath("//div[@class='cart-footer']//input[@value='Add gift card']"));
        Action aksiyon11=aksiyonDriver.moveToElement(addGiftCard).click().build();
        wait.until(ExpectedConditions.elementToBeClickable(addGiftCard));
        aksiyon11.perform();

        WebElement message2Gift=driver.findElement(By.xpath("//div[@class='cart-footer']//div[@class='message']"));
        Action aksiyon12=aksiyonDriver.moveToElement(message2Gift).build();
        wait.until(ExpectedConditions.visibilityOf(message2Gift));
        aksiyon12.perform();

        Assert.assertTrue("Beklenen mesaj bulunamadi",message2Gift.isDisplayed());
        System.out.println("message2Gift.getText() = " + message2Gift.getText());

        WebElement country=driver.findElement(By.xpath("//div[@class='shipping-options']//select[@id='CountryId']"));
        Action aksiyon13=aksiyonDriver.moveToElement(country).click().build();
        wait.until(ExpectedConditions.visibilityOf(country));
        aksiyon13.perform();
        Select countryMenu=new Select(country);
        countryMenu.selectByValue("35");
        aksiyon13.perform();

        WebElement zipPostalCode=driver.findElement(By.xpath("//div[@class='shipping-options']//input[@id='ZipPostalCode']"));
        zipPostalCode.clear();
        Action aksiyon14=aksiyonDriver.moveToElement(zipPostalCode).click().sendKeys("10115").build();
        wait.until(ExpectedConditions.visibilityOf(zipPostalCode));
        aksiyon14.perform();

        WebElement checkBoxAgree=driver.findElement(By.xpath("//div[@class='totals'][1]//input[@id='termsofservice']"));
        Action aksiyon15=aksiyonDriver.moveToElement(checkBoxAgree).click().build();
        aksiyon15.perform();

        WebElement checkoutShopingCart=driver.findElement(By.xpath("//div[@class='totals'][1]//button[@id='checkout']"));
        Action aksiyon16=aksiyonDriver.moveToElement(checkoutShopingCart).click().build();
        wait.until(ExpectedConditions.elementToBeClickable(checkoutShopingCart));
        aksiyon16.perform();

        WebElement shippingAdress=driver.findElement(By.xpath("//select[@id='billing-address-select']"));
      //  Action aksiyon17=aksiyonDriver.moveToElement(selectAdress).click().build();
        wait.until(ExpectedConditions.visibilityOf(shippingAdress));
      //  aksiyon17.perform();
        Select adressMenu=new Select(shippingAdress);
        adressMenu.selectByVisibleText("New Address");
      //  aksiyon17.perform();

       // WebElement selectNewAdress=driver.findElement(By.xpath("//*[@id='billing-address-select']/option[2]"));
       // Action aksiyon18=aksiyonDriver.moveToElement(selectNewAdress).click().build();
       // wait.until(ExpectedConditions.elementToBeClickable(selectNewAdress));
       // //wait.until(ExpectedConditions.visibilityOf(selectNewAdress));
       // aksiyon18.perform();

        WebElement countryNew=driver.findElement(By.xpath("//select[@id='BillingNewAddress_CountryId']"));
       // Action aksiyon19=aksiyonDriver.moveToElement(countryNew).click().build();
        wait.until(ExpectedConditions.visibilityOf(countryNew));
       // aksiyon19.perform();
        Select countryMenuNew=new Select(countryNew);
        countryMenuNew.selectByValue("35");
       // aksiyon19.perform();

        WebElement cityInput=driver.findElement(By.xpath("//input[@id='BillingNewAddress_City']"));
        Action aksiyon20=aksiyonDriver.moveToElement(cityInput).click().sendKeys("Berlin").build();
        wait.until(ExpectedConditions.visibilityOf(cityInput));
        aksiyon20.perform();

        WebElement adressInput=driver.findElement(By.xpath("//input[@id='BillingNewAddress_Address1']"));
        Action aksiyon21=aksiyonDriver.moveToElement(adressInput).click().sendKeys("Hauptstr.21").build();
        wait.until(ExpectedConditions.visibilityOf(adressInput));
        aksiyon21.perform();

        WebElement zipPostalCodeNew=driver.findElement(By.xpath("//input[@id='BillingNewAddress_ZipPostalCode']"));
        Action aksiyon22=aksiyonDriver.moveToElement(zipPostalCodeNew).click().sendKeys("10115").build();
        wait.until(ExpectedConditions.visibilityOf(zipPostalCodeNew));
        aksiyon22.perform();

        WebElement phoneNr=driver.findElement(By.xpath("//input[@id='BillingNewAddress_PhoneNumber']"));
        Action aksiyon23=aksiyonDriver.moveToElement(phoneNr).click().sendKeys("+49176238349").build();
        wait.until(ExpectedConditions.visibilityOf(phoneNr));
        aksiyon23.perform();

        WebElement continue1=driver.findElement(By.xpath("//*[@id='billing-buttons-container']/input"));
        Action aksiyon24=aksiyonDriver.moveToElement(continue1).click().build();
        wait.until(ExpectedConditions.elementToBeClickable(continue1));
        aksiyon24.perform();

       WebElement shippingAdress2=driver.findElement(By.xpath("//select[@id='shipping-address-select']"));
       wait.until(ExpectedConditions.visibilityOf(shippingAdress2));
       Select adressMenu2=new Select(shippingAdress2);
       adressMenu2.selectByValue("3535250");

        Robot robot = new Robot();
        for (int i = 0; i < 36; i++) {
            robot.keyPress(KeyEvent.VK_TAB);
            MyFunc.Bekle(1);
            robot.keyRelease(KeyEvent.VK_TAB);
        }

        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        MyFunc.Bekle(2);

        WebElement continue2=driver.findElement(By.xpath("//*[@id='shipping-buttons-container']//input"));
        Action aksiyon25=aksiyonDriver.moveToElement(continue2).click().build();
        wait.until(ExpectedConditions.visibilityOf(continue2));
        aksiyon25.perform();

        WebElement continue3=driver.findElement(By.xpath("//*[@id='shipping-method-buttons-container']//input"));
        Action aksiyon26=aksiyonDriver.moveToElement(continue3).click().build();
        wait.until(ExpectedConditions.visibilityOf(continue3));
        aksiyon26.perform();

        WebElement continue4=driver.findElement(By.xpath("//div[@id='payment-method-buttons-container']//input"));
        Action aksiyon27=aksiyonDriver.moveToElement(continue4).click().build();
        wait.until(ExpectedConditions.visibilityOf(continue4));
        aksiyon27.perform();

        WebElement continue5=driver.findElement(By.xpath("//div[@id='payment-info-buttons-container']//input"));
        Action aksiyon28=aksiyonDriver.moveToElement(continue5).click().build();
        wait.until(ExpectedConditions.visibilityOf(continue5));
        aksiyon28.perform();

        WebElement confirm1=driver.findElement(By.xpath("//div[@id='confirm-order-buttons-container']//input"));
        Action aksiyon29=aksiyonDriver.moveToElement(confirm1).click().build();
        wait.until(ExpectedConditions.visibilityOf(confirm1));
        aksiyon29.perform();

        WebElement thankYou=driver.findElement(By.xpath("//html/body/div[4]/div[1]/div[4]/div/div/div[2]/div/div[1]"));

        Assert.assertTrue ("Beklenen message ayni degil",thankYou.getText().contains("Your order has been successfully processed!"));
        System.out.println("message1.getText() = " + thankYou.getText());

        BekleKapat();
    }
}
