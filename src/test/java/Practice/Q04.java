package Practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Q04 {


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
   }
    // sonuc sayisini yazdiriniz
    @Test
    public void sonucSayisiTest(){
        String oppoSunuc = driver.findElement(By.xpath("//div[@class='plp-info']")).getText();
        System.out.println("oppo Sunuc sayisi = " + oppoSunuc);
    }
    // cikan ilk urune tiklayiniz
    @Test
    public void ilkUruneTikla(){
        driver.findElement(By.xpath("//a[@class='prd-link'][1]")).click();
    }
    // sepete ekleyiniz
    @Test
    public void sepeteEkleTest(){
        driver.findElement(By.xpath("//button[@id='addToCartButton']")).click();
    }
    // sepetime git e tiklayiniz
    @Test
    public void sepeteGitTest(){
        driver.findElement(By.xpath("//a[@span='Sepetim'e Git']")).click();
    }
    // consol da "Sipariş Özeti" webelementinin text ini yazidiriniz
    @Test
    public void siparisOzetiYAzdir(){
        String siparisOzeti= driver.findElement(By.xpath("//div[@class='cart-sum-title']")).getText();
        System.out.println("siparisOzeti = " + siparisOzeti);
    }
    // Alisverisi tamamlayiniz
    @Test
    public void aVTamala(){
        driver.findElement(By.xpath("//a[@title='Alışverişi Tamamla']")).click();

    }
    // "Teknosa'ya hoş geldiniz"  webelementinin text ini yazidiriniz
    @Test
    public void tHosGeldinizTest(){
        String hosGeldiniz= driver.findElement(By.xpath("//div[text()='Teknosa’ya hoş geldiniz']")).getText();
        System.out.println("hosGeldiniz = " + hosGeldiniz);
    }
   /*

    son alarak da "Teknosa'ya hoş geldiniz"  webelementinin text ini yazidiriniz
    driver i kapatiniz
*/
@After
    public void testtenSonrasi(){


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
