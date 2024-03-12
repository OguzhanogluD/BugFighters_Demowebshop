package US_203_Cikis_Logout;

import Utility.BaseDriver;
import Utility.MyFunc;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.junit.Test;

public class TC_0301_Logout extends BaseDriver {
    @Test
    public void Logout() {
        driver.get("https://demowebshop.tricentis.com/");
        Actions driverAksiyon = new Actions(driver);
        WebElement Login = driver.findElement(By.xpath("//a[text()='Log in']")); //a[text()='Log in']
        Action aksiyon1 = driverAksiyon.moveToElement(Login).click().build();
        aksiyon1.perform();
        WebElement Email = driver.findElement(By.cssSelector("input[id='Email']"));
        Action aksiyon2 = driverAksiyon.moveToElement(Email).click().sendKeys("bugfighter123456@gmail.com").build();
        aksiyon2.perform();
        WebElement Password = driver.findElement(By.cssSelector("input[id='Password']"));
        Action aksiyon3 = driverAksiyon.moveToElement(Password).click().sendKeys("asdfgh").build();
        wait.until(ExpectedConditions.visibilityOf(Password));
        aksiyon3.perform();
        WebElement LoginBtn = driver.findElement(By.cssSelector("input[class='button-1 login-button']"));
        LoginBtn.click();
        driver.get("https://demowebshop.tricentis.com/");
        WebElement logOut = driver.findElement(By.cssSelector("[class='ico-logout']"));
        Action aksiyon4 = driverAksiyon.moveToElement(logOut).click().build();
        wait.until(ExpectedConditions.visibilityOf(logOut));
        aksiyon4.perform();

    }
}
