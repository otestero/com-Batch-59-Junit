package day08_allerts;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_Allerts {

    static WebDriver driver;

    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void test01() {
        driver.get("https://www.facebook.com");
        driver.get("https://the-internet.herokuapp.com/javascript_alerts\n");
        driver.findElement(By.xpath("//*[text()='Click for JS Alert']"));
        driver.switchTo().alert().accept();
        String expectedResult="You successfully clicked an allert";
        WebElement ddd=driver.findElement(By.xpath("//p[@id='result']"));
        String actualResultYazisi=ddd.getText();

    }
}