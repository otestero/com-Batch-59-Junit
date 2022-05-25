package day10_actions;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class VC02_Actions extends TestBase {
    @Test
    public void test01() throws InterruptedException {
        // amazon anasayfa'ya gidip
        // account menusunden create a list linkine tiklayalim
        driver.get("https://www.amazon.com");
        Actions actions= new Actions(driver);
        WebElement gidilecekElement= driver.findElement(By.id("nav-link-accountList-nav-line-1"));
        actions.moveToElement(gidilecekElement).perform();
        driver.findElement(By.xpath("//span[@class='nav-text'][1]")).click();
        Thread.sleep(3000);


    }
}