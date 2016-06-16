package tests;

import io.appium.java_client.android.AndroidDriver;
import org.testng.annotations.Test;
import serviceClasses.TestTemplate;

public class RemindersTests extends TestTemplate {
   public RemindersTests(AndroidDriver driver) {
      super(driver);
   }

   public RemindersTests() {
   }


   @Test(dataProvider = "loginUsers", dataProviderClass = MyDataProviders.class, dependsOnGroups = {"login"})
   public void insulinTest(String username, String password) {
      LoginTests loginTests = new LoginTests(driver);
      loginTests.login(username, password);
      logger.info("Logged in succesfully");

   }
}
