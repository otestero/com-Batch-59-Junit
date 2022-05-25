package Practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;

import java.time.Duration;

public class Q2 {
    /*
   ...Exercise2...
   http://www.bestbuy.com 'a gidin,
   Sayfa basliginin "Best" icerdigini(contains) dogrulayin
   Ayrica Relative Locator kullanarak;
       logoTest => BestBuy logosunun gorunutulenip goruntulenmedigini dogrulayin
       mexicoLinkTest => Linkin gorunutulenip goruntulenmedigini dogrulayin
*/
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
        driver.get("http://www.bestbuy.com");
    }
    @Test
    public void titleTestP01(){
        Assert.assertTrue("title Best kelimesi içermiyor", driver.getTitle().contains("Best"));
    }
    @Test
    public void logoTest(){
        driver.findElement(By.xpath("//img[@class='logo']"));
        // WebElement logoBestBuy = driver.findElement(By.xpath("//img[@class ='logo']"));
        WebElement helloHEading = driver.findElement(By.xpath("//div[@class ='heading']"));
        WebElement logoBestBuy = driver.findElement(RelativeLocator.with(By.tagName("img")).above(helloHEading));
        Assert.assertTrue(logoBestBuy.isDisplayed());
    }
    @Test
    public void mexicoTest(){

    }

    @After
    public void testtenSonra(){
        driver.close();
    }

}
