package jUnitornekler;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.Set;

public class JUnitOrneklerCalısmalar extends TestBase {

    protected WebDriver driver;

    // *************** TestBase (Before(setup) After(tearDown)) public abstract class TestBase {**************
    // abstrac yapmamızın sebebi bu klastan obje üretilmesinin önüne geçmektir.
    @Before // her sefer çalışır
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @After
    public void tearDown() {
        driver.quit();
    }

    // ****************** Ornekler ****************

    @Test
    public void ornekler() throws InterruptedException {
        // ************ Checkbox tik atma ***************
        driver.get("https://the-internet.herokuapp.com/checkboxes");
        //b. Checkbox1 ve checkbox2 elementlerini locate edin.
        WebElement cek1= driver.findElement(By.xpath("//input[@type='checkbox'][1]"));
        WebElement cek2= driver.findElement(By.xpath("//input[@type='checkbox'][2]"));
        Thread.sleep(3000);
        //c. Checkbox1 seçili değilse onay kutusunu tıklayın
        if (!cek1.isSelected()){
            cek1.click();
        }
        Thread.sleep(3000);
        //d. Checkbox2 seçili değilse onay kutusunu tıklayın
        if (cek2.isSelected()){
        } cek2.click();
        Thread.sleep(3000);
    }

    // ****************** iframe giriş ve çıkış *********************
    @Test
    public void test01() throws InterruptedException {
        //   ● https://the-internet.herokuapp.com/iframe adresine gidin.
        //     Bir metod olusturun: iframeTest
        //		○ “An IFrame containing….” textinin erisilebilir oldugunu test edin
        //		ve  konsolda 	yazdirin.
        //       ○ Text Box’a “Merhaba Dunya!” yazin.
        //		○ TextBox’in altinda bulunan “Elemental Selenium”
        //		linkinin textinin gorunur oldugunu 	dogrulayin ve  konsolda yazdirin.
        driver.get("https://the-internet.herokuapp.com/iframe");
        WebElement baslik= driver.findElement(By.xpath("//h3"));
        driver.findElement(By.xpath("//h3"));
        Assert.assertTrue(baslik.isEnabled());
        Assert.assertTrue(driver.findElement(By.xpath("//h3")).isEnabled());
        System.out.println("baslik = " + baslik.getText());

        driver.switchTo().frame(driver.findElement(By.id("mce_0_ifr")));
        WebElement tex1= driver.findElement(By.xpath("//*[text()='Your content goes here.']"));
        tex1.clear();
        tex1.sendKeys("Merhaba Dünya");
        driver.switchTo().defaultContent();
        Thread.sleep(3000);
        Assert.assertTrue(driver.findElement(By.xpath("//*[text()='Elemental Selenium']")).isDisplayed());
        System.out.println(driver.findElement(By.xpath("//*[text()='Elemental Selenium']")).getText());


    }

    // ****************** Alert driver.switchTo().alert().accept(); ((dismiss(), accept(), sendKeys()); *****************
    // açılan pencereyi bazen locate edemeyiz. o zaman Alert ile işlem yaparız. Pencereyi açan düğmeyi locate  ederiz.
    // Alert ile de driver.switchTo().alert().accept(); ((dismiss(), accept(), sendKeys()); bunları kullanarak istenen işlemi yaparız.
    @Test
    public void acceptAlert() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        //		1. butona tıklayın, uyarıdaki OK butonuna tıklayın ve result mesajının
        //		2. butona tıklayın, uyarıdaki Cancel butonuna tıklayın ve result mesajının
        //		3. butona tıklayın, uyarıdaki metin kutusuna isminizi yazin,

