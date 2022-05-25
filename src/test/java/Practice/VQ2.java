package Practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;

import java.time.Duration;

public class VQ2 {

  static  WebDriver driver;
  @BeforeClass
    public static void sutup(){
      WebDriverManager.chromedriver().setup();

      }
      @Before
      // http://www.bestbuy.com 'a gidin,
      public void testtenOnce(){
          driver=new ChromeDriver();
          driver.manage().window().maximize();
          driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
          driver.get("http://www.bestbuy.com");
      }
      @Test
      // Sayfa basliginin "Best" icerdigini(contains) dogrulayin
      public void BestKontrol(){
          Assert.assertTrue(driver.getTitle().contains("Best"));
      }
      @Test
      // Ayrica Relative Locator kullanarak;
      // logoTest => BestBuy logosunun gorunutulenip goruntulenmedigini dogrulayin
     public void logoTesti(){
      WebElement bestBuyVarMi= driver.findElement(By.xpath("(//img[@alt='Best Buy Logo'])[1]"));
     Assert.assertTrue(bestBuyVarMi.isDisplayed());
      }
      @Test
    // mexicoLinkTest => Linkin gorunutulenip goruntulenmedigini dogrulayin
    public void mexicoLinkTest(){
          System.out.println("driver.findElement(By.xpath(\"//img[@alt='Mexico']\")).isDisplayed() = " + driver.findElement(By.xpath("//img[@alt='Mexico']")).isDisplayed());
      }
      @After
    public void testtenSonra(){
          Assert.assertTrue("görünmüyor",driver.getTitle().contains("Best"));
      }
      @AfterClass
    public static void tearDown(){
      driver.close();
      }
        /*
   ...Exercise2...
   http://www.bestbuy.com 'a gidin,
   Sayfa basliginin "Best" icerdigini(contains) dogrulayin
   Ayrica Relative Locator kullanarak;
       logoTest => BestBuy logosunun gorunutulenip goruntulenmedigini dogrulayin
       mexicoLinkTest => Linkin gorunutulenip goruntulenmedigini dogrulayin
*/
}
