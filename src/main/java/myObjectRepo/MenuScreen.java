package myObjectRepo;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class MenuScreen extends ScreenTemplate {
   private List<WebElement> elements;

   public MenuScreen(AndroidDriver driver) {
      super(driver);
      elements = navigationList.findElements(By.className("android.widget.TextView"));
   }

   @FindBy(id = "com.glooko.logbook:id/nav_drawer_add_event_button")
   WebElement addEvent;

   @FindBy(id = "com.glooko.logbook:id/navigation_list")
   WebElement navigationList;

   public WebElement getHistory() {
      return elements.get(1);
   }

   public WebElement getReminders() {
      return elements.get(5);
   }

   public WebElement getSettings() {
      return elements.get(6);
   }


   public WebElement getAddEvent() {
      return addEvent;
   }
}
