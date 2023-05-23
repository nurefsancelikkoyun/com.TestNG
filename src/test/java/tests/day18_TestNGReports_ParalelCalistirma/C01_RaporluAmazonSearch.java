package tests.day18_TestNGReports_ParalelCalistirma;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AmazonPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

public class C01_RaporluAmazonSearch extends TestBaseRapor {

    @Test
    public void test01(){
        extentTest =extentReports.createTest("Amazon arama testi",
                                            "Kullanici istediği kelimeyi aratabilmeli");
        //amazona gidin
        Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));
        extentTest.info("Kullanici amazon anasayfaya gider");

        //Nutella için arama yapin
        AmazonPage amazonPage = new AmazonPage();
        amazonPage.aramaKutusu.sendKeys(ConfigReader.getProperty("amazonAranacakKelime")+ Keys.ENTER);
        extentTest.info("Arama kutusuna belirlenen aranacak kelimeyi yazar ve aratir");

        //arama sonuçlarının Nutella içerdiğini test edin
        String actualSonucYazisi =amazonPage.aramaSonucuElementi.getText();
        String expectedIcerik =ConfigReader.getProperty("amazonExpectedIcerik");

        Assert.assertTrue(actualSonucYazisi.contains(expectedIcerik));
        extentTest.pass("Belirlenen aranacak kelime aratildiğinda ,arama sonucunda expected içerik olduğu test edildi");

        Driver.closeDriver();
    }
}
