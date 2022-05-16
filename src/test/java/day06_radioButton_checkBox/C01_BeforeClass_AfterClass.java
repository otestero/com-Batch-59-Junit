package day06_radioButton_checkBox;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_BeforeClass_AfterClass {

   static WebDriver driver;

    @BeforeClass  //sadece static metotlar için çalışır
    public static void setUp() {
        WebDriverManager.chromiumdriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @AfterClass //sadece static metotlar için çalışır
    public static void tearDown() {
        driver.close();

    }

    @Test
    public void test01() {
        driver.get("https://www.amazon.com");
    }

    @Test
    public void test02() {
        driver.get("https://www.facebook.com");
    }
}
