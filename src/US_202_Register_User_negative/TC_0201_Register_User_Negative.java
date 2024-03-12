package US_202_Register_User_negative;

import Utility.BaseDriver;
import Utility.MyFunc;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class TC_0201_Register_User_Negative extends BaseDriver {

    @Test
    public void TC_2() {
        driver.get("https://demowebshop.tricentis.com/");
        MyFunc.Bekle(1);

        WebElement hesapAc= driver.findElement(By.partialLinkText("Register"));
        Actions aksiyonDriver=new Actions(driver);

        Action action1=aksiyonDriver.moveToElement(hesapAc).click().build();
        wait.until(ExpectedConditions.visibilityOf(hesapAc));
        action1.perform();
        wait.until(ExpectedConditions.urlContains("register"));

        WebElement femaleBtn= driver.findElement(By.xpath( "//input[@id='gender-female']"));
        Action action2=aksiyonDriver.moveToElement(femaleBtn).click().build();
        wait.until(ExpectedConditions.elementToBeClickable(femaleBtn));
        action2.perform();

        WebElement Firstname= driver.findElement(By.xpath("//input[@id='FirstName']"));
        MyFunc.Bekle(2);

        new Actions(driver)
                .moveToElement(Firstname)
                .click()
                .sendKeys("Bug")
                .build()
                .perform();

        WebElement Lastname= driver.findElement(By.xpath("//input[@id='LastName']"));
        MyFunc.Bekle(2);

        new Actions(driver)
                .moveToElement(Lastname)
                .click()
                .sendKeys("Fighter")
                .build()
                .perform();

        WebElement Email= driver.findElement(By.xpath("//input[@id='Email']"));
        MyFunc.Bekle(2);

        new Actions(driver)
                .moveToElement(Email)
                .click()
                .sendKeys("bugfighter123456@gmail.com")
                .build()
                .perform();


        WebElement Password= driver.findElement(By.xpath("//input[@id='Password']"));
        MyFunc.Bekle(2);

        new Actions(driver)
                .moveToElement(Password)
                .click()
                .sendKeys("asdfgh")
                .build()
                .perform();

        WebElement ConfirmPassword= driver.findElement(By.xpath("//input[@id='ConfirmPassword']"));
        MyFunc.Bekle(2);

        new Actions(driver)
                .moveToElement(ConfirmPassword)
                .click()
                .sendKeys("asdfgh")
                .build()
                .perform();

        WebElement registerbtn= driver.findElement(By.xpath("//input[@id='register-button']"));
        MyFunc.Bekle(2);

        new Actions(driver)
                .moveToElement(registerbtn)
                .click()
                .build()
                .perform();

        WebElement registertext = driver.findElement(By.xpath("(//div[@class='validation-summary-errors'])[1]//li"));
        Assert.assertTrue("e mail i dogru girdiniz", registertext.getText().equals("The specified email already exists"));

        BekleKapat();

    }
}
