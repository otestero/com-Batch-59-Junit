package Practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class VQ04 {


   // https://www.teknosa.com/ adresine gidiniz
  static WebDriver driver;
    @BeforeClass
    public static void setup(){
        WebDriverManager.chromedriver().setup();
    }
    @Before
    public void testtenOnce(){
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.teknosa.com/");
    }

   // arama cubuguna oppo yazip enter deyiniz
   @Test
    public void oppoTest(){
        driver.findElement(By.id("search-input")).sendKeys("oppo"+ Keys.ENTER);
        String oppoSunuc = driver.findElement(By.xpath("//div[@class='plp-info']")).getText();
        System.out.println("oppo Sunuc sayisi = " + oppoSunuc);
        driver.findElement(By.xpath("//a[@class='prd-link'][1]")).click();
        driver.findElement(By.xpath("//button[@id='addToCartButton']")).click();
        driver.findElement(By.xpath("//a[@class='btn btn-secondary']")).click();
        String siparisOzeti= driver.findElement(By.xpath("//div[@class='cart-sum-title']")).getText();
        System.out.println("siparisOzeti = " + siparisOzeti);
        driver.findElement(By.xpath("//a[@title='Alışverişi Tamamla']")).click();
        String hosGeldiniz= driver.findElement(By.xpath("//div[text()='Teknosa’ya hoş geldiniz']")).getText();
        System.out.println("hosGeldiniz = " + hosGeldiniz);
    }
@After
    public void testtenSonrasi(){
        driver.close();
    }


     /*
    ...Exercise4...
    https://www.teknosa.com/ adresine gidiniz
    arama cubuguna oppo yazip enter deyiniz
    sonuc sayisini yazdiriniz
    cikan ilk urune tiklayiniz
    sepete ekleyiniz
    sepetime git e tiklayiniz
    consol da "Sipariş Özeti" webelementinin text ini yazidiriniz
    Alisverisi tamamlayiniz
    son alarak da "Teknosa'ya hoş geldiniz"  webelementinin text ini yazidiriniz
    driver i kapatiniz

*/
}
