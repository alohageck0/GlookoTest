package objectRepo;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public abstract class ScreenTemplate {
   private AndroidDriver driver;

   public ScreenTemplate(AndroidDriver driver) {
      this.driver = driver;
      PageFactory.initElements(new AppiumFieldDecorator(driver), this);
   }

   @FindBy(id = "com.glooko.logbook:id/toolbar")
   WebElement toolbar;

   public WebElement getToolbar() {
      return toolbar;
   }
}
