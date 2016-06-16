package objectRepo;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ScheduleTimeScreen extends ScreenTemplate {
   private List<WebElement> elements;

   public ScheduleTimeScreen(AndroidDriver driver) {
      super(driver);
//      elements = driver.findElementsByAndroidUIAutomator("new UiSelector().class(\"android.widget.RadialTimePickerView$RadialPickerTouchHelper\")");
   }

   @FindBy(id = "android:id/minutes")
   MobileElement minutesSelector;

   @FindBy(id = "android:id/button1")
   WebElement okButton;

   @FindBy(id = "android:id/radial_picker")
   WebElement radialPicker;

   @FindBy(id = "android:id/hours")
   MobileElement hoursSelector;

   public MobileElement getHoursSelector() {
      return hoursSelector;
   }

   public WebElement getRadialPicker() {
      return radialPicker;
   }

   public WebElement setMinutes(int minutesNow) {
      return elements.get(minutesNow % 5);
   }

   public MobileElement getMinutesSelector() {
      return minutesSelector;
   }

   public WebElement getOkButton() {
      return okButton;
   }
}
