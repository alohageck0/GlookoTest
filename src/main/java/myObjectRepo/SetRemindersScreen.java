package myObjectRepo;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SetRemindersScreen extends ScreenTemplate {
   private List<WebElement> screen;

   public SetRemindersScreen(AndroidDriver driver) {
      super(driver);
      screen = driver.findElementsByClassName("android.widget.LinearLayout");
   }

   @FindBy(id = "com.glooko.logbook:id/lblTime")
   WebElement timeSelector;

   @FindBy(id = "com.glooko.logbook:id/lblDayOfWeek")
   WebElement dayOfWeekSelector;

   @FindBy(id = "com.glooko.logbook:id/chbInsulinReminder")
   WebElement insulinReminderCheckbox;

   @FindBy(id = "com.glooko.logbook:id/mniSaveReminder")
   WebElement saveButton;

   @FindBy(id = "com.glooko.logbook:id/medication_spinner")
   WebElement insulinSelector;

   @FindBy(id = "com.glooko.logbook:id/reminders_units_edittext")
   WebElement units;

   @FindBy(id = "com.glooko.logbook:id/add_more_row_button")
   WebElement addMoreRow;

   @FindBy(id = "com.glooko.logbook:id/lblReminderTypeHeader")
   WebElement remindersHeader;

   private WebElement getScreen() {
      return screen.get(0);
   }

   public WebElement getRemindersHeader() {
      return remindersHeader;
   }

   public WebElement getAddMoreRow() {
      return addMoreRow;
   }

   public WebElement getSaveButton() {
      return saveButton;
   }

   public WebElement getTimeSelector() {
      return timeSelector;
   }

   public WebElement getDayOfWeekSelector() {
      return dayOfWeekSelector;
   }

   public WebElement getInsulinReminderCheckbox() {
      return insulinReminderCheckbox;
   }

   public WebElement getInsulinSelector() {
      return insulinSelector;
   }

   public WebElement getUnits() {
      return units;
   }

   public void scrollToSchedule() {
      int startX = getScreen().getSize().getWidth() / 2;
      int startY = getScreen().getSize().getHeight() + (int) ((getScreen().getSize().getHeight()) * 0.8);
      int endY = getScreen().getSize().getHeight() + (int) ((getScreen().getSize().getHeight()) * 0.1);
      TouchAction touchAction = new TouchAction(getDriver());
      touchAction.longPress(startX, startY).moveTo(startX, endY).release().perform();
   }

   public void setUnits(String quantity) {
      getDriver().pressKeyCode(convertToKeycode(quantity));
   }

   private int convertToKeycode(String number) {
      int num = Integer.parseInt(number);
      int keyCode = 0;
      switch (num) {
         case 0:
            keyCode = AndroidKeyCode.KEYCODE_NUMPAD_0;
            break;
         case 2:
            keyCode = AndroidKeyCode.KEYCODE_NUMPAD_2;
            break;
      }
      return keyCode;
   }
}
