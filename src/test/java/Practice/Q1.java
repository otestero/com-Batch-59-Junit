package Practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Q1 {


  // ...Exercise1...
  // BeforeClass ile driver ı olusturun ve class icinde static yapin
 static WebDriver driver;
   @BeforeClass // giriş ayarlarını yapar. bir defa çalışır
    public static void setup(){
       WebDriverManager.chromedriver().setup();
       driver =new ChromeDriver();
       driver.manage().window().maximize();
       // Maximize edin, 15 sn bekletin
       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
   }
   @Before  // her sefer çalışır
   // http://www.google.com adresine gidin
   public void testtenOnce(){
       driver.get("http://www.google.com");
   }
   @Test
   public void testP01(){
       WebElement aramaKutusu=driver.findElement(By.name("q"));
       aramaKutusu.sendKeys("Green Mile");
       aramaKutusu.submit();//
   }
   @Test
   public void testP02(){
       WebElement aramaKutusu=driver.findElement(By.name("q"));
       aramaKutusu.sendKeys("Premonition"+ Keys.ENTER);
   }
    @Test
    public void testP03() {
        WebElement aramaKutusu = driver.findElement(By.name("q"));
        aramaKutusu.sendKeys("The Curious Case of Benjamin Button" + Keys.ENTER);
    }
   @After
public void testtensonra(){
       WebElement sonucYazisi=driver.findElement(By.id("result-stats"));
       System.out.println("sonucYazisi.getText() = " + sonucYazisi.getText());
   }
   @AfterClass
    public static void tearDown(){
       driver.quit();
   }

  // arama kutusuna "Green Mile" yazip, cikan sonuc sayisini yazdirin
  // arama kutusuna  "Premonition" yazip, cikan sonuc sayisini yazdirin
  // arama kutusuna  "The Curious Case of Benjamin Button" yazip, cikan sonuc sayisini yazdirin
  //  AfterClass ile kapatın

}

  /* ...Exercise1...
   BeforeClass ile driver ı olusturun ve class icinde static yapin
   Maximize edin, 15 sn bekletin
   http://www.google.com adresine gidin
   arama kutusuna "Green Mile" yazip, cikan sonuc sayisini yazdirin
   arama kutusuna  "Premonition" yazip, cikan sonuc sayisini yazdirin
   arama kutusuna  "The Curious Case of Benjamin Button" yazip, cikan sonuc sayisini yazdirin
   AfterClass ile kapatın*/