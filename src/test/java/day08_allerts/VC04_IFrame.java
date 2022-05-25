package day08_allerts;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class VC04_IFrame {
   //  ● Bir class olusturun: IframeTest

   WebDriver driver;
   @Before
   public void setUp(){
      WebDriverManager.chromedriver().setup();
      driver=new ChromeDriver();
      driver.manage().window().maximize();
      driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
   }

   @After
   public void tearDown(){
      driver.close();
   }

   @Test
   public void test01() throws InterruptedException {
      //   ● https://the-internet.herokuapp.com/iframe adresine gidin.
      driver.get("https://the-internet.herokuapp.com/iframe");
      // textbox'i dogru olarak locate etmemize ragmen driver bulamadi
      // bunun uzerine HTML kodlari inceleyince textbox'in aslinda bir IFrame icerisinde oldugunu gorduk
      // **** once iframe'i locate edip switchTo() ile o iFrame'e gecilir. *****
      WebElement textBox1 = driver.findElement(By.id("mce_0_ifr"));
      driver.switchTo().frame(textBox1);
      WebElement textbox= driver.findElement(By.xpath("//*[text()='Your content goes here.']"));
      textbox.clear();
      textbox.sendKeys("Merhaba Dünya");

      // iFrame'den çıkış
      driver.switchTo().defaultContent();
      Thread.sleep(1000);
   }
}
