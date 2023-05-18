package tests.day14_TestNGFramework;

import org.testng.annotations.Test;

public class C03_DependsOnMethods {
    /*
       DependsOnmethods oncelik sirasina karismaz
       dependsOnMethods bir test method'un calismasini
       baska bir method'un calisip passed olmasina baglar
       baglanilan method calismaz veya calisr ama failed olursa
       baglanan method hic calismaz
    */

    @Test(dependsOnMethods = "wiseTesti")
    public void youtubeTesti(){
        System.out.println("Youtube");
    }
    @Test(priority = 3)
    public void wiseTesti(){
        System.out.println("Wise Quarter");
    }
    @Test(dependsOnMethods = "youtubeTesti")
    public void amazonTesti(){ // priority yazilmazsa 0 degeri alir
        System.out.println("Amazon");
    }
}
