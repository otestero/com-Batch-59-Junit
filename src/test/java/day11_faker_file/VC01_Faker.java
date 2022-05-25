package day11_faker_file;

import com.github.javafaker.Faker;
import org.checkerframework.checker.units.qual.K;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class VC01_Faker extends TestBase {
    @Test
    public void fakertest01() throws InterruptedException {

       /* Faker'ı önce pom.xml'e yüklememiz gerekiyor. Bunun içinde
         www.mvnrepostory.com'a git- Faker arat -
         Java Faker'ı seç- 1.0.2 versiyonunu seç- maven'ın altındaki codlara tıkla ve kopyala-pom.xml aç- </dependency>  arasına yapıştır </dependencies>
         - sağdaki maven'ı tıkla ve refrseh yap. Fakerın göründüğünü gör.
         */
        // facebook gorevini fake isimlerle yapalim

        // facebook anasayfaya gidip
        driver.get("https://www.facebook.com");
        // yeni kayit olustur butonuna basin
        driver.findElement(By.xpath("//a[@class='_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy']")).click();
        // isim kutusunu locate edip,
        Actions actions=new Actions(driver);
        Faker faker =new Faker();
        String fakename = faker.name().firstName();
        driver.findElement(By.name("firstname")).sendKeys(faker.name().firstName());
        actions.sendKeys(Keys.TAB)
                .sendKeys(faker.name().lastName())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.internet().emailAddress())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.internet().password())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.internet().password())
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB).perform();
                actions  .sendKeys("24")
                .sendKeys(Keys.TAB)
                .sendKeys("Haz" +Keys.TAB)
                .sendKeys("1999" +  Keys.TAB)
        .sendKeys(Keys.TAB)
        .sendKeys(Keys.TAB)
        .sendKeys(Keys.TAB)
        .sendKeys(Keys.TAB)
        .sendKeys(Keys.TAB).perform();
        Thread.sleep(3000);
        // geriye kalan alanlari TAB ile dolasarak
        // formu doldurun


        }
}
