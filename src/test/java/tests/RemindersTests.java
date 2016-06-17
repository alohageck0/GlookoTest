package tests;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import objectRepo.MenuScreen;
import objectRepo.RemindersScreen;
import objectRepo.ScheduleTimeScreen;
import objectRepo.SetRemindersScreen;
import org.openqa.selenium.Point;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import serviceClasses.TestTemplate;

public class RemindersTests extends TestTemplate {
    public RemindersTests(AndroidDriver driver) {
        super(driver);
    }

    public RemindersTests() {
    }

    //   @AfterClass
    public void tearDown() {
        logger.info("Started logout");
        LoginTests loginTests = new LoginTests(driver);
        loginTests.logout();
    }

    @Test(dataProvider = "loginUsers", dataProviderClass = MyDataProviders.class)
    public void addInsulinReminderTest(String username, String password) {
        TouchAction touchAction = new TouchAction(driver);
        LoginTests loginTests = new LoginTests(driver);
        RemindersScreen remindersScreen = new RemindersScreen(driver);
        SetRemindersScreen setRemindersScreen = new SetRemindersScreen(driver);
        ScheduleTimeScreen scheduleTimeScreen = new ScheduleTimeScreen(driver);
        int minutes;


        loginTests.login(username, password);
        logger.info("Logged in succesfully");
        getMenu(driver);
        MenuScreen menuScreen = new MenuScreen(driver);
        touchAction.tap(menuScreen.getReminders()).perform();
        touchAction.tap(remindersScreen.getAddReminderButton()).perform();
        touchAction.tap(setRemindersScreen.getTimeSelector()).perform();
        minutes = Integer.parseInt(scheduleTimeScreen.getMinutesSelector().getText());
        touchAction.tap(scheduleTimeScreen.getMinutesSelector()).perform();
        scheduleTimeScreen.getMinutesSelector().sendKeys(Integer.toString(minutes + 1));
        touchAction.tap(scheduleTimeScreen.getOkButton()).perform();
    }

    @Test
    public void test() throws InterruptedException {
        TouchAction touchAction = new TouchAction(driver);
        LoginTests loginTests = new LoginTests(driver);
        RemindersScreen remindersScreen = new RemindersScreen(driver);
        SetRemindersScreen setRemindersScreen = new SetRemindersScreen(driver);
        int minutes;
        int hours;

//      loginTests.login(username, password);
//      logger.info("Logged in succesfully");
        getMenu(driver);
        MenuScreen menuScreen = new MenuScreen(driver);
        touchAction.tap(menuScreen.getReminders()).perform();
        touchAction.tap(remindersScreen.getAddReminderButton()).perform();
        touchAction.tap(setRemindersScreen.getTimeSelector()).perform();
        ScheduleTimeScreen scheduleTimeScreen = new ScheduleTimeScreen(driver);
        minutes = Integer.parseInt(scheduleTimeScreen.getMinutesSelector().getText());

        touchAction.tap(scheduleTimeScreen.getMinutesSelector()).perform();
        Point touchPoint = scheduleTimeScreen.getMinutesPoint(6);
        touchAction.tap(touchPoint.getX(),touchPoint.getY()).perform();
Thread.sleep(3000);
         touchPoint = scheduleTimeScreen.getMinutesPoint(26);
        touchAction.tap(touchPoint.getX(),touchPoint.getY()).perform();
        Thread.sleep(3000);

         touchPoint = scheduleTimeScreen.getMinutesPoint(51);
        touchAction.tap(touchPoint.getX(),touchPoint.getY()).perform();
//        if (minutes == 59) {
//            hours = Integer.parseInt(scheduleTimeScreen.getHoursSelector().getText());
//
//            touchAction.tap(scheduleTimeScreen.getHoursSelector()).perform();
//            Point hoursTouch = scheduleTimeScreen.getHoursPoint(hours);
//            touchAction.tap(hoursTouch.getX(), hoursTouch.getY()).perform();
//
//            touchAction.tap(scheduleTimeScreen.getMinutesSelector()).perform();
//            Point minutesTouch = scheduleTimeScreen.getMinutesPoint(minutes + 1);
//            touchAction.tap(minutesTouch.getX(), minutesTouch.getY()).perform();
//        }else {
//            touchAction.tap(scheduleTimeScreen.getMinutesSelector()).perform();
//            Point minutesTouch = scheduleTimeScreen.getMinutesPoint(minutes + 1);
//            touchAction.tap(minutesTouch.getX(), minutesTouch.getY()).perform();
//        }

//      touchAction.tap(scheduleTimeScreen.getOkButton()).perform();
    }
}
