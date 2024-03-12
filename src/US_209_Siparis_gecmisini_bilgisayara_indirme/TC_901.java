package US_209_Siparis_gecmisini_bilgisayara_indirme;

import Utility.BaseDriver;
import Utility.MyFunc;
import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Iterator;
import java.util.Set;

public class TC_901 extends BaseDriver {
    @Test
    public void test9() throws AWTException, IOException {
        //Step 1. Open the web browser and navigate to "Demowebshop.tricentis.com".
        driver.get("https://demowebshop.tricentis.com/");
        wait.until(ExpectedConditions.urlToBe("https://demowebshop.tricentis.com/"));
        //Step 2. If the user session is not open, log in (login).
        WebElement loginLink= driver.findElement(By.xpath("//*[text()='Log in']"));
        Actions aksiyonlar=new Actions(driver); //// web sayfası aksiyonlara açıldı.

        Action aksiyon= aksiyonlar.moveToElement(loginLink).click().build();
        MyFunc.Bekle(3);
        aksiyon.perform();

        WebElement email= driver.findElement(By.xpath("//input[@id='Email']"));
        MyFunc.Bekle(3);

        new Actions(driver)
                .moveToElement(email)
                .click()
                .sendKeys("bugfighter123456@gmail.com")
                .build()
                .perform();

        WebElement password= driver.findElement(By.xpath("//input[@id='Password']"));
        MyFunc.Bekle(3);

        new Actions(driver)
                .moveToElement(password)
                .click()
                .sendKeys("asdfgh")
                .build()
                .perform();

        WebElement logginButton= driver.findElement(By.xpath("//*[@class='button-1 login-button']"));
        MyFunc.Bekle(3);

        new Actions(driver)
                .moveToElement(logginButton)
                .click()
                .build()
                .perform();

        //Step 3. Navigate to the "My Account" page by clicking on your username or e-mail address on the homepage.
        WebElement myAccount= driver.findElement(By.xpath("(//*[@class='account'])[1]"));
        MyFunc.Bekle(3);

        new Actions(driver)
                .moveToElement(myAccount)
                .click()
                .build()
                .perform();
        //Step 4. View your orders by clicking on the "Orders" (Orders) link.
        WebElement orders= driver.findElement(By.xpath("(//*[@href='/customer/orders'])[1]"));
        MyFunc.Bekle(3);

        new Actions(driver)
                .moveToElement(orders)
                .click()
                .build()
                .perform();



        //Step 5. Click the "Details" link of the order (or Enson order) you want to view.
        WebElement firstOrder= driver.findElement(By.xpath("(//*[@class='button-2 order-details-button'])[1]"));
        MyFunc.Bekle(3);  // input[value='Details'][type="button"] bu locatordan tum siparisleri print ve fotograf cekecek

        new Actions(driver)
                .moveToElement(firstOrder)
                .click()
                .build()
                .perform();


        //Step 6. Download and view the invoice by clicking on the PDF Invoice link.
        WebElement pdfInvoice= driver.findElement(By.xpath("//*[text()='PDF Invoice']"));
        MyFunc.Bekle(3);

        new Actions(driver)
                .moveToElement(pdfInvoice)
                .click()
                .build()
                .perform();

        //Step 7. View the invoice by clicking on the PDF Invoice link.
        WebElement printInvoice= driver.findElement(By.xpath("//*[text()='Print']"));
        MyFunc.Bekle(2);

        new Actions(driver)
                .moveToElement(printInvoice)
                .click()
                .build()
                .perform();
        MyFunc.Bekle(1);

        Set<String> idler = driver.getWindowHandles();

        Iterator<String> gosterge = idler.iterator();
        String birinciSekmeID = gosterge.next().toString();
        String ikinciSekmeID = gosterge.next().toString();
        MyFunc.Bekle(1);

        driver.switchTo().window(ikinciSekmeID);

        Robot robot=new Robot();
        robot.keyPress(KeyEvent.VK_TAB);
        MyFunc.Bekle(1);
        robot.keyRelease(KeyEvent.VK_TAB);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        MyFunc.Bekle(1);

        // Step 8 : Screenshot ( ekranı kaydet )
        TakesScreenshot ts = (TakesScreenshot) driver; // aynı js gibi
        File hafizadakiHali = ts.getScreenshotAs(OutputType.FILE);  // ekran kaydı aldı dosya
        // formatında ama hafızada duruyor

        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy_MM_dd_HH_mm_ss");
        String formatted = now.format(dateTimeFormatter);

        // Dosya adı oluşturma
        String dosyaAdi = "ekranGoruntuleri\\screenshot" + formatted + ".jpg";

        //Şu anda hafızadaki görüntüyü dosya olarak kaydetti.
        FileUtils.copyFile(hafizadakiHali, new File(dosyaAdi));

        BekleKapat();
    }
}


