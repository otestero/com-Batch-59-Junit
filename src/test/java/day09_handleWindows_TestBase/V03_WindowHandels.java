package day09_handleWindows_TestBase;

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
import java.util.Set;

public class V03_WindowHandels {
    //    ● Tests package’inda yeni bir class olusturun: WindowHandle2
//● https://the-internet.herokuapp.com/windows adresine gidin.
//            ● Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
//            ● Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
//            ● Click Here butonuna basın.
//            ● Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu dogrulayin.
//            ● Sayfadaki textin “New Window” olduğunu doğrulayın.
//            ● Bir önceki pencereye geri döndükten sonra sayfa başlığının “The Internet” olduğunu doğrulayın.
    WebDriver driver;
    String ikinciSayfaCD;
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
        // ● Tests package’inda yeni bir class olusturun: WindowHandle2
        //● https://the-internet.herokuapp.com/windows adresine gidin.
       driver.get("https://the-internet.herokuapp.com/windows");
        //● Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
        String actualtex= driver.findElement(By.xpath("//h3")).getText();
        String expectedtex="Opening a new window";
        Assert.assertEquals(actualtex,expectedtex);

        //● Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
        String actualTitle= driver.getTitle();
        String expectedTitle= "The Internet";
        Assert.assertEquals(expectedTitle,actualTitle);
        /*
        eger kontrolsuz acilan bir tab veya window varsa
        o zaman sayfalarin window handle degerlerini elde etmem gerekir.
        oncelikle 2.sayfa acilmadan once
        ilk sayfanin window handle degerini bir String'e atayalim
         */
        String ilkSayfaCD= driver.getWindowHandle();

        //● Click Here butonuna basın.
        driver.findElement(By.xpath("//a[@href='/windows/new']")).click();
          /*
          switchTo().newWindow() demeden link tiklayarak yeni tab veya window olustugunda
          biz driver'a yeni sayfaya gec demedikce, driver eski sayfada kalir
          ve yeni sayfa ile ilgili hicbir islem yapamaz
          yeni sayfada driver'i calistirmak isterseniz
          once driver'i yeni sayfaya yollamalisiniz
            */
            /*
        yeni sayfaya gecebilmek icin oncelikle ikinciSayfaWindowHandleDegeri'ni bulmamiz gerekir
        bunun icin driver.getWindowHandles() method'unu kullanarak
        acik olan tum sayfalarin window handle degerlerini alip bir set'e assign ederiz.
            ilk sayfanin window handle degerini zaten biliyoruz
        Set'deki window handle degerlerini kontrol edip
        ilk sayfanin handle degerine esit olmayan
        ikinci sayfanin window handle degeridir deriz
             */
        Set<String> CDList= driver.getWindowHandles();
        System.out.println("CDList = " + CDList);
        for (String each: CDList
             ) {
            if (!each.equals(ilkSayfaCD)){
                ikinciSayfaCD=each;
               // driver.switchTo().window(each);
                System.out.println("ikinci CD=" + each);
            }
        }
        // artik ikinci sayfanin window handle degerini biliyoruz
        // rahatlikla sayfalar arasii gecis yapabiliriz
        //● Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu dogrulayin.
        String actualTitle2= driver.getTitle();
        String ecceptedTitle2= "New Window";
        Assert.assertEquals(ecceptedTitle2,actualTitle2);
        //● Sayfadaki textin “New Window” olduğunu doğrulayın.
        String newTex2=driver.findElement(By.xpath("//h3")).getText();
        String expectedTex2= "New Window";
        Assert.assertEquals(expectedTex2,newTex2);
        //● Bir önceki pencereye geri döndükten sonra sayfa başlığının
        // “The Internet” olduğunu doğrulayın.
        driver.switchTo().window(ilkSayfaCD);
        System.out.println("ilkSayfaCD = " + ilkSayfaCD);
        String ilkSayfabaslik= driver.getTitle();
        String beklenenBaslik= "The Internet";
        Assert.assertEquals(ilkSayfabaslik,beklenenBaslik);
    }
}