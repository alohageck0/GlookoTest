package objectRepo;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountScreen extends ScreenTemplate {
   public AccountScreen(AndroidDriver driver) {
      super(driver);
   }

   @FindBy(id = "com.glooko.logbook:id/log_out_button")
   WebElement logoutButton;

   public WebElement getLogoutButton() {
      return logoutButton;
   }
}
