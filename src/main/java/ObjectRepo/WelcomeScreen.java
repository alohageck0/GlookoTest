package objectRepo;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WelcomeScreen extends ScreenTemplate {
   public WelcomeScreen(AndroidDriver driver) {
      super(driver);
   }

   @FindBy(id = "com.glooko.logbook:id/sign_up")
   WebElement signUpButton;
   @FindBy(id = "com.glooko.logbook:id/login")
   WebElement loginButton;


   public WebElement getSignUpButton() {
      return signUpButton;
   }

   public WebElement getLoginButton() {
      return loginButton;
   }
}
