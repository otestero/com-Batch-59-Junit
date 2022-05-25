package day09_handleWindows_TestBase;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class V02_Handle {
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
        // 1- amazon anasayfaya gidelim
       driver.get("https://www.amazon.com");
       // 2- url'in  amazon icerdigini test edelim
        String actualUrl=driver.getCurrentUrl();
        String expectedUrl="amazon";
        Assert.assertTrue(actualUrl.contains(expectedUrl));
        Assert.assertTrue(driver.getCurrentUrl().contains("amazon"));
        String ilkSayfaCD= driver.getWindowHandle();
        // 3- yeni bir pencere acip bestbuy ana sayfaya gidelim
       driver.switchTo().newWindow(WindowType.TAB);
       driver.get("https:/www.bestbuy.com");
       String ikinciSayfaCD=driver.getWindowHandle();
        // 4- title'in Best Buy icerdigini test edelim
       Assert.assertTrue(driver.getTitle().contains("Best Buy"));
        // 5- ilk sayfaya donup sayfada java aratalim
        driver.switchTo().window(ilkSayfaCD);
        Thread.sleep(5000);
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Java"+Keys.ENTER);
        // 6- arama sonuclarinin Java icerdigini test edelim
        String aramaSonucuJavaVarMi= driver.findElement(By.xpath("//span[@class='a-color-state a-text-bold']")).getText();
Assert.assertTrue(aramaSonucuJavaVarMi.contains("Java"));
        // 7- yeniden bestbuy'in acik oldugu sayfaya gidelim
driver.switchTo().window(ikinciSayfaCD);
        // 8- logonun gorundugunu test edelim
      Assert.assertTrue(driver.findElement(By.xpath("//img[@alt='Best Buy Logo'][1]")).isDisplayed());

    }
}