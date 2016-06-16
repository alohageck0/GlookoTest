package tests;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import objectRepo.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import serviceClasses.TestTemplate;

public class LoginTests extends TestTemplate {
   public LoginTests(AndroidDriver driver) {
      super(driver);
   }

   public LoginTests() {
   }

   @Test(dataProvider = "loginUsers", dataProviderClass = MyDataProviders.class, groups = {"login"})
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

   @Test(groups = {"login"})
   public void logout() {
      TouchAction touchAction = new TouchAction(driver);
      SettingsScreen settingsScreen = new SettingsScreen(driver);
      AccountScreen accountScreen = new AccountScreen(driver);
      PopupScreen popupScreen = new PopupScreen(driver);
      WelcomeScreen welcomeScreen = new WelcomeScreen(driver);
      WebDriverWait wait = new WebDriverWait(driver, 15);

      wait.until(ExpectedConditions.visibilityOf(settingsScreen.getToolbar()));
      getMenu(driver);
      MenuScreen menuScreen = new MenuScreen(driver);
      wait.until(ExpectedConditions.visibilityOf(menuScreen.getAddEvent()));
      touchAction.tap(menuScreen.getSettings()).perform();
      touchAction.tap(settingsScreen.getAccountButton()).perform();
      touchAction.tap(accountScreen.getLogoutButton()).perform();
      touchAction.tap(popupScreen.getYesButton()).perform();
      wait.until(ExpectedConditions.visibilityOf(welcomeScreen.getLogo()));
      logger.info("Logout succesful");
//      wait.until(ExpectedConditions.pre);
//      Assert
   }

   @Test
   public void testMenu() throws InterruptedException {
      Thread.sleep(3000l);


      driver.swipe(10, 280, 300, 280, 1000);
      Thread.sleep(3000l);
   }
}
