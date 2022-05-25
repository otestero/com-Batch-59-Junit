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

import java.nio.file.Watchable;
import java.time.Duration;

public class C01_Assertions {
    /* Amazon ana sayfaya gidin
    Üç farklı test metodu oluşturarak aşağıdaki görevleri yapın
   // 1- Url in amazon içerdiğini test edin
   // 2- title ın facebook içermediğini test edin
    // 3- sol üst köşede amazon logosunun göründüğünü test edin
     */


    static WebDriver driver;
    @BeforeClass// 3- sol üst köşede amazon logosunun göründüğünü test edin
    public static void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @AfterClass
    public static void tearDown() {
            driver.close();
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
    public void test02(){
        String arananTitle="facebook";
        String actualTitle=driver.getTitle();
        Assert.assertFalse(actualTitle.contains(arananTitle));

    }
    @Test
    // 3- sol üst köşede amazon logosunun göründüğünü test edin
    public void test03(){
       WebElement logoElemnti= driver.findElement(By.id("nav-logo-sprites"));
        Assert.assertTrue(logoElemnti.isDisplayed());
    }
}
