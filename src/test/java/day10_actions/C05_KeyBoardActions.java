package day10_actions;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C05_KeyBoardActions extends TestBase {

    @Test
    public void keyboards() throws InterruptedException {

        driver.get("https://www.amazon.com");
        WebElement aramaKutusu=driver.findElement(By.id("twotabsearchtextbox"));
        Actions actions=new Actions(driver);
        actions.click(aramaKutusu).perform();
        actions.keyDown(Keys.SHIFT).perform(); //Shifte bas
        actions.sendKeys("n").perform(); //n bas
        actions.keyUp(Keys.SHIFT).perform();// Shift i bırak. Büyük N yazıldı
        actions.sendKeys("u").perform();
        actions.sendKeys("t").perform();
        actions.keyDown(Keys.SHIFT).perform();
        actions.sendKeys("e").perform();
        actions.keyUp(Keys.SHIFT).perform();
        actions.sendKeys("l").perform();
        actions.sendKeys("l").perform();
        actions.sendKeys("a").perform();
        actions.sendKeys(Keys.ENTER).perform();
//        actions.click(aramaKutusu).keyDown(Keys.SHIFT).sendKeys("n").perform();

        Thread.sleep(3000);


    }
}
