package tests;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import objectRepo.HomeScreen;
import objectRepo.LoginScreen;
import objectRepo.WelcomeScreen;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import serviceClasses.TestTemplate;

public class RemindersTests extends TestTemplate {
   public RemindersTests(AndroidDriver driver) {
      super(driver);
   }

   public RemindersTests() {
   }

   @Test(dataProvider = "loginUsers", dataProviderClass = MyDataProviders.class)
   public void login(String username, String password) {
      TouchAction touchAction = new TouchAction(driver);
      WelcomeScreen welcomeScreen = new WelcomeScreen(driver);
      LoginScreen loginScreen = new LoginScreen(driver);
      HomeScreen homeScreen = new HomeScreen(driver);
      touchAction.tap(welcomeScreen.getLoginButton()).perform();
      touchAction.tap(loginScreen.getUsername_field_login()).perform();
      loginScreen.getUsername_field_login().sendKeys(username);
      touchAction.tap(loginScreen.getPassword_field_login()).perform();
      loginScreen.getPassword_field_login().sendKeys(password);
      touchAction.tap(loginScreen.getLog_in_button()).perform();
      WebDriverWait wait = new WebDriverWait(driver, 20);
      wait.until(ExpectedConditions.visibilityOf(homeScreen.getGetStartedTitle()));
      Assert.assertEquals(homeScreen.getGetStartedTitle().getText(), "Get Started!");
      logger.info("Home screen asserted");
   }

   @Test(dependsOnMethods = {"login"}, dataProvider = "loginUsers", dataProviderClass = MyDataProviders.class)
   public void insulinTest(String username, String password) {
      login(username, password);

   }
}
