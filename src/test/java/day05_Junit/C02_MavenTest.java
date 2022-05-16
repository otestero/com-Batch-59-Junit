package day05_Junit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_MavenTest {
    public static void main(String[] args) {
// Proje açma: File-New-Project-Maven-Next-Name-Finish.
// Pom: Dependencions yönetmek için:
// Açılan sayfada </properties> ile </project> arasına <dependency> </dependencies> yazılır. "https://mvnrepository.com" adresine gidilir. Search kutusuna "Selenium Java" yazılır ve aratılır. İlk sonuç tıklanır. en güncel ve en çok usages edilen 4.1.3 seçilir. Maven sekmesindeki kodlar üzerine gelinerek tıklanır. otomatik olarak kopyalanır. <dependencies> lerin arasına yapıştırılır. Ekranın sağındaki diken "Maven" yazısı tıklanır açılan ekranda refresh tıklanır. Proje adı ve altında dependencies görülür. Tekrar <dependency> </dependency> açılır. Arasına "https://mvnrepository.com/" adresinden search'e "WebDriverManager" yazılıp aratılır. İlk sıradaki seçilir. "Central"dan 5.1.0 seçilir. Yine Mavendaki kodlar tıklanarak kopyalanır. <dependency> altına yapıştırılır. Sağdaki Maven Refresh edilir. 5.0.1 geldiği görülür.

        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //1. http://zero.webappsecurity.com sayfasina gidin
        driver.get("http://zero.webappsecurity.com");
        //2. Signin buttonuna tiklayin
        driver.findElement(By.xpath("//button[@id='signin_button']")).click();
        //3. Login alanine  “username” yazdirin
        driver.findElement(By.xpath("//input[@id='user_login']")).sendKeys("username");
        //4. Password alanine “password” yazdirin
        driver.findElement(By.xpath("//input[@id='user_password']")).sendKeys("password");
        //5. Sign in buttonuna tiklayin (hata mesaji icin back tusuna tiklayin)
        driver.findElement(By.xpath("//input[@name='submit']")).click();
        driver.navigate().back();
        //6. Online Banking menusunden Pay Bills sayfasina gidin
        driver.findElement(By.xpath("(//*[text()='Online Banking'])[1]")).click();
        driver.findElement(By.xpath("//span[@id='pay_bills_link']")).click();
        //7. amount kismina yatirmak istediginiz herhangi bir miktari yazin
        driver.findElement(By.xpath("//input[@name='amount']")).sendKeys("500");
        //8. tarih kismina “2020-09-10” yazdirin
        driver.findElement(By.xpath("//input[@id='sp_date']")).sendKeys("2020-09-10");
        //9. Pay buttonuna tiklayin
        driver.findElement(By.id("pay_saved_payees")).click();

        //10. “The payment was successfully submitted.” mesajinin ciktigini kontrol edin
        WebElement sonucYazisiElementi= driver.findElement(By.xpath("//div[@id='alert_content']"));
        if (sonucYazisiElementi.isDisplayed()){
            System.out.println("test PASSED");
        } else {
            System.out.println("test FAILED");
        }
        driver.close();


//1. http://zero.webappsecurity.com sayfasina gidin,
// 2. Signin buttonuna tiklayin
// 3. Login alanine  “username” yazdirin
// 4. Password alanine “password” yazdirin
//5. Sign in buttonuna tiklayin
//6. Pay Bills sayfasina gidin
//7. amount kismina yatirmak istediginiz herhangi bir miktari yazin
//8. tarih kismina “2020-09-10” yazdirin
//9. Pay buttonuna tiklayin
//10. “The payment was successfully submitted.” mesajinin ciktigini control edin */
    }
}
