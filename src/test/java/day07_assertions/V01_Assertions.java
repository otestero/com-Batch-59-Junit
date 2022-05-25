package day07_assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.checkerframework.checker.units.qual.A;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class V01_Assertions {
    /* Amazon ana sayfaya gidin
    Üç farklı test metodu oluşturarak aşağıdaki görevleri yapın
   // 1- Url in amazon içerdiğini test edin
   // 2- title ın facebook içermediğini test edin
    // 3- sol üst köşede amazon logosunun göründüğünü test edin
     */
    static WebDriver driver;
    @BeforeClass
    public static void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @AfterClass
    public static void tearDown(){
       driver.close();
    }

   @Test
   // Amazon ana sayfaya gidin // 1- Url in amazon içerdiğini test edin
   public void testx1(){
        driver.get("https://www.amazon.com");
        Assert.assertTrue(driver.getCurrentUrl().contains("amazon") );
   }
    @Test
    public  void test01(){
        driver.get("https://www.amazon.com");
        // 1- Url in amazon içerdiğini test edin
        String arananKelime="amazon";
        String actualUrl=driver.getCurrentUrl();
        Assert.assertTrue(actualUrl.contains(arananKelime));
    }

    @Test
    // 2- title ın facebook içermediğini test edin
    public void testx2(){
        String istenmeyenKelime="facebook";
        String actualTitle=driver.getTitle();
        Assert.assertFalse(actualTitle.contains(istenmeyenKelime));
    }
    @Test
    // 2- title ın facebook içermediğini test edin
    public void test02(){
        String arananTitle="facebook";
        String actualTitle=driver.getTitle();
        Assert.assertFalse(actualTitle.contains(arananTitle));

    }
    @Test
    // 3- sol üst köşede amazon logosunun göründüğünü test edin
    public void textx3(){
        driver.get("https://www.amazon.com");
        WebElement logoAmazon= driver.findElement(By.id("nav-logo-sprites"));
        Assert.assertTrue(logoAmazon.isDisplayed());


    }
    @Test
    // 3- sol üst köşede amazon logosunun göründüğünü test edin
    public void test03(){
       WebElement logoElemnti= driver.findElement(By.id("nav-logo-sprites"));
        Assert.assertTrue(logoElemnti.isDisplayed());
    }
}
