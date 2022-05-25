package day09_handleWindows_TestBase;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class V01_HAndleWindows {
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
    public void test01() throws InterruptedException {
        // 1- amazon ana sayfaya gidin
        driver.get("https://www.amazon.com");
        // 2- nutella icin arama yaptirin
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("nutella"+Keys.ENTER);
        String ilkSayfaCDDegeri=  driver.getWindowHandle();
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
        driver.findElement(By.xpath("//div[@class='a-section aok-relative s-image-square-aspect'][1]"));
        driver.switchTo().newWindow(WindowType.TAB);
        /*
        Bu komutu kullandigimizda driver otomatik olarak olusturulan
        new Tab'a gecer
        yeni tab'da gorevi gerceklestirmek icin
        adimlari bastan almamiz gerekir
         */
        // 4- yeni tab'da acilan urunun title'ini yazdirin
        driver.get("https://www.amazon.com");
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("nutella"+Keys.ENTER);
        driver.findElement(By.xpath("//div[@class='a-section aok-relative s-image-square-aspect'][1]"));
        System.out.println("driver.getTitle() = " + driver.getTitle());
        // ilk sayfaya gecip url'i yazdiralim
        driver.switchTo().window(ilkSayfaCDDegeri);
        Thread.sleep(5000);
        System.out.println("driver.getCurrentUrl() = " + driver.getCurrentUrl());


    }
}
