package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumTest {

   @org.testng.annotations.Test
   public void test() throws InterruptedException {
      System.setProperty("webdriver.chrome.driver", "/Users/evgenii/automation/chromedriver");

      WebDriver driver = new ChromeDriver();
      driver.get("http://forbes.com");
      WebElement search = (new WebDriverWait(driver, 60))
              .until(ExpectedConditions.presenceOfElementLocated(By.className("icon icon-forbes-logo")));
      String source = driver.getPageSource();
      System.out.println(source);
      driver.quit();
   }
}
