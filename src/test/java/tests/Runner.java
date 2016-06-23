package tests;

import com.appium.manager.ParallelThread;
import org.testng.annotations.Test;

public class Runner {
   @Test
   public static void testApp() throws Exception {
      ParallelThread parallelThread = new ParallelThread();
      parallelThread.runner("com.test.site");
   }
}
