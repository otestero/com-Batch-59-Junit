package Practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class VQ1 {

    // BeforeClass ile driver ı olusturun ve class icinde static yapin
    static WebDriver driver;
    @BeforeClass // giriş ayarlarını yapar. bir defa çalışır
    public static void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
    //    Maximize edin, 15 sn bekletin
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        // http://www.google.com adresine gidin
        driver.get("http://www.google.com");
    }
    @Before // her sefer çalışır
    public void tessttenOnce(){
        // http://www.google.com adresine gidin
        driver.get("http://www.google.com");
    }
@Test
//  arama kutusuna "Green Mile" yazip, cikan sonuc sayisini yazdirin
    public void GreenMileTesti(){
        driver.findElement(By.xpath("//input[@class='gLFyf gsfi']")).
                sendKeys("Green Mile"+Keys.ENTER);
          }
    @Test  // arama kutusuna  "Premonition" yazip, cikan sonuc sayisini yazdirin
   public void premonitionTest(){
        driver.findElement(By.xpath("//input[@class='gLFyf gsfi']")).
                sendKeys("Premonition"+Keys.ENTER);
    }
    @Test // arama kutusuna  "The Curious Case of Benjamin Button" yazip, cikan sonuc sayisini yazdirin
   public void filmTesti3(){
        driver.findElement(By.name("q")).
                sendKeys("The Curious Case of Benjamin Button"+Keys.ENTER);
    }
    @After
    public void testtenSonra(){
        System.out.println(driver.findElement(By.id("result-stats")).getText());
    }
@AfterClass // AfterClass ile kapatın*/
    public static void kapatmakIcın(){
        driver.close();
}




}

  /* ...Exercise1...
   BeforeClass ile driver ı olusturun ve class icinde static yapin
   Maximize edin, 15 sn bekletin
   http://www.google.com adresine gidin
   arama kutusuna "Green Mile" yazip, cikan sonuc sayisini yazdirin
   arama kutusuna  "Premonition" yazip, cikan sonuc sayisini yazdirin
   arama kutusuna  "The Curious Case of Benjamin Button" yazip, cikan sonuc sayisini yazdirin
   AfterClass ile kapatın*/