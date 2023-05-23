package tests.day18_TestNGReports_ParalelCalistirma;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.Driver;
import utilities.TestBaseRapor;

public class C02_RaporluSoftAssert extends TestBaseRapor {

    @Test
    public void test01() throws InterruptedException {
        extentTest =extentReports.createTest("Alert Test",
                "Kullanici JS alert'leri calıştırabilmeli ve kapatabilmeli");
        // 1. Test
        //            -  https://the-internet.herokuapp.com/javascript_alerts adresine gidin
        Driver.getDriver().get("https://the-internet.herokuapp.com/javascript_alerts");
        extentTest.info("Ilk alert butonuna click yapar");

        //            - 1.alert'e tiklayin
        Thread.sleep(3000);
        WebElement ilkAlertElementi = Driver.getDriver().findElement(By.xpath("//*[text()='Click for JS Alert']"));
        ilkAlertElementi.click();

        //            -  Alert'deki yazinin "I am a JS Alert" oldugunu test edin
        Thread.sleep(3000);

        String expectedAlertYazisi = "I am a JS Alert";
        String actualAlertYazisi = Driver.getDriver().switchTo().alert().getText();

        SoftAssert softAssert = new SoftAssert();
        extentTest.info("softassert ile alert yazisinin beklenen değere sahip olduğunu test eder");
        // Assert.assertEquals(expectedAlertYazisi,actualAlertYazisi);
        softAssert.assertEquals(actualAlertYazisi,expectedAlertYazisi,"alertteki yazi belirlenenden farkli");

        //            -  OK tusuna basip alert'i kapatin

        Driver.getDriver().switchTo().alert().accept();
        extentTest.info("alert'i kapatir");

        // allert'in kapatildigini test edin

        // Assert.assertTrue(ilkAlertElementi.isEnabled());

        softAssert.assertTrue(ilkAlertElementi.isEnabled(),"alert kapatilamadi");
        extentTest.info("soft assert ile allert'in kapatildiğini test eder");

        softAssert.assertAll();
        extentTest.pass("soft assert ile yapilan tum testlerin sonucunu raporlar");

        Driver.closeDriver();
        extentTest.info("sayfayi kapatir");
    }

}
