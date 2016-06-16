package objectRepo;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ScheduleTimeScreen extends ScreenTemplate {
   private List<WebElement> elements;
   int centerX;
   int centerY;
   int radius;


   public ScheduleTimeScreen(AndroidDriver driver) {
      super(driver);
      centerX = findCenterX();
      centerY = findCenterY();
      elements = driver.findElementsByClassName("android.widget.RadialTimePickerView.RadialPickerTouchHelper");
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
   public WebElement getZero(){
      return elements.get(0);
   }

   public void printCenter() {
      System.out.println(centerX + "  " + centerY);
   }

   private int findCenterX() {
      centerX = getRadialPicker().getLocation().getX() + (getRadialPicker().getSize().getHeight() / 2);
      return centerX;
   }

   private int findCenterY() {
      centerY = getRadialPicker().getLocation().getY() + (getRadialPicker().getSize().getWidth() / 2);
      return centerY;
   }

   public int getXHours() {
      return 1;
   }
}
