package tests;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import objectRepo.*;
import org.testng.annotations.Test;
import serviceClasses.SetRemTest;

public class Temp extends SetRemTest {
   public Temp(AndroidDriver driver) {
      super(driver);
   }

   public Temp() {
   }

   @Test
   public void test() {
      TouchAction touchAction = new TouchAction(driver);
      LoginTests loginTests = new LoginTests(driver);
      RemindersScreen remindersScreen = new RemindersScreen(driver);
      SetRemindersScreen setRemindersScreen = new SetRemindersScreen(driver);
      ScheduleTimeScreen scheduleTimeScreen = new ScheduleTimeScreen(driver);
      int minutes;

//
////      loginTests.login(username, password);
////      logger.info("Logged in succesfully");
//      getMenu(driver);
//      MenuScreen menuScreen = new MenuScreen(driver);
//      touchAction.tap(menuScreen.getReminders()).perform();
//      touchAction.tap(remindersScreen.getAddReminderButton()).perform();
//      touchAction.tap(setRemindersScreen.getTimeSelector()).perform();
      minutes = Integer.parseInt(scheduleTimeScreen.getMinutesSelector().getText());
      touchAction.tap(scheduleTimeScreen.getMinutesSelector()).perform();

      touchAction.tap(scheduleTimeScreen.setMinutes(22));

      scheduleTimeScreen.getMinutesSelector().sendKeys(Integer.toString(33));

      touchAction.tap(scheduleTimeScreen.getOkButton()).perform();
   }
}
