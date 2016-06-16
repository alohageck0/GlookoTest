package tests;

import io.appium.java_client.TouchAction;
import objectRepo.WelcomeScreen;
import serviceClasses.TestTemplate;
import io.appium.java_client.android.AndroidDriver;
import org.testng.annotations.Test;

public class Temp extends TestTemplate {
   public Temp(AndroidDriver driver) {
      super(driver);
   }

   public Temp() {
   }

   @Test
   public void login() throws InterruptedException {
      TouchAction touchAction = new TouchAction(driver);
      WelcomeScreen welcomeScreen = new WelcomeScreen(driver);
      touchAction.tap(welcomeScreen.getSignUpButton()).perform();
      Thread.sleep(3000l);

      logger.info("Test");
   }
}
