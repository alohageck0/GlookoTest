package myObjectRepo;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SelectDaysOfWeekScreen extends ScreenTemplate {
   public SelectDaysOfWeekScreen(AndroidDriver driver) {
      super(driver);
   }

   @FindBy(id = "android:id/button1")
   WebElement okButton;

   public WebElement getOkButton() {
      return okButton;
   }
}
