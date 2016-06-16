package objectRepo;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class InsulinScreen extends ScreenTemplate {
   List<WebElement> elements;

   public InsulinScreen(AndroidDriver driver) {
      super(driver);
      elements = driver.findElements(By.id("com.glooko.logbook:id/medication_name"));
   }

   public WebElement getHumalog() {
      return elements.get(1);
   }
}
