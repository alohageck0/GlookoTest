package myObjectRepo;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PopupScreen extends ScreenTemplate {
   public PopupScreen(AndroidDriver driver) {
      super(driver);
   }

   @FindBy(id = "android:id/button1")
   WebElement yesButton;

   public WebElement getYesButton() {
      return yesButton;
   }
}
