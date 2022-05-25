package day13_cookies_webTables;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.util.List;

public class C03_WebTables extends TestBase {

    @Test
    public void dinamikYazici() {
        girisYap();

        // onceki class daki adrese gidip
// girisYap() kullanarak sayfaya giris yapin
        C02 obj = new C02();

// input olarak verilen satir sayisi ve sutun sayisina sahip
        int satir = 4;
        int sutun = 4;

        List<WebElement> xyinput = driver.findElements(By.xpath("//tbody//tr[" + satir + "]//td[" + sutun + "]"));

// cell deki text i yazdirin
    }

    public void girisYap() {
        driver.get("https://www.hotelmycamp.com");
        driver.findElement(By.linkText("Log in")).click();
        Actions actions = new Actions(driver);
        WebElement username = driver.findElement(By.id("UserName"));
        actions.click(username).
                sendKeys("manager").
                sendKeys(Keys.TAB).
                sendKeys("Manager1!").
                sendKeys(Keys.ENTER).
                perform();

    }
}