package day10_actions;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.util.Set;

public class VC03_MauseActions extends TestBase {

    @Test
    public void test01() throws InterruptedException {
        // 1- Yeni bir class olusturalim: MouseActions1
        //2- https://the-internet.herokuapp.com/context_menu sitesine gidelim
        driver.get("https://the-internet.herokuapp.com/context_menu");
        //3- Cizili alan uzerinde sag click yapalim
        Actions actions=new Actions(driver);
        WebElement hedeftekiElement= driver.findElement(By.xpath("//div[@id='hot-spot']"));
        actions.contextClick(hedeftekiElement).perform();
       Thread.sleep(3000);
        //4- Alert’te cikan yazinin “You selected a context menu” oldugunu test edelim.
String beklenenDeger= "You selected a context menu";
String istenenElement= driver.switchTo().alert().getText();
Assert.assertEquals(beklenenDeger,istenenElement);

        //5- Tamam diyerek alert’i kapatalim
        driver.switchTo().alert().accept();
        Thread.sleep(3000);

        //6- Elemental Selenium linkine tiklayalim


        String ilkSayfaCD= driver.getWindowHandle();
            driver.findElement(By.xpath("//a[@target='_blank']")).click();
        Set<String> Cdler = driver.getWindowHandles();
            System.out.println("Cdler = " + Cdler);
        String ikinciCd="";
        for (String each: Cdler
             ) {
            if (!each.equals(ilkSayfaCD)){
                ikinciCd=each;
            }
        }
        //7- Acilan sayfada h1 taginda “Elemental Selenium” yazdigini test edeli

        driver.switchTo().window(ikinciCd); // driveri ikinci sayfaya gönderir
        String expectetd= "Elemental Selenium";
            String actualltd= driver.findElement(By.xpath("//*[text()='Elemental Selenium']")).getText();
            Assert.assertEquals(expectetd,actualltd);

    }

}
