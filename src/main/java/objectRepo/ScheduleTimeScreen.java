package objectRepo;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ScheduleTimeScreen extends ScreenTemplate {
    private List<WebElement> elements;
    private Point clockCenter;
    private int radius;


    public ScheduleTimeScreen(AndroidDriver driver) {
        super(driver);
        clockCenter = new Point(findCenterX(), findCenterY());
        elements = driver.findElementsByAndroidUIAutomator("new UiSelector().descriptionMatches(\"([0-9])\")");
        radius = (this.getThree().getLocation().getX() + this.getThree().getSize().getWidth() / 2) - clockCenter.getX()-10;
//      elements = driver.findElementsByClassName("android.widget.RadialTimePickerView.RadialPickerTouchHelper");
    }

    @FindBy(id = "android:id/minutes")
    WebElement minutesSelector;

    @FindBy(id = "android:id/button1")
    WebElement okButton;

    @FindBy(id = "android:id/radial_picker")
    WebElement radialPicker;

    @FindBy(id = "android:id/hours")
    MobileElement hoursSelector;


    public WebElement getThree() {
//        elements = getDriver().findElementsByAndroidUIAutomator("new UiSelector().descriptionMatches(\"([0-9])*\")");
//        System.out.println(elements.size());
        return elements.get(2);
    }

    public void printElems() {
        for (WebElement element : elements) {
//            System.out.println(element.getAttribute("contentDescription"));
        }
    }

    public int getRadius() {
        return radius;
    }

    public MobileElement getHoursSelector() {
        return hoursSelector;
    }

    public WebElement getRadialPicker() {
        return radialPicker;
    }

    public WebElement setMinutes(int minutesNow) {
        return elements.get(minutesNow % 5);
    }

    public WebElement getMinutesSelector() {
        return minutesSelector;
    }

    public WebElement getOkButton() {
        return okButton;
    }

    public WebElement getZero() {
        return elements.get(0);
    }

    public void printCenter() {
        System.out.println(clockCenter.getX() + "  " + clockCenter.getY());
    }

    private int findCenterX() {
        int centerX;
        centerX = getRadialPicker().getLocation().getX() + (getRadialPicker().getSize().getHeight() / 2);
        return centerX;
    }

    private int findCenterY() {
        int centerY;
        centerY = getRadialPicker().getLocation().getY() + (getRadialPicker().getSize().getWidth() / 2);
        return centerY;
    }

    public int getXHours() {
        return 1;
    }

    private double getX(double angleGrad) {
        double angleRad = Math.toRadians(angleGrad - 90);
        return  (clockCenter.getX() + radius * Math.cos(angleRad));
    }

    private double getY(double angleGrad) {
        double angleRad = Math.toRadians(angleGrad - 90);
        return (clockCenter.getY() + radius * Math.sin(angleRad));
    }

    public Point getMinutesPoint(int minutes) {
        double angle = minutes * (6);
        return new Point((int) getX(angle),(int) getY(angle));
    }
    public Point getHoursPoint(int hours){
        int angle = hours * (30);
        return new Point((int)getX(angle),(int) getY(angle));
    }

    public void printCoords(Point point) {
        System.out.println(point.getX() + " " + point.getY());
    }

    //todo move_to with circle

}
