package day07_assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class V02_BestBuy {

    // 2) https://www.bestbuy.com/ Adresine gidin
    //    farkli test method’lari olusturarak asagidaki testleri yapin
    //      ○ Sayfa URL’inin https://www.bestbuy.com/‘a esit oldugunu test edin
    //      ○ titleTest => Sayfa başlığının “Rest” içermediğini(contains) test edin
    //      ○ logoTest => BestBuy logosunun görüntülendigini test edin
    //      ○ FrancaisLinkTest => Fransizca Linkin görüntülendiğini test edin
   static WebDriver driver;
   @BeforeClass
  public static void setup() {
       WebDriverManager.chromedriver().setup();
       driver = new ChromeDriver();
       driver.manage().window().maximize();
       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
   }
   @AfterClass
           public static void tearDown(){
       driver.quit();
   }
   @Test
    //    https://www.bestbuy.com/ Adresine gidin
   //     Sayfa URL’inin https://www.bestbuy.com/‘a esit oldugunu test edin
    public void testx1() {
       driver.get("https://www.bestbuy.com/");
       String istenenUrl = "https://www.bestbuy.com/";
       Assert.assertTrue(driver.getCurrentUrl().contains("https://www.bestbuy.com/"));
       Assert.assertTrue(driver.getCurrentUrl().contains(istenenUrl));
   }
       @Test
    //      ○ titleTest => Sayfa başlığının “Rest” içermediğini(contains) test edin
    public void textx2(){
       String titledaIstenmeyenKelime="Rest";
       String title=driver.getTitle();
       Assert.assertFalse(title.contains(titledaIstenmeyenKelime));
       }

    @Test
    //      ○ logoTest => BestBuy logosunun görüntülendigini test edin
    public void testx3(){
        driver.get("https://www.bestbuy.com/");
       WebElement logoBestBut=driver.findElement(By.xpath("(//img[@alt='Best Buy Logo'])"));
        Assert.assertTrue(logoBestBut.isDisplayed());

        WebElement logoElementi=driver.findElement(By.xpath("(//img[@class='logo'])[1]"));
        Assert.assertTrue(logoElementi.isDisplayed());
    }
    @Test
    //      ○ FrancaisLinkTest => Fransizca Linkin görüntülendiğini test edin
    public void testx4(){
       driver.get("https://www.bestbuy.com/");
       WebElement Francis=driver.findElement(By.xpath("//*[text()='Français']"));
       Assert.assertTrue(Francis.isDisplayed());

    }




   /*
    static WebDriver driver;
    @BeforeClass
    public static void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.bestbuy.com/");
    }
    @AfterClass
    public static void tearDown(){
        driver.close();
    }
    @Test
    public void test01(){
        // ○ Sayfa URL’inin https://www.bestbuy.com/ ‘a esit oldugunu test edin
        String expectedUrl="https://www.bestbuy.com/";
        String actualUrl= driver.getCurrentUrl();
        Assert.assertEquals(expectedUrl,actualUrl);
    }
    @Test
    public void test02() {
        //○ titleTest => Sayfa başlığının “Rest” içermediğini(contains) test edin
        String istenmeyenKelime="Rest";
        String actualTitle=driver.getTitle();
        Assert.assertFalse(actualTitle.contains(istenmeyenKelime));
    }
    @Test
    public void test03() {
        //      ○ logoTest => BestBuy logosunun görüntülendigini test edin
        WebElement logoElementi=driver.findElement(By.xpath("(//img[@class='logo'])[1]"));
        Assert.assertTrue(logoElementi.isDisplayed());
    }
    @Test
    public void test04() {
        //      ○ FrancaisLinkTest => Fransizca Linkin görüntülendiğini test edin
        WebElement francaisElementi= driver.findElement(By.xpath("//*[text()='Français']"));
        Assert.assertTrue(francaisElementi.isDisplayed());
        */

        }


