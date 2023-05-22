package tests.day16_POM_Assertions;

import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.Driver;

public class C01_DriverClassSonHali {

    //3 tane test methodu oluşuralim
    //1.method'da amazona gidip,url'in amazon içerdiğini test edin
    @Test
    public void amazonTest(){
        Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));

        String expectedIcerik ="amazon";
        String actualUrl =Driver.getDriver().getCurrentUrl();
        Assert.assertTrue(actualUrl.contains(expectedIcerik));
        Driver.closeDriver();
    }
    //2.method'da Wisequarter anasayfaya gidip ,title'in wisequarter içerdiğini test edin

    @Test
    public void wiseTest(){
        Driver.getDriver().get(ConfigReader.getProperty("wiseUrl"));
        String expectedIcerik ="wisequarter";
        String actualTitle =Driver.getDriver().getTitle();
        Assert.assertTrue(actualTitle.contains(expectedIcerik));
        Driver.closeDriver();

    }

    //3.method'da Facebook anasayfaya gidip, title'in facebook içerdiğini test edin
    @Test
    public void facebookTesti(){
        Driver.getDriver().get(ConfigReader.getProperty("faceUrl"));
        String expectedIcerik ="facebook";
        String actualTitle =Driver.getDriver().getTitle();
        Assert.assertTrue(actualTitle.contains(expectedIcerik));
        Driver.closeDriver();

    }

    //her methodda yeni driver oluşturup, method sonunda driver'i kapatin
}
