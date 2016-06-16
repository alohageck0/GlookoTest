package objectRepo;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SetRemindersScreen extends ScreenTemplate {
   public SetRemindersScreen(AndroidDriver driver) {
      super(driver);
   }

   @FindBy(id = "com.glooko.logbook:id/lblTime")
   WebElement timeSelector;

   @FindBy(id = "com.glooko.logbook:id/lblDayOfWeek")
   WebElement dayOfWeekSelector;

   @FindBy(id = "com.glooko.logbook:id/chbInsulinReminder")
   WebElement insulinReminder;

   @FindBy(id = "com.glooko.logbook:id/mniSaveReminder")
   WebElement saveButton;

   @FindBy(id = "com.glooko.logbook:id/medication_spinner")
   WebElement insulinSelector;

   @FindBy(id = "com.glooko.logbook:id/reminders_units_edittext")
   WebElement units;

   @FindBy(id = "com.glooko.logbook:id/add_more_row_button")
   WebElement addMoreRow;

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

   public WebElement getInsulinReminder() {
      return insulinReminder;
   }

   public WebElement getInsulinSelector() {
      return insulinSelector;
   }

   public WebElement getUnits() {
      return units;
   }
}
