package day13_cookies_webTables;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.util.List;

public class VC02 extends TestBase {
    //            ● Bir class oluşturun : C02_WebTables
//            ● login( ) metodun oluşturun ve oturum açın.
    @Test
    public void webTable1() {
        login();
// ● Bir class oluşturun : C02_WebTables
////            ● login( ) metodun oluşturun ve oturum açın.
//    @Test
//    public void webTable(){
//       //  ● https://www.hotelmycamp.com admin/HotelRoomAdmin adresine gidin
//       //      Username : manager
////             Password : Manager1!
////            ○ Tüm table body’sinin boyutunu(sutun sayisi) bulun. /tbody
        List<WebElement> bodySutunSayisi= driver.findElements(By.xpath("//thead//tr//th"));
        int sayac=0;
        for (WebElement each: bodySutunSayisi
             ) {sayac++;
        }System.out.println("sutunSayisi: "+sayac);
////            ○ Table’daki tum body’I ve başlıkları(headers) konsolda yazdırın.
        for (WebElement each: bodySutunSayisi
             ) {
            System.out.println( each.getText());
        }
         // ● printRows( ) metodu oluşturun //tr
        // ○ table body’sinde bulunan toplam satir(row) sayısını bulun.
        List<WebElement> bodySatirlari=driver.findElements(By.xpath("//tbody//tr"));
        int sayac1=0;
        for (WebElement each: bodySatirlari
        ) {sayac1++;
        }System.out.println("sutunSayisi: "+sayac1);
////             ○ Table body’sinde bulunan satirlari(rows) konsolda yazdırın.
        for (WebElement each: bodySatirlari
             ) {
            System.out.println(each.getText());
                    }
////            ○ 4.satirdaki(row) elementleri konsolda yazdırın.

        // ○  e mail sütünundaki tüm elementleri konsolda yazdırın.

////

    }

    private void login() {
        driver.get("https://www.hotelmycamp.com");
        driver.findElement(By.xpath("//*[text()='Log in']")).click();
        driver.findElement(By.xpath("//input[@id='UserName']")).sendKeys("manager" + Keys.TAB);
        driver.findElement(By.xpath("//input[@class='form-control required password']")).sendKeys("Manager1!");
        driver.findElement(By.id("btnSubmit")).click();
       // Bir class oluşturun : C02_WebTables
////            ● login( ) metodun oluşturun ve oturum açın.
//    @Test
//    public void webTable(){
//       //  ● https://www.hotelmycamp.com admin/HotelRoomAdmin adresine gidin
//       //      Username : manager
////             Password : Manager1!
////            ○ Tüm table body’sinin boyutunu(sutun sayisi) bulun. /tbody
////            ○ Table’daki tum body’I ve başlıkları(headers) konsolda yazdırın.
////            ● printRows( ) metodu oluşturun //tr
////            ○ table body’sinde bulunan toplam satir(row) sayısını bulun.
////            ○ Table body’sinde bulunan satirlari(rows) konsolda yazdırın.
////            ○ 4.satirdaki(row) elementleri konsolda yazdırın.
        // ○  e mail sütünundaki tüm elementleri konsolda yazdırın.
    }
}