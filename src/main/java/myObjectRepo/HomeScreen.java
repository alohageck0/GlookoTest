package myObjectRepo;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HomeScreen extends ScreenTemplate {
   private List<WebElement> elements;

   public HomeScreen(AndroidDriver driver) {
      super(driver);
   }

   @FindBy(className = "android.widget.ImageButton")
   WebElement menuButton;
   @FindBy(id = "com.glooko.logbook:id/get_started_title")
   WebElement get_started_title;

//   By getStarted = new By.ById("get_started");

   public WebElement getMenuButton() {
      return menuButton;
   }

   public WebElement getGetStartedTitle() {
      return get_started_title;
   }

}
