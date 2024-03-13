package US_206_Ordering_Siparis_Verme;


import Utility.BaseDriver;
import Utility.MyFunc;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.List;

public class TC_0601_Ordering extends BaseDriver {

    @Test
    public void TC_0601() throws AWTException {

        //1. Web tarayıcısını açın ve "https://demowebshop.tricentis.com/" adresine gidin.
//        driver.switchTo().newWindow(WindowType.WINDOW);
//        MyFunc.Bekle(1);
        driver.get("https://demowebshop.tricentis.com/");
        MyFunc.Bekle(1);

        Robot robot = new Robot();
        Actions driverAksiyon = new Actions(driver);
        JavascriptExecutor jse = (JavascriptExecutor) driver;

        //2. Eğer kullanıcı oturumu açık değilse, oturum açın (giriş yapın).

        WebElement loginHomePage = driver.findElement(By.xpath("(//div[@class='header-links']//a)[2]"));

        Action aksiyon1 = driverAksiyon.moveToElement(loginHomePage).click().build();
        wait.until(ExpectedConditions.visibilityOf(loginHomePage));
        aksiyon1.perform();

        WebElement eMail = driver.findElement(By.xpath("(//div[@class='inputs'])[1]//input"));
        Action aksiyon2 = driverAksiyon.click(eMail).sendKeys("bugfighter123456@gmail.com").build();
        wait.until(ExpectedConditions.elementToBeClickable(eMail));
        aksiyon2.perform();

        WebElement password = driver.findElement(By.xpath("(//div[@class='inputs'])[2]//input"));
        Action aksiyon3 = driverAksiyon.click(password).sendKeys("asdfgh").build();
        wait.until(ExpectedConditions.elementToBeClickable(eMail));
        aksiyon3.perform();

        WebElement loginPageLogin = driver.findElement(By.cssSelector("input[type='submit'][value='Log in']"));
        new Actions(driver).moveToElement(loginPageLogin).click().build().perform();

        // Adres Sıfırlama

        WebElement adress = driver.findElement(By.xpath("(((//div[@class='footer']/div)[1]/div)[3]//li)[3]/a"));
        jse.executeScript("arguments[0].click();", adress);

        wait.until(ExpectedConditions.urlToBe("https://demowebshop.tricentis.com/customer/addresses"));

        WebElement deleteAdress = driver.findElement(By.cssSelector("input[value='Delete']"));
        driverAksiyon.moveToElement(deleteAdress).click().build().perform();
        wait.until(ExpectedConditions.alertIsPresent());
        //MyFunc.Bekle(10);
        driver.switchTo().alert().accept();
        MyFunc.Bekle(20);
        // sayfadaki tüm elementler yüklenene kadar bekle için kendine locatorlar bul
        driver.navigate().refresh();
        MyFunc.Bekle(20);
        //driver.navigate().back();
        MyFunc.Bekle(10);

        WebElement headerLogo = driver.findElement(By.xpath("//div[@class='header-logo']/a"));
        Action aksiyon29 = driverAksiyon.moveToElement(headerLogo).click().build();
        wait.until(ExpectedConditions.visibilityOf(headerLogo));
        aksiyon29.perform();

        // Adres Sıfırlama Bitiş

        // 3. Anasayfada "Computers" menüsünden "Notebook" altındaki "14.1-inch Laptop" ürününe tıklayın.
        wait.until(ExpectedConditions.urlToBe("https://demowebshop.tricentis.com/"));

        WebElement computer = driver.findElement(By.xpath("((//div[@class='listbox'])[1]//li)[2]/a"));
        Action aksiyon4 = driverAksiyon.moveToElement(computer).click().build();
        wait.until(ExpectedConditions.titleContains("Web Shop"));
        aksiyon4.perform();

        WebElement notebooks = driver.findElement(By.xpath("(//h2[@class='title'])[2]/a"));
        Action aksiyon5 = driverAksiyon.click(notebooks).build();
        wait.until(ExpectedConditions.urlToBe("https://demowebshop.tricentis.com/computers"));
        aksiyon5.perform();

        WebElement laptop = driver.findElement(By.xpath("(//div[@class='item-box']//a)[2]"));
        Action aksiyon6 = driverAksiyon.moveToElement(laptop).click().build();
        String titleIs = driver.getTitle();
        //System.out.println(titleIs);
        wait.until(ExpectedConditions.titleIs(titleIs));
        aksiyon6.perform();

        // 4. Ürün sayfasında "Add to Cart" (Sepete Ekle) düğmesine tıklayarak ürünü sepete ekleyin.

        WebElement addToCart = driver.findElement(By.xpath("//div[@class='add-to-cart']//input[2]"));
        Action aksiyon7 = driverAksiyon.click(addToCart).build();
        wait.until(ExpectedConditions.urlContains("141-inch-laptop"));
        aksiyon7.perform();

        // 5. Sepetinize gitmek için "Shopping Cart" (Alışveriş Sepeti) düğmesine tıklayın.

        WebElement shoppingCart = driver.findElement(By.xpath("//li[@id='topcartlink']/a//span[1]"));
        Action aksiyon8 = driverAksiyon.moveToElement(shoppingCart).click().build();
        wait.until(ExpectedConditions.textToBe(By.xpath("//li[@id='topcartlink']/a//span[1]"), "Shopping cart"));
        aksiyon8.perform();

        //6. Kargo detayları için gerekli bilgileri doldurun:
        wait.until(ExpectedConditions.urlContains("cart"));

        WebElement country = driver.findElement(By.cssSelector("select[id='CountryId']"));
//        Action aksiyon9 = driverAksiyon.moveToElement(country).click().build();
//
//        aksiyon9.perform();
        wait.until(ExpectedConditions.elementToBeClickable(country));
        Select countrySelect = new Select(country);
        countrySelect.selectByValue("1");

        WebElement state = driver.findElement(By.cssSelector("select[id='StateProvinceId']"));
        wait.until(ExpectedConditions.elementToBeClickable(state));
        Select stateSelect = new Select(state);
        stateSelect.selectByValue("39");

        WebElement postalCode = driver.findElement(By.id("ZipPostalCode"));
        Action aksiyon10 = driverAksiyon.moveToElement(postalCode).click().sendKeys("87105").build();
        wait.until(ExpectedConditions.visibilityOf(postalCode));
        aksiyon10.perform();

        // 7. Ülke ve Eyalet seçin.
        WebElement shipping = driver.findElement(By.name("estimateshipping"));
        Action aksiyon11 = driverAksiyon.click(shipping).build();
        wait.until(ExpectedConditions.elementToBeClickable(shipping));
        aksiyon11.perform();

        WebElement shippinInfo = driver.findElement(By.xpath("(//strong[@class='option-name'])[2]"));
        wait.until(ExpectedConditions.visibilityOf(shippinInfo));
        String info = shippinInfo.getText();
        //System.out.println(info);

        Assert.assertEquals(info, "Next Day Air (0.00)");

        // 8. Şartları kabul edin.
        WebElement radioCheck = driver.findElement(By.cssSelector("input[id='termsofservice']"));
        String agreeText = radioCheck.getText();
        Action aksiyon12 = driverAksiyon.click(radioCheck).build();
        wait.until(ExpectedConditions.textToBe(By.cssSelector("input[id='termsofservice']"), agreeText));
        aksiyon12.perform();

        // 9. "Checkout" (Ödeme) düğmesine tıklayarak ödeme sayfasına gidin.
        WebElement checkOut = driver.findElement(By.cssSelector("button[id='checkout'][name='checkout']"));
        Action aksiyon13 = driverAksiyon.moveToElement(checkOut).click().build();
        wait.until(ExpectedConditions.elementToBeClickable(checkOut));
        aksiyon13.perform();

        // 10. Ödeme bilgilerini doldurun ve siparişi onaylayın.
        wait.until(ExpectedConditions.urlToBe("https://demowebshop.tricentis.com/onepagecheckout"));

        WebElement company = driver.findElement(By.xpath("(//div[@class='edit-address']/div)[4]/input"));
        driverAksiyon.moveToElement(company).click().sendKeys("Los Pollos Hermanos").build().perform();

        WebElement country2 = driver.findElement(By.xpath("(//select[starts-with(@id,'Billing')])[1]"));
        Select selectCountry = new Select(country2);
        selectCountry.selectByVisibleText("United States");

        WebElement province = driver.findElement(By.xpath("(//select[starts-with(@id,'Billing')])[2]"));
        wait.until(ExpectedConditions.visibilityOf(province));
        Select selectProvince = new Select(province);
        selectProvince.selectByVisibleText("New Mexico");

        WebElement city = driver.findElement(By.xpath("(//div[@class='edit-address']/div)[7]//input"));
        Action aksiyon14 = driverAksiyon.moveToElement(city).click().sendKeys("Albuquerque").build();
        wait.until(ExpectedConditions.elementToBeClickable(city));
        aksiyon14.perform();

        WebElement address1 = driver.findElement(By.xpath("(//div[@class='edit-address']/div)[8]//input"));
        Action aksiyon15 = driverAksiyon.click(address1).sendKeys("4275 Isleta Blvd SW").build();
        wait.until(ExpectedConditions.visibilityOf(address1));
        aksiyon15.perform();

        WebElement address2 = driver.findElement(By.xpath("(//div[@class='edit-address']/div)[9]//input"));
        Action aksiyon16 = driverAksiyon.moveToElement(address2).click().sendKeys("Albuquerque").build();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@class='edit-address']/div)[9]//input")));
        aksiyon16.perform();

        WebElement zipCode = driver.findElement(By.xpath("(//div[@class='edit-address']/div)[10]//input"));
        Action aksiyon17 = driverAksiyon.click(zipCode).sendKeys("NM 87105").build();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@class='edit-address']/div)[10]//input")));
        aksiyon17.perform();

        WebElement phoneNumber = driver.findElement(By.xpath("(//div[@class='edit-address']/div)[11]//input"));
        Action aksiyon18 = driverAksiyon.moveToElement(phoneNumber).click().sendKeys("+1 (505) 146-0195").build();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@class='edit-address']/div)[11]//input")));
        aksiyon18.perform();

        WebElement buttonContiune = driver.findElement(By.xpath("(//input[@title='Continue'])[1]"));
        driverAksiyon.click(buttonContiune).build().perform();

        WebElement inStore = driver.findElement(By.xpath("(//div[@id='checkout-step-shipping']//p)[1]//label"));
        wait.until(ExpectedConditions.visibilityOf(inStore));
        String inStoreText = inStore.getText();
        //System.out.println(inStoreText);

        Assert.assertEquals(inStoreText, "In-Store Pickup");

        WebElement inStoreRadio = driver.findElement(By.cssSelector("input[id='PickUpInStore']"));
        Action aksiyon19 = driverAksiyon.moveToElement(inStoreRadio).click().build();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[id='PickUpInStore']")));
        aksiyon19.perform();

        WebElement btnContinue = driver.findElement(By.cssSelector("div[id='shipping-buttons-container'] input"));
        driverAksiyon.click(btnContinue).build().perform();

        WebElement paymentMethodtext = driver.findElement(By.xpath("(//div[@class='step-title'])[4]/h2"));
        wait.until(ExpectedConditions.visibilityOf(paymentMethodtext));
        String paymentText = paymentMethodtext.getText();
        //System.out.println(paymentText);

        Assert.assertEquals(paymentText, "Payment Method");
        //MyFunc.Bekle(1);
        WebElement creditCardRadio = driver.findElement(By.xpath("((//ul[@class='method-list']/li)[3]//label)[2]"));
        Action aksiyon28 = driverAksiyon.moveToElement(creditCardRadio).click().build();
        wait.until(ExpectedConditions.visibilityOf(creditCardRadio));
        MyFunc.Bekle(1);
        aksiyon28.perform();

        WebElement buttonContinue = driver.findElement(By.cssSelector("div[id='payment-method-buttons-container'] input"));
        Action aksiyon20 = driverAksiyon.moveToElement(buttonContinue).click().build();
        wait.until(ExpectedConditions.elementToBeClickable(buttonContinue));
        aksiyon20.perform();

        WebElement paymentInfoText = driver.findElement(By.xpath("(//div[@class='step-title'])[5]/h2"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@class='step-title'])[5]/h2")));
        String paymentInformationText = paymentInfoText.getText();
        //System.out.println(paymentInformationText);

        Assert.assertEquals(paymentInformationText, "Payment Information");

        WebElement creditCartButton = driver.findElement(By.cssSelector("[id='CreditCardType']"));
        Select creditCartSelect = new Select(creditCartButton);
        creditCartSelect.selectByValue("Visa");

        WebElement cardHolderName = driver.findElement(By.cssSelector("input[id='CardholderName'][name='CardholderName']"));
        Action aksiyon25 = driverAksiyon.moveToElement(cardHolderName).click().sendKeys("Osman Kamil").build();
        wait.until(ExpectedConditions.elementToBeClickable(cardHolderName));
        aksiyon25.perform();

        WebElement cardNumber = driver.findElement(By.cssSelector("input[id='CardNumber']"));
        Action aksiyon26 = driverAksiyon.moveToElement(cardNumber).click().sendKeys("4242 4242 4242 4242").build();
        wait.until(ExpectedConditions.elementToBeClickable(cardNumber));
        aksiyon26.perform();

        WebElement expireMonth = driver.findElement(By.cssSelector("[id='ExpireMonth']"));
        Select monthSelect = new Select(expireMonth);
        monthSelect.selectByValue("1");

        WebElement expireYear = driver.findElement(By.cssSelector("[id='ExpireYear']"));
        Select yearSelect = new Select(expireYear);
        yearSelect.selectByValue("2032");

        WebElement cardCode = driver.findElement(By.cssSelector("[id='CardCode']"));
        Action aksiyon27 = driverAksiyon.click(cardCode).sendKeys("123").build();
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[id='CardCode']")));
        aksiyon27.perform();


        WebElement paymentInfoContinueButton = driver.findElement(By.cssSelector("div[id='payment-info-buttons-container'] input"));
        Action aksiyon21 = driverAksiyon.click(paymentInfoContinueButton).build();
        wait.until(ExpectedConditions.elementToBeClickable(paymentInfoContinueButton));
        aksiyon21.perform();

        WebElement confirmOrderText = driver.findElement(By.xpath("(//div[@class='step-title'])[6]/h2"));
        wait.until(ExpectedConditions.visibilityOf(confirmOrderText));
        String orderText = confirmOrderText.getText();
        //System.out.println(orderText);

        Assert.assertEquals(orderText, "Confirm Order");

        WebElement orderButton = driver.findElement(By.cssSelector("div[id='confirm-order-buttons-container'] input"));
        Action aksiyon22 = driverAksiyon.moveToElement(orderButton).click().build();
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div[id='confirm-order-buttons-container'] input")));
        aksiyon22.perform();

        // 11. "Siparişiniz başarıyla işleme alındı" ("Your order has been successfully processed!" ) mesajının görüntülendiğini doğrulayın.

        wait.until(ExpectedConditions.urlToBe("https://demowebshop.tricentis.com/checkout/completed/"));

        WebElement orderCompleted = driver.findElement(By.cssSelector("[class='title'] strong"));
        String orderCompletedText = orderCompleted.getText();
        //System.out.println(orderCompletedText);

        Assert.assertEquals(orderCompletedText, "Your order has been successfully processed!");

        WebElement orderNumber = driver.findElement(By.xpath("(//ul[@class='details']//li)[1]"));
        String orderNo = orderNumber.getText();
        //System.out.println(orderNo);

        for (int i = 0; i < 48; i++) {
            robot.keyPress(KeyEvent.VK_TAB);
            MyFunc.Bekle(1);
            robot.keyRelease(KeyEvent.VK_TAB);
        }

        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        MyFunc.Bekle(2);

        WebElement orderCompletedContinueButton = driver.findElement(By.cssSelector("div[class='buttons'] input"));
        Action aksiyon23 = driverAksiyon.click(orderCompletedContinueButton).build();
        wait.until(ExpectedConditions.elementToBeClickable(orderCompletedContinueButton));
        aksiyon23.perform();

        // 12. Sipariş numarasının ana sayfadaki Orders linkinde de var olduğunu doğrulayın. [mesela : Order #1499948]

        WebElement myAccountFoot = driver.findElement(By.xpath("(//a[@class='account'])[2]"));
        jse.executeScript("arguments[0].click();", myAccountFoot);

        WebElement orders = driver.findElement(By.xpath("(//div[@class='listbox']//li)[3]/a"));
        Action aksiyon24 = driverAksiyon.click(orders).build();
        wait.until(ExpectedConditions.urlToBe("https://demowebshop.tricentis.com/customer/info"));
        aksiyon24.perform();

        List<WebElement> ordersNumber = driver.findElements(By.xpath("//div[@class='order-list']//div//div[@class='title']/strong"));

        for (WebElement order : ordersNumber) {
            //System.out.println(order.getText());
            if (order.getText().equalsIgnoreCase(orderNo)) {
                System.out.println(order.getText() + " Sipariş Başarıyla Oluşturulmuştur");
            }
        }
        BekleKapat();
    }
}


