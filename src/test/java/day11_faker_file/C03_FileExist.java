package day11_faker_file;

import org.junit.Assert;
import org.junit.Test;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class C03_FileExist {
    @Test
    public void test01(){
        System.out.println(System.getProperty("user.dir"));//dosya yolunu verir
        System.out.println(System.getProperty("user.home"));// bilgisayarımın özel kısmını verir.
        // src/test/java/day11_faker_file/C03_FileExist.java
        // C:\Users\HÖ\IdeaProjects\com.Batch59Junit\src\test\java\day11_faker_file\C03_FileExist.java

        String dosyayolu=System.getProperty("user.home")+"\\Desktop\\text.txt";
        System.out.println(dosyayolu); //masa üstündeki bir dosyanın varlığını test etmek için önce o dosya ya ulaşmamız gereki. Javada dosyay erişim için dosya yoluna yani path ihtiyaç vardır.
        // her bilgisayarın kullanıcı adı farklı olacağından masa üstü yoluda bir birinden farklıl olacaktır. Testlerimizin tüm bilgisayarlarda çalışması için dinamik yapmak zorundayız. bunun için her bilgisayarın birbirinden farklı olan yolunu bulmak için
        // Sistem.getproperty("user.home"). herkesin bilgisayarında ortak olan kısım ise
        String farkliKisim=System.getProperty("user.home");
        String ortakKisim="\\Desktop\\text.txt";
        String dosyaYolu=farkliKisim+ortakKisim;
        System.out.println(Files.exists(Paths.get(dosyaYolu)));
        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));
    }
}
