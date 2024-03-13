package US_209;

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
import java.util.List;
import java.util.Set;

public class TC_902 extends BaseDriver {
    @Test
    public void test9() throws AWTException, IOException {
        //Step 1. Open the web browser and navigate to "Demowebshop.tricentis.com".
        driver.get("https://demowebshop.tricentis.com/");
        wait.until(ExpectedConditions.urlToBe("https://demowebshop.tricentis.com/"));

        Actions driverAksiyon = new Actions(driver);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        //Step 2. If the user session is not open, log in (login).

        WebElement loginLink = driver.findElement(By.xpath("//*[text()='Log in']"));
        Action aksiyon = driverAksiyon.moveToElement(loginLink).click().build();
        wait.until(ExpectedConditions.elementToBeClickable(loginLink));
        aksiyon.perform();

        WebElement email = driver.findElement(By.xpath("//input[@id='Email']"));
        wait.until(ExpectedConditions.visibilityOf(email));
        new Actions(driver).moveToElement(email).click().sendKeys("bugfighter123456@gmail.com").build().perform();

        WebElement password = driver.findElement(By.xpath("//input[@id='Password']"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='Password']")));
        new Actions(driver).moveToElement(password).click().sendKeys("asdfgh").build().perform();

        WebElement logginButton = driver.findElement(By.xpath("//*[@class='button-1 login-button']"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='button-1 login-button']")));
        new Actions(driver).moveToElement(logginButton).click().build().perform();

        //Step 3. Navigate to the "My Account" page by clicking on your username or e-mail address on the homepage.
        WebElement myAccount = driver.findElement(By.xpath("(//*[@class='account'])[1]"));
        wait.until(ExpectedConditions.elementToBeClickable(myAccount));
        new Actions(driver).moveToElement(myAccount).click().build().perform();

        //Step 4. View your orders by clicking on the "Orders" (Orders) link.
        WebElement orders = driver.findElement(By.xpath("(//*[@href='/customer/orders'])[1]"));
        wait.until(ExpectedConditions.visibilityOf(orders));
        new Actions(driver).moveToElement(orders).click().build().perform();

        List<WebElement> siparisler = driver.findElements(By.xpath("//input[@value='Details']"));
        WebElement textsiparis;

        wait.until(ExpectedConditions.urlToBe("https://demowebshop.tricentis.com/customer/orders"));


        for (int i = 0; i < siparisler.size(); i++) {
            MyFunc.Bekle(1);
            textsiparis = driver.findElement(By.xpath("(//input[@value='Details'])[" + (i + 1) + "]"));
            js.executeScript("arguments[0].click();", textsiparis);

            WebElement printInvoice = driver.findElement(By.xpath("//*[text()='Print']"));
            wait.until(ExpectedConditions.textToBe(By.xpath("//*[text()='Print']"), "Print"));

            new Actions(driver).moveToElement(printInvoice).click().build().perform();
            MyFunc.Bekle(1);

            Set<String> idler = driver.getWindowHandles();

            Iterator<String> gosterge = idler.iterator();
            String birinciSekmeID = gosterge.next().toString();
            String ikinciSekmeID = gosterge.next().toString();
            MyFunc.Bekle(1);

            driver.switchTo().window(ikinciSekmeID);

            Robot robot = new Robot();
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

            MyFunc.Bekle(5);

            driver.switchTo().window(birinciSekmeID);

            MyFunc.Bekle(2);

            WebElement ordersTik = driver.findElement(By.linkText("Orders"));
            js.executeScript("window.scrollTo(0, document.body.scrollHeight)");

            wait.until(ExpectedConditions.visibilityOf(ordersTik));
            js.executeScript("arguments[0].click();", ordersTik);

        }


        List<WebElement> siparisListesi = driver.findElements(By.xpath("//div[@class='order-list']//div//div/strong"));

        for (int i = 0; i < siparisListesi.size(); i++) {
            WebElement siparis = siparisListesi.get(i);
            String siparisMetni = siparis.getAttribute("innerText");
            if (siparisMetni != null) {
                System.out.println("Sipariş " + ": " + siparisMetni);
            } else {
                System.out.println("Sipariş " + (i + 1) + ": Metin içeriği bulunamadı.");
            }
        }

        BekleKapat();

    }
}





