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

public class JUnitOrnekler extends TestBase {

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
        WebElement checkBox1 = driver.findElement(By.xpath("(//input[@type='checkbox'])[1]"));
        WebElement checkBox2 = driver.findElement(By.xpath("(//input[@type='checkbox'])[2]"));
        //c. Checkbox1 seçili değilse onay kutusunu tıklayın
        Thread.sleep(3000);
        if (!checkBox1.isSelected()) {
            checkBox1.click();
        }
        //d. Checkbox2 seçili değilse onay kutusunu tıklayın
        Thread.sleep(3000);
        if (!checkBox2.isSelected()) {
            checkBox2.click();
        }
        Thread.sleep(3000);
    }

    // ****************** iframe giriş ve çıkış *********************
    @Test
    public void test01() throws InterruptedException {
        //   ● https://the-internet.herokuapp.com/iframe adresine gidin.
        driver.get("https://the-internet.herokuapp.com/iframe");
        // textbox'i dogru olarak locate etmemize ragmen driver bulamadi
        // bunun uzerine HTML kodlari inceleyince textbox'in aslinda bir IFrame icerisinde oldugunu gorduk
        // **** once iframe'i locate edip switchTo() ile o iFrame'e gecilir. *****
        WebElement textBox1 = driver.findElement(By.id("mce_0_ifr"));
        driver.switchTo().frame(textBox1);
        WebElement textbox = driver.findElement(By.xpath("//*[text()='Your content goes here.']"));
        textbox.clear();
        textbox.sendKeys("Merhaba Dünya");
        // iFrame'den çıkış
        driver.switchTo().defaultContent();
        Thread.sleep(3000);
    }

    // ****************** Alert driver.switchTo().alert().accept(); ((dismiss(), accept(), sendKeys()); *****************
    // açılan pencereyi bazen locate edemeyiz. o zaman Alert ile işlem yaparız. Pencereyi açan düğmeyi locate  ederiz.
    // Alert ile de driver.switchTo().alert().accept(); ((dismiss(), accept(), sendKeys()); bunları kullanarak istenen işlemi yaparız.
    @Test
    public void acceptAlert() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        //		1. butona tıklayın, uyarıdaki OK butonuna tıklayın ve result mesajının
        driver.findElement(By.xpath("//*[text()='Click for JS Alert']")).click();
        Thread.sleep(3000);
        driver.switchTo().alert().accept();// "Tamam" düğmesine basıyor.
        //		2. butona tıklayın, uyarıdaki Cancel butonuna tıklayın ve result mesajının
        driver.findElement(By.xpath("//*[text()='Click for JS Confirm']")).click();
        Thread.sleep(5000);
        driver.switchTo().alert().dismiss();
        //		3. butona tıklayın, uyarıdaki metin kutusuna isminizi yazin,
        driver.findElement(By.xpath("//*[text()='Click for JS Prompt']")).click();
        driver.switchTo().alert().sendKeys("hasan");
        driver.switchTo().alert().accept();
        Thread.sleep(3000);
    }

    //                  ************  Drop Down Menu *****************
    @Test
    public void dropDown() throws InterruptedException {
        driver.get("https://www.amazon.com");
        // dropdown'dan bir option secmek icin 3 adim vardir
        WebElement dropDownMenu = driver.findElement(By.xpath("//select[@id='searchDropdownBox']")); // 1- dropdown'i locate edelim
        Select select = new Select(dropDownMenu); // 2- bir Select objesi olusturup parametre olarak bir onceki adimda locate ettigimiz ddm'yu girelim
        select.selectByVisibleText("Books");    // 3- Dropdown'da var olan option'lardan istedigimiz bir taneyi secelim
        Thread.sleep(5000);
        // select.selectByIndex(5);
        // select.selectByValue("search-alias=stripbooks-intl-ship");
        // arama kutusuna Java yazdiralim
        WebElement aramaKutusu = driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("Java" + Keys.ENTER);
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
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("nutella" + Keys.ENTER);
        String ilkCDCD = driver.getWindowHandle();
        driver.switchTo().newWindow(WindowType.TAB);
        String ikinciCDDD = "";
        Set<String> CDDD = driver.getWindowHandles();
        for (String each : CDDD
        ) {
            if (!ilkCDCD.equals(CDDD)) {
                ikinciCDDD = each;
            }
        }
        driver.switchTo().window(ikinciCDDD);
        driver.get("https://www.amazon.com");
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("nutella" + Keys.ENTER);
        driver.findElement(By.xpath("//img[@src='https://m.media-amazon.com/images/I/51xt0hr4iML._AC_UL320_.jpg']")).click();
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
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        //4. Remove butonuna basin.
        driver.findElement(By.xpath("//button[@onclick='swapCheckbox()']")).click();
        //5. “It’s gone!” mesajinin goruntulendigini dogrulayin.
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        /*
        yazinin gorunur olmasini beklerken yazinin locate'ini kullanmak sorun olusturur
        cunku henuz gorunmeyen bir yazinin locate edilmesi de mumkun olmayabilir
        (HTML kodlari yazan developer farkli uygulamalar yapablir)
        Bu durumda bekleme islemi ve locate'i birlikte yapmaliyiz
        */
        WebElement itsGoneYaziElementi = wait.until(ExpectedConditions.
                visibilityOfElementLocated(By.xpath("//p[text()=\"It's gone!\"]")));
        Assert.assertTrue(itsGoneYaziElementi.isDisplayed());
        //6. Add buttonuna basin
        driver.findElement(By.xpath("//button[text()=\"Add\"]")).click();
        //7. It’s back mesajinin gorundugunu test edin
        WebElement itsBackElementi = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[text()=\"It's back!\"]")));
        Assert.assertTrue(itsBackElementi.isDisplayed());
    }
}