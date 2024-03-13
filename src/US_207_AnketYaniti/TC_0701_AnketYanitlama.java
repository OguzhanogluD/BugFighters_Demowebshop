package US_207_AnketYaniti;

import Utility.BaseDriver;
import Utility.MyFunc;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class TC_0701_AnketYanitlama extends BaseDriver {

    @Test
    public void test7()  {

        driver.get("https://demowebshop.tricentis.com/");
        wait.until(ExpectedConditions.urlToBe("https://demowebshop.tricentis.com/"));

        WebElement loginLink = driver.findElement(By.xpath("//*[text()='Log in']"));
        Actions aksiyonlar = new Actions(driver);

        Action aksiyon = aksiyonlar.moveToElement(loginLink).click().build();
        MyFunc.Bekle(2);
        aksiyon.perform();

        WebElement email = driver.findElement(By.xpath("//input[@id='Email']"));
        MyFunc.Bekle(2);

        new Actions(driver)
                .moveToElement(email)
                .click()
                .sendKeys("bugfighter123456@gmail.com")
                .build()
                .perform();

        WebElement password = driver.findElement(By.xpath("//input[@id='Password']"));
        MyFunc.Bekle(2);

        new Actions(driver)
                .moveToElement(password)
                .click()
                .sendKeys("asdfgh")
                .build()
                .perform();

        WebElement logginButton = driver.findElement(By.xpath("//*[@class='button-1 login-button']"));
        MyFunc.Bekle(2);

        new Actions(driver)
                .moveToElement(logginButton)
                .click()
                .build()
                .perform();

        WebElement anketAnswer=driver.findElement(By.cssSelector("[id='pollanswers-1']"));
        MyFunc.Bekle(2);

        new Actions(driver)
                .moveToElement(anketAnswer)
                .click()
                .sendKeys("Excellent")
                .build()
                .perform();


        WebElement cevapButton=driver.findElement(By.cssSelector("[id='vote-poll-1']"));
        cevapButton.click();
        MyFunc.Bekle(3);

        driver.get("https://demowebshop.tricentis.com/");
        WebElement logOut = driver.findElement(By.cssSelector("[class='ico-logout']"));
        Action aksiyon2 = aksiyonlar.moveToElement(logOut).click().build();
        wait.until(ExpectedConditions.visibilityOf(logOut));
        aksiyon2.perform();

        MyFunc.Bekle(3);

        WebElement anketAnswerKayitsiz=driver.findElement(By.cssSelector("[id='pollanswers-1']"));
        MyFunc.Bekle(2);

        new Actions(driver)
                .moveToElement(anketAnswerKayitsiz)
                .click()
                .sendKeys("Excellent")
                .build()
                .perform();

        WebElement vetoButton=driver.findElement(By.cssSelector("input[id='vote-poll-1']"));
        vetoButton.click();
        MyFunc.Bekle(2);



        BekleKapat();

    }
}
