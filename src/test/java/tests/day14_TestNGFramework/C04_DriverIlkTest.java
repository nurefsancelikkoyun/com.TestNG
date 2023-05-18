package tests.day14_TestNGFramework;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Driver;
import utilities.ReusableMethods;

public class C04_DriverIlkTest {
    /*
    POM' de driver oluşturmak için
    inheritance ile kullandığımız TestBase class'i yerine
    static yollarla ulaşabileceğimiz bir method kullanılmasi tercih edilmiştir

    Driver bizim için çok önemli olduğundan
    Driver için bağımsız bir class oluşturacağız

     */

    @Test
    public void test01(){

        //amazon ana sayfaya gidin
        Driver.getDriver().get("https://www.amazon.com");

        //Nutella için arama yapin
        WebElement aramaKutusu =Driver.getDriver().findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("Nutella" + Keys.ENTER);

        //Arama sonuçlarinin Nutella kelimesi içerdiğini test edin
        WebElement sonucElementi =Driver.getDriver().findElement(By.xpath("(//div[@class='sg-col-inner'])[1]"));

        String expectedIcerik ="Nutella";
        String actualSonucYazisi =sonucElementi.getText();
        Assert.assertTrue(actualSonucYazisi.contains(expectedIcerik));

        ReusableMethods.bekle(5);
        Driver.closeDriver();
    }
}
