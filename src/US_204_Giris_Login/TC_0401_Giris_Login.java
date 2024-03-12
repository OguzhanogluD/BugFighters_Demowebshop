package US_204_Giris_Login;

import Utility.BaseDriver;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class TC_0401_Giris_Login extends BaseDriver {
    @Test
    public void Test(){
        driver.get("https://demowebshop.tricentis.com/");
        WebElement loginbutton= driver.findElement(By.className("ico-login"));
        loginbutton.click();

        WebElement email=driver.findElement(By.id("Email"));
        email.sendKeys("bugfighter123456@gmail.com");

        WebElement password= driver.findElement(By.id("Password"));
        password.sendKeys("asdfgh");

        WebElement loginbutton2= driver.findElement(By.cssSelector("input[class='button-1 login-button']"));
        wait.until(ExpectedConditions.elementToBeClickable(loginbutton2));

        Actions aksiyonlar=new Actions(driver); //web sayfasi aksiyonlara acildi
        Action aksiyon=aksiyonlar.moveToElement(loginbutton2).click().build();
        aksiyon.perform();

        WebElement logout= driver.findElement(By.linkText("Log out"));
        Assert.assertTrue("Giris yapilamadi",logout.isEnabled());

        BekleKapat();

    }

}
