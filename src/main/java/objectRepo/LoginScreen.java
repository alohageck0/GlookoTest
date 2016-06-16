package objectRepo;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginScreen extends ScreenTemplate {

   public LoginScreen(AndroidDriver driver) {
      super(driver);
   }

   @FindBy(id = "com.glooko.logbook:id/username_field_login")
   WebElement username_field_login;

   @FindBy(id = "com.glooko.logbook:id/password_field_login")
   WebElement password_field_login;

   @FindBy(id = "com.glooko.logbook:id/log_in_button")
   WebElement log_in_button;

   public WebElement getUsername_field_login() {
      return username_field_login;
   }

   public WebElement getPassword_field_login() {
      return password_field_login;
   }

   public WebElement getLog_in_button() {
      return log_in_button;
   }
}
