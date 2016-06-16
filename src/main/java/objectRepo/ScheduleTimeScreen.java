package objectRepo;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ScheduleTimeScreen extends ScreenTemplate {
   private List<WebElement> elements;
   private AndroidDriver driver;

   public ScheduleTimeScreen(AndroidDriver driver) {
      super(driver);
      this.driver = driver;
   }

   @FindBy(id = "android:id/minutes")
   WebElement minutesSelector;

   @FindBy(id = "android:id/button1")
   WebElement okButton;

   @FindBy(id = "android:id/radial_picker")
   WebElement radialPicker;

   public WebElement getRadialPicker() {
      return radialPicker;
   }

   public WebElement setMinutes(int minutes) {
      return driver.findElementByAndroidUIAutomator("new UiSelector().content-desc(\"30\")");
   }

   public WebElement setMinutes() {
      return driver.findElement(By.xpath("//*[@content-desc='30']"));
   }

   public WebElement getMinutesSelector() {
      return minutesSelector;
   }

   public WebElement getOkButton() {
      return okButton;
   }
}
