package US_205_Negative_Login;

import Utility.BaseDriver;
import Utility.MyFunc;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class TC_0501_Login_Negative extends BaseDriver {
    @Test
    public void test1() {

        driver.get("https://demowebshop.tricentis.com/\n");
        MyFunc.Bekle(2);

        WebElement login = driver.findElement(By.linkText("Log in"));
        MyFunc.Bekle(2);
        login.click();
        // senaryo a: bos email,bos sifre.
        WebElement loginBtn = driver.findElement(By.xpath("//input[@class='button-1 login-button']"));
        Actions aksiyonlar = new Actions(driver);
        aksiyonlar.moveToElement(loginBtn).click().build().perform();
        //senaryo b : gecerli email, bos sifre
        MyFunc.Bekle(2);
        WebElement mail = driver.findElement(By.id("Email"));
        mail.sendKeys("demoproject633@gmail.com");
        MyFunc.Bekle(2);
        WebElement password = driver.findElement(By.id("Password"));
        password.sendKeys(" ");
        MyFunc.Bekle(3);
        WebElement loginBtn2 = driver.findElement(By.xpath("//input[@class='button-1 login-button']"));
        aksiyonlar.moveToElement(loginBtn2).click().build().perform();
        WebElement mail1 = driver.findElement(By.id("Email"));
        mail1.clear();
        MyFunc.Bekle(2);
        //senaryo c: bos email,gecerli sifre
        WebElement bosMail = driver.findElement(By.id("Email"));
        bosMail.sendKeys(" ");
        WebElement gecerliPassword = driver.findElement(By.id("Password"));
        gecerliPassword.sendKeys("demoshop1334 ");
        MyFunc.Bekle(3);

        WebElement loginBtn3 = driver.findElement(By.xpath("//input[@class='button-1 login-button']"));
        aksiyonlar.moveToElement(loginBtn3).click().build().perform();


        // senaryo d: gecersiz mail, gecersiz sifre
        WebElement gcrszMail = driver.findElement(By.id("Email"));
        gcrszMail.sendKeys("ddnsjscb@hmail.com");
        MyFunc.Bekle(2);

        WebElement gcrszPassword = driver.findElement(By.id("Password"));
        gcrszPassword.sendKeys("00000");
        WebElement loginBtn4 = driver.findElement(By.xpath("//input[@class='button-1 login-button']"));
        aksiyonlar.moveToElement(loginBtn4).click().build().perform();


        BekleKapat();


    }
}