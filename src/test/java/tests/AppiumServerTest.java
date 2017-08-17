package tests;

import io.appium.java_client.service.local.AppiumDriverLocalService;

public class AppiumServerTest {

   @org.testng.annotations.Test
   public void test(){

      AppiumDriverLocalService service = AppiumDriverLocalService.buildDefaultService();
      service.start();
//your test scripts logic...
      service.stop();

   }
}
