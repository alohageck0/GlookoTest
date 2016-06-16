package serviceClasses;

import com.github.genium_framework.appium.support.server.AppiumServer;
import com.github.genium_framework.server.ServerArguments;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;

public final class MyAppiumConfig {
   private ServerArguments serverArguments = new ServerArguments();
   private AppiumServer appiumServer;
   private DesiredCapabilities capabilities = new DesiredCapabilities();


   public void setServerArguments() throws MalformedURLException {
      serverArguments.setArgument("--address", "127.0.0.1");
      serverArguments.setArgument("--local-timezone", true);
      serverArguments.setArgument("--device-ready-timeout", "100");
      capabilities.setCapability(MobileCapabilityType.PLATFORM, Platform.ANDROID);
      capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Panel");
      capabilities.setCapability("appPackage", "com.glooko.logbook");
      capabilities.setCapability("appActivity", "com.glooko.logbook.activity.FtueActivity");
      capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 15);
   }

   public void startAppiumServer() {
      appiumServer = new AppiumServer(serverArguments);
      appiumServer.startServer();
   }

   public void cleanUp() {
      if (appiumServer.isServerRunning()) {
         appiumServer.stopServer();
      }
   }

   public DesiredCapabilities getCapabilities() {
      return capabilities;
   }
}