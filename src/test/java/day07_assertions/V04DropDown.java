package day07_assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class V04DropDown {
    // amazon agidip
    // dropdowndan books seçip
    // JAVA aratalım.
    // arama sonuçlarının java içerdiğini test edelim
    WebDriver driver;
    @Before
            public  void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @After
    public void tearDown(){
        driver.close();
    }
    @Test
    public void testx1() throws InterruptedException {
        driver.get("https://www.amazon.com/");
        WebElement ddm=driver.findElement(By.id("searchDropdownBox"));
        Select select=new Select(ddm);
        select.selectByVisibleText("Books");
        Thread.sleep(3000);
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Java");
        Thread.sleep(5000);
    }

    /*
    WebDriver driver;
    @Before
    public void setup(){
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
    public void test02(){
        driver.get("https://www.amazon.com");
        WebElement DropBoxMenu=driver.findElement(By.id("searchDropdownBox"));
        Select select=new Select(DropBoxMenu);
        select.selectByVisibleText("Books");


    }*/
}
