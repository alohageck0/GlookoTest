package myObjectRepo;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ReminderPopupScreen extends ScreenTemplate {
   public ReminderPopupScreen(AndroidDriver driver) {
      super(driver);
   }

   @FindBy(id = "com.glooko.logbook:id/btnOk")
   WebElement tookItButton;
   @FindBy(id = "com.glooko.logbook:id/lblScheduledTime")
   WebElement scheduledTime;

   @FindBy(id = "com.glooko.logbook:id/txtQuantity")
   WebElement quantity;

   public WebElement getTookItButton() {
      return tookItButton;
   }

   public WebElement getScheduledTime() {
      return scheduledTime;
   }

   public WebElement getQuantity() {
      return quantity;
   }
}
