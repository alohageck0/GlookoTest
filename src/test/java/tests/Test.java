package tests;

import io.appium.java_client.android.AndroidDriver;
import myServiceClasses.TestTemplate;

public class Test extends TestTemplate {
   public Test(AndroidDriver driver) {
      super(driver);
   }

   public Test() {
   }

   @org.testng.annotations.Test
   public void test() throws InterruptedException {
      Thread.sleep(10000);
      System.out.println("test");
   }

   @org.testng.annotations.Test
   public void test1(){

   }
}
