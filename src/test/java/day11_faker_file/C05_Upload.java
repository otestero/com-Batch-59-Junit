package day11_faker_file;

import org.junit.Test;
import utilities.TestBase;

public class C05_Upload extends TestBase {
//    1.Tests packagenin altina bir class oluşturun : C05_UploadFile
//2.https://the-internet.herokuapp.com/upload adresine gidelim
//            3.chooseFile butonuna basalim
//4.Yuklemek istediginiz dosyayi secelim.
//            5.Upload butonuna basalim.
//6.“File Uploaded!” textinin goruntulendigini test edelim.
    @Test
    public void test01(){
      driver.get("https://the-internet.herokuapp.com/upload");
    }
}
