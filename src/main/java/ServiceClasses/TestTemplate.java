package serviceClasses;

import io.appium.java_client.android.AndroidDriver;
import objectRepo.ScreenTemplate;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public abstract class TestTemplate {
   private File appDir = new File("src");
   private MyAppiumConfig config = new MyAppiumConfig();
   protected AndroidDriver driver;
   protected Logger logger = Logger.getLogger(this.getClass().getName());

   public TestTemplate(AndroidDriver driver) {
      this.driver = driver;
   }

   public TestTemplate() {
   }

   @BeforeSuite(alwaysRun = true)
   public void setUp() throws MalformedURLException {
      config.setServerArguments();
      config.startAppiumServer();
      PropertyConfigurator.configure(new File(appDir, "log4j.properties").getAbsolutePath());
      this.driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), config.getCapabilities());
   }

   @AfterSuite(alwaysRun = true)
   public void tearDown() {

      driver.quit();
      config.cleanUp();
   }

   public static void getMenu(AndroidDriver driver) {
      WebDriverWait wait = new WebDriverWait(driver, 15);
      wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("com.glooko.logbook:id/toolbar"))));
      driver.swipe(10, 280, 350, 280, 400);
   }
}
