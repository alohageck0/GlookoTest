package myObjectRepo;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class ScreenTemplate {
    private AndroidDriver driver;

    public ScreenTemplate(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public static void getMenu(AndroidDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, 40);
        WebElement toolbar = driver.findElement(By.id("com.glooko.logbook:id/toolbar"));
        wait.until(ExpectedConditions.visibilityOf(toolbar));
        int screenWidth = toolbar.getSize().getWidth();
        int startX = toolbar.getLocation().getX() + 10;
        int endX = (int) (screenWidth * 0.8);
        int startEndY = toolbar.getLocation().getY();
        driver.swipe(startX, startEndY, endX, startEndY, 400);
    }


    public AndroidDriver getDriver() {
        return driver;
    }

}
