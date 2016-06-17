package myObjectRepo;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class InsulinScreen extends ScreenTemplate {
   private List<WebElement> elements;

   public InsulinScreen(AndroidDriver driver) {
      super(driver);
      elements = driver.findElements(By.id("com.glooko.logbook:id/medication_name"));
   }

   private WebElement getHumalog() {
      return elements.get(1);
   }

   public WebElement selectInsulin(String insulin) {
      if (insulin.equals("Humalog")) {
         return getHumalog();
      }
      return null;
   }
}
