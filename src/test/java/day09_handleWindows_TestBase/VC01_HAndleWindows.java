package day09_handleWindows_TestBase;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Set;

public class VC01_HAndleWindows {
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
        driver.quit();
    }
    @Test
    public void test01(){
        // 1- amazon ana sayfaya gidin
        driver.get("https://www.amazon.com");
        String ilkSayfaHandleDegeri= driver.getWindowHandle();
        // 2- nutella icin arama yaptirin
       driver.findElement(By.id("twotabsearchtextbox")).sendKeys("nutella");
       // arattırınca nutella yı yeni bir sayfayada açtı. bu yüzden driverımızı bu sayfaya göndermemiz gerekecek.



        /*
        CDwindow-4062F2D78BD37C7921FEBC32A9B51C74
        bu kod acilan sayfanin unique hash kodudur.
        Selenium sayfalar arasi geciste bu window handle degerini kullanir
        eger sayfalar arasinda driver'imizi gezdiriyorsak ve herhangi bir sayfadan
        suanda bulundugumuz sayfaya gecemek istiyorsak
        driver.switchTo().window("CDwindow-4062F2D78BD37C7921FEBC32A9B51C74");
        bu sayfanin window handle degerini girerek bu sayfaya gecisi saglayabiliriz.
         */
        // 3- ilk urunun resmini tiklayarak farkli bir tab olarak acin
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.amazon.com");
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("nutella"+Keys.ENTER);
        driver.findElement(By.xpath("//img[@src='https://m.media-amazon.com/images/I/51xt0hr4iML._AC_UL320_.jpg']")).click();
        Set<String> CDCD=driver.getWindowHandles();
        String ikinciCD="";
        for (String each: CDCD
        ) {if (!ilkSayfaHandleDegeri.equals(CDCD)){
            ikinciCD=each;
        }
        }
        /*
        Bu komutu kullandigimizda driver otomatik olarak olusturulan
        new Tab'a gecer
        yeni tab'da gorevi gerceklestirmek icin
        adimlari bastan almamiz gerekir
         */
              // 4- yeni tab'da acilan urunun title'ini yazdirin
        System.out.println("driver.getTitle() = " + driver.getTitle());

        // ilk sayfaya gecip url'i yazdiralim
        driver.switchTo().window(ilkSayfaHandleDegeri);
        System.out.println("driver.getCurrentUrl() = " + driver.getCurrentUrl());


    }
}
