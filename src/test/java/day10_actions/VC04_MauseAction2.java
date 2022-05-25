package day10_actions;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class VC04_MauseAction2 extends TestBase {
    @Test
    public void test01() throws InterruptedException {
        //Yeni bir class olusturalim: MouseActions2
        //1- https://demoqa.com/droppable adresine gidelim
        driver.get("https://demoqa.com/droppable");
        //2- “Drag me” butonunu tutup “Drop here” kutusunun ustune birakalim
        Actions actions =new Actions(driver);       // 1. adım
        WebElement gidecekOlan= driver.findElement(By.xpath("//*[text()='Drag me']")); // 2. adim
        WebElement hedef= driver.findElement(By.xpath("//*[text()='Drop here']"));
        actions.dragAndDrop(gidecekOlan,hedef).perform();  // 3. adım
        Thread.sleep(8000);
        //3- “Drop here” yazisi yerine “Dropped!” oldugunu test edin
        String actual= driver.findElement(By.xpath("//*[text()='Dropped!']")).getText();
        String beklenen= "Dropped!";
        Assert.assertEquals(beklenen,actual);

    }

}
