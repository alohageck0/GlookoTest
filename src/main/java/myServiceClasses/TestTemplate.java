package myServiceClasses;

import io.appium.java_client.android.AndroidDriver;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

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

   @BeforeClass(alwaysRun = true)
   public void setUp() throws MalformedURLException {
      config.setServerArguments();
      config.startAppiumServer();
      PropertyConfigurator.configure(new File(appDir, "log4j.properties").getAbsolutePath());
      this.driver = new AndroidDriver(new URL("http://127.0.0.1:4444/wd/hub"), config.getCapabilities());
   }

   @AfterClass(alwaysRun = true)
   public void tearDown() {

      driver.quit();
//      config.cleanUp();
   }

}
