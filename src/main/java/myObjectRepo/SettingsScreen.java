package myObjectRepo;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SettingsScreen extends ScreenTemplate {
   public SettingsScreen(AndroidDriver driver) {
      super(driver);
   }

   @FindBy(id = "com.glooko.logbook:id/account_button")
   WebElement accountButton;

   public WebElement getAccountButton() {
      return accountButton;
   }
}
