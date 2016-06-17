package tests;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;
import myObjectRepo.*;
import org.openqa.selenium.Point;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import myServiceClasses.TestTemplate;

public class RemindersTests extends TestTemplate {
   public RemindersTests(AndroidDriver driver) {
      super(driver);
   }

   public RemindersTests() {
   }

   //      @Test(dataProvider = "reminderTest", dataProviderClass = MyDataProviders.class)
   @Test(dataProvider = "reminderTest", dataProviderClass = MyDataProviders.class, dependsOnGroups = {"login"}, groups = {"insulin"})
   public void addInsulinReminderTest(String username, String password, String insulin, String quantity) {
      /**
       * Method adds insulin reminder and verifies reminder's appearance and history.
       * Reminder scheduled in +2 minutes from device time using data-driven
       * insulins and quantities from excel spreadsheet.
       */
      LoginTests loginTests = new LoginTests(driver);
      loginTests.login(username, password);
      logger.info("Logged in successfully");

      TouchAction touchAction = new TouchAction(driver);
      WebDriverWait wait = new WebDriverWait(driver, 30);
      HomeScreen homeScreen = new HomeScreen(driver);
      int minutes;
      int hours;
      String expectedTime;
      wait.until(ExpectedConditions.visibilityOf(homeScreen.getGetStartedTitle()));

      ScreenTemplate.getMenu(driver);
      MenuScreen menuScreen = new MenuScreen(driver);
      touchAction.tap(menuScreen.getReminders()).perform();
      RemindersScreen remindersScreen = new RemindersScreen(driver);
      touchAction.tap(remindersScreen.getAddReminderButton()).perform();
      logger.info("add reminder button tapped");
      SetRemindersScreen setRemindersScreen = new SetRemindersScreen(driver);

      touchAction.tap(setRemindersScreen.getDayOfWeekSelector()).perform();
      SelectDaysOfWeekScreen daysOfWeekScreen = new SelectDaysOfWeekScreen(driver);
      touchAction.tap(daysOfWeekScreen.getOkButton()).perform();
      logger.info("select days successful");

      touchAction.tap(setRemindersScreen.getInsulinReminderCheckbox()).perform();
      touchAction.tap(setRemindersScreen.getInsulinSelector()).perform();
      InsulinScreen insulinScreen = new InsulinScreen(driver);
      touchAction.tap(insulinScreen.selectInsulin(insulin)).perform();
      touchAction.tap(setRemindersScreen.getUnits()).perform();
      setRemindersScreen.setUnits(quantity);

      driver.pressKeyCode(AndroidKeyCode.ENTER);

      //Schedule time
      setRemindersScreen.scrollToSchedule();
      touchAction.tap(setRemindersScreen.getTimeSelector()).perform();
      ScheduleTimeScreen scheduleTimeScreen = new ScheduleTimeScreen(driver);
      minutes = Integer.parseInt(scheduleTimeScreen.getMinutesSelector().getText());

      touchAction.tap(scheduleTimeScreen.getMinutesSelector()).perform();

      if (minutes < 58) {
         scheduleTimeScreen.setMinutes(minutes);
      } else {
         hours = Integer.parseInt(scheduleTimeScreen.getHoursSelector().getText());
         touchAction.tap(scheduleTimeScreen.getHoursSelector()).perform();
         Point hoursTouch = scheduleTimeScreen.getHoursPoint(hours + 1);
         touchAction.tap(hoursTouch.getX(), hoursTouch.getY()).perform();
         touchAction.tap(scheduleTimeScreen.getMinutesSelector()).perform();
         Point minutesTouch = scheduleTimeScreen.getMinutesPoint(0);
         touchAction.tap(minutesTouch.getX(), minutesTouch.getY()).perform();
      }
      touchAction.tap(scheduleTimeScreen.getOkButton()).perform();
      expectedTime = setRemindersScreen.getTimeSelector().getText();
      touchAction.tap(setRemindersScreen.getSaveButton()).perform();

      //Waiting for reminder
      ReminderPopupScreen reminderPopup = new ReminderPopupScreen(driver);
      wait = new WebDriverWait(driver, 181);
      wait.until(ExpectedConditions.visibilityOf(reminderPopup.getTookItButton()));

      logger.info("Reminder appeared. Verifying history");
      touchAction.tap(reminderPopup.getTookItButton()).perform();
      logger.info("Pop up acknowledged");
      ScreenTemplate.getMenu(driver);
      touchAction.tap(menuScreen.getHistory()).perform();

      HistoryScreen historyScreen = new HistoryScreen(driver);
      String actualMedication = historyScreen.getLastReminderMedication().getText();
      String actualUnits = historyScreen.getLastReminderUnits().getText();
      String actualTime = historyScreen.getLastReminderTime().getText();

      //Assertion
      Assert.assertEquals(actualMedication, insulin);
      logger.info("Insulin type asserted");
      Assert.assertEquals(actualUnits, quantity + ".00 units");
      logger.info("Units asserted");
      Assert.assertEquals(actualTime, expectedTime);
      logger.info("Reminder Time asserted");
   }
}
