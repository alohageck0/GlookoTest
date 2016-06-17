package myObjectRepo;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HistoryScreen extends ScreenTemplate {
   private List<WebElement> elements;

   public HistoryScreen(AndroidDriver driver) {
      super(driver);
      elements = driver.findElements(By.id("com.glooko.logbook:id/history_medication_item"));
   }

   @FindBy(id = "com.glooko.logbook:id/history_medication_item")
   WebElement medicationItem;

   public WebElement getLastReminderTime() {
      return elements.get(0).findElement(By.id("com.glooko.logbook:id/history_medication_time"));
   }

   public WebElement getLastReminderUnits() {
      return elements.get(0).findElement(By.id("com.glooko.logbook:id/history_medication_units"));
   }

   public WebElement getLastReminderMedication() {
      return elements.get(0).findElement(By.id("com.glooko.logbook:id/history_medication_text"));
   }
}