//        WebElement adress = driver.findElement(By.xpath("(((//div[@class='footer']/div)[1]/div)[3]//li)[3]/a"));
//        jse.executeScript("arguments[0].click();", adress);

//        wait.until(ExpectedConditions.urlToBe("https://demowebshop.tricentis.com/customer/addresses"));

//        WebElement noAdress = driver.findElement(By.cssSelector("div[class='address-list']"));
//        String noAdressText = noAdress.getText();
//        System.out.println(noAdressText);

//      if (noAdressText.equalsIgnoreCase("No addresses")) {
//            driverAksiyon.click(headerLogo).build().perform();
//            System.out.println("Ana Sayfa");
//
//        }
//        WebElement headerLogo = driver.findElement(By.xpath("//div[@class='header-logo']/a"));
//        WebElement deleteAdress = driver.findElement(By.cssSelector("input[value='Delete']"));
//
//
//        if (deleteAdress.isDisplayed()) {
//            driverAksiyon.moveToElement(deleteAdress).click().build().perform();
//            wait.until(ExpectedConditions.alertIsPresent());
//            //MyFunc.Bekle(10);
//            driver.switchTo().alert().accept();
//            //MyFunc.Bekle(10);
//            //driverAksiyon.moveToElement(headerLogo).doubleClick().build();
//            //headerLogo.click();
//            System.out.println("silme");
//        }
//
//        Action aksiyon29=driverAksiyon.moveToElement(headerLogo).click().build();
//        wait.until(ExpectedConditions.visibilityOf(headerLogo));
//        aksiyon29.perform();
//


//        WebElement newMexico = driver.findElement(By.xpath("(//option[@value='38'])[2]"));
//        wait.until(ExpectedConditions.elementToBeSelected(newMexico));
//        String clickNewMexico = newMexico.getText();
//        System.out.println(clickNewMexico);
