package objectRepo;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RemindersScreen extends ScreenTemplate {
   public RemindersScreen(AndroidDriver driver) {
      super(driver);
   }

   @FindBy(id = "com.glooko.logbook:id/mniAddReminder")
   WebElement addReminderButton;

   public WebElement getAddReminderButton() {
      return addReminderButton;
   }
}