        driver.findElement(By.xpath("//button[@onclick='jsAlert()'][1]")).click();
        driver.switchTo().alert().accept();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//p[@id='result']"));
        Assert.assertTrue(driver.findElement(By.xpath("//p[@id='result']")).isDisplayed());
        System.out.println("result =" +  driver.findElement(By.xpath("//p[@id='result']")).getText());
        //		2. butona tıklayın, uyarıdaki Cancel butonuna tıklayın ve result mesajının
        driver.findElement(By.xpath("//button[@onclick='jsConfirm()']")).click();
        driver.switchTo().alert().dismiss();
        Assert.assertTrue(driver.findElement(By.xpath("//p[@id='result']")).isDisplayed());
        System.out.println(driver.findElement(By.xpath("//p[@id='result']")).getText());
        //		3. butona tıklayın, uyarıdaki metin kutusuna isminizi yazin,
        driver.findElement(By.xpath("//button[@onclick='jsPrompt()']")).click();
        driver.switchTo().alert().sendKeys("Hasan");
        driver.switchTo().alert().accept();
         Assert.assertTrue(driver.findElement(By.xpath("//p[@id='result']")).getText()
               .contains("Hasan"));
        System.out.println("sonuç = " + driver.findElement(By.xpath("//p[@id='result']")).getText());


    }

    //                  ************  Drop Down Menu *****************
    @Test
    public void dropDown() throws InterruptedException {
        driver.get("https://www.amazon.com");
        // dropdown'dan bir option secmek icin 3 adim vardir

        // select.selectByIndex(5);
        // select.selectByValue("search-alias=stripbooks-intl-ship");
        // arama kutusuna Java yazdiralim

    }

    // ********* Actions Klavye (click(),contextClick(),clickAndHold(), dragAndDrop(), keyDown, keyUp, sendKeys ********* ;
    @Test
    public void Actions() throws InterruptedException {
        driver.get("https://www.amazon.com");
        Actions actions = new Actions(driver);    // 1. adım
        WebElement hedeftekiElement = driver.findElement(By.id("nav-link-accountList-nav-line-1")); // 2. adım
        actions.moveToElement(hedeftekiElement).perform(); // 3. adım   perform önemli
    }

    // **************  Yeni Açılan Sayfaya Driver'i Gönderme  ************
    @Test
    public void yeniAcılanSayfa() throws InterruptedException {

        driver.get("https://the-internet.herokuapp.com/context_menu");
        String ilkSayfaCD = driver.getWindowHandle();
        driver.findElement(By.xpath("//a[@target='_blank']")).click();
        Set<String> Cdler = driver.getWindowHandles();
        System.out.println("Cdler = " + Cdler);
        String ikinciCd = "";
        for (String each : Cdler
        ) {
            if (!each.equals(ilkSayfaCD)) {
                ikinciCd = each;
            }
        }
        //Acilan sayfada h1 taginda “Elemental Selenium” yazdigini test edilmesi
        //  driver.switchTo().newWindow(WindowType.TAB);
        driver.switchTo().window(ikinciCd); // driveri yeni (ikinci) sayfaya gönderir
        String expectetd = "Elemental Selenium";
        String actualltd = driver.findElement(By.xpath("//*[text()='Elemental Selenium']")).getText();
        Assert.assertEquals(expectetd, actualltd);
    }

    @Test
    public void BizimActigimizYeniSayfa() throws InterruptedException {
        //  ilk urunun resmini tiklayarak farkli bir tab olarak acin
        driver.get("https://www.amazon.com");
    }

    //   ********************  Bilgisayarımızın downloadına dosya indirme ve Kontrol etme   **********
    @Test
    public void fileDownLoadTest() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/download");
        driver.findElement(By.xpath("//*[text()='LambdaTest.txt']")).click();
        Thread.sleep(5000);
        String farkliKisim = System.getProperty("user.home");
        String ortakKisim = "\\Downloads\\LambdaTest.txt";
        String dosyaYolu = farkliKisim + ortakKisim;
        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));

    }

// ************** implicitWait(): Tüm ögeler içindir , explicitWait(): Belirli ögeler için belirli şartlara göre bekler ****************
 // ************* bekleme islemi ve locate'i birlikte yapmaliyiz ****************
    @Test
    public void explicitlywaitTesti() {
        //3. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.

        //4. Remove butonuna basin.

        //5. “It’s gone!” mesajinin goruntulendigini dogrulayin.

        /*
        yazinin gorunur olmasini beklerken yazinin locate'ini kullanmak sorun olusturur
        cunku henuz gorunmeyen bir yazinin locate edilmesi de mumkun olmayabilir
        (HTML kodlari yazan developer farkli uygulamalar yapablir)
        Bu durumda bekleme islemi ve locate'i birlikte yapmaliyiz
        */

        //6. Add buttonuna basin

        //7. It’s back mesajinin gorundugunu test edin

    }
}