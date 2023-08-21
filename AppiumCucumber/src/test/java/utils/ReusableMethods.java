package utils;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class ReusableMethods {

    public static void tapOnElementWithText(String text) {
        List<WebElement> mobileElementList = Driver.getDriver().findElements(By.className("android.widget.TextView"));
        for (WebElement page: mobileElementList) {
            if (page.getText().equalsIgnoreCase(text)){
                page.click();
            }else{
                scrollWithUiScrollable(text);
            }
            break;
        }
    }

    public static boolean isElementPresent(String text) {
        boolean elementFound = false;
        List<WebElement> mobileElementList = Driver.getDriver().findElements(By.xpath("//android.widget.TextView[@text='" + text + "']"));
        for (WebElement el : mobileElementList) {
            if (el.getText().equals(text)) {
                waitToBeVisible(el, Duration.ofSeconds(10));
                if (el.isDisplayed()) {
                    elementFound = true;
                }
            }
        }
        return elementFound;
    }

    public static void wait(int second) {
        try {
            Thread.sleep(second * 1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void tapOn(WebElement element) {
        waitToBeClickable(element, Duration.ofSeconds(10));
        element.click();
    }

    public static void enterText(WebElement element, String text) {
        waitToBeClickable(element, Duration.ofSeconds(10));
        element.sendKeys(text);
    }

    public static void enterText(WebElement element, String text, boolean needClear) {
        waitToBeClickable(element, Duration.ofSeconds(10));
        if (needClear) {
            element.clear();
        }
        element.sendKeys(text);
    }

    public static boolean isElementPresent(WebElement webElement) {
        boolean elementFound = false;
        waitToBeVisible(webElement, Duration.ofSeconds(10));
        if (webElement.isDisplayed()) {
            elementFound = true;
        }
        return elementFound;
    }

    public static void waitToBeVisible(WebElement element, Duration timeout) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), timeout);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public static void waitToBeClickable(WebElement element, Duration timeout) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), timeout);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public static void scrollWithUiScrollable(String elementText) {
        AndroidDriver driver = (AndroidDriver) Driver.getDriver();
        driver.findElement(AppiumBy.ByAndroidUIAutomator.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\""+elementText+"\"))"));

        tapOn(driver.findElement(By.xpath("//android.widget.TextView[@text='" + elementText + "']")));
    }

    public static void tap(AppiumDriver driver, WebElement element) {
        Point location = element.getLocation();
        Dimension size = element.getSize();

        Point centerOfElement = getCenterOfElement(location, size);

        PointerInput finger1 = new PointerInput(PointerInput.Kind.TOUCH, "finger1");
        Sequence sequence = new Sequence(finger1, 1)
                .addAction(finger1.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), centerOfElement))
                .addAction(finger1.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                .addAction(new Pause(finger1, Duration.ofMillis(200)))
                .addAction(finger1.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        driver.perform(Collections.singletonList(sequence));
    }

    public static void doubleTap(AppiumDriver driver, WebElement element) {
        Point location = element.getLocation();
        Dimension size = element.getSize();

        Point centerOfElement = getCenterOfElement(location, size);

        PointerInput finger1 = new PointerInput(PointerInput.Kind.TOUCH, "finger1");

        Sequence sequence = new Sequence(finger1, 1)
                .addAction(finger1.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), centerOfElement))
                .addAction(finger1.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                .addAction(new Pause(finger1, Duration.ofMillis(100)))
                .addAction(finger1.createPointerUp(PointerInput.MouseButton.LEFT.asArg()))
                .addAction(finger1.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                .addAction(new Pause(finger1, Duration.ofMillis(100)))
                .addAction(finger1.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        driver.perform(Collections.singletonList(sequence));

    }

    public static void longTap(AppiumDriver driver, WebElement element) {
        Point location = element.getLocation();
        Dimension size = element.getSize();

        Point centerOfElement = getCenterOfElement(location, size);
        PointerInput finger1 = new PointerInput(PointerInput.Kind.TOUCH, "finger1");

        Sequence sequence = new Sequence(finger1, 1).
                addAction(finger1.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), centerOfElement)).
                addAction(finger1.createPointerDown(PointerInput.MouseButton.LEFT.asArg())).
                addAction(new Pause(finger1, Duration.ofSeconds(4))).
                addAction(finger1.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        driver.perform(Collections.singletonList(sequence));
    }

    public static void scroll(AppiumDriver driver, int scroll) throws InterruptedException {
        Dimension size = driver.manage().window().getSize();
        int startX = size.getWidth() / 2 ;
        int startY = size.getHeight() / 2 ;
        int endX = startX;
        int endY = (int) (size.getHeight()*0.25);

        PointerInput finger1 = new PointerInput(PointerInput.Kind.TOUCH, "finger1");

        for (int i = 0; i <scroll ; i++) {
        Sequence sequence = new Sequence(finger1,1).
                addAction(finger1.createPointerMove(Duration.ZERO,PointerInput.Origin.viewport(), startX, startY)).
                addAction(finger1.createPointerDown(PointerInput.MouseButton.LEFT.asArg())).
                addAction(new Pause(finger1, Duration.ofMillis(200))).
                addAction(finger1.createPointerMove(Duration.ofMillis(100),PointerInput.Origin.viewport(),endX,endY)).
                addAction(finger1.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        driver.perform(Collections.singletonList(sequence));}
        Thread.sleep(3000);
    }

    public static void dragAndDrop(AppiumDriver driver, WebElement element1, WebElement element2){

        Point sourceCenter = getCenterOfElement(element1.getLocation(), element1.getSize());
        Point targetCenter = getCenterOfElement(element2.getLocation(), element2.getSize());

        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");

        Sequence sequence = new Sequence(finger,1).
                addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), sourceCenter)).
                addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg())).
                addAction(new Pause(finger, Duration.ofMillis(200))).
                addAction(finger.createPointerMove(Duration.ofMillis(3000), PointerInput.Origin.viewport(), targetCenter)).
                addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        driver.perform(Collections.singletonList(sequence));
    }

    private static Point getCenterOfElement(Point location, Dimension size){
        return new Point(location.getX() + size.getWidth() /2,
                location.getY() + size.getHeight() /2);
    }

    public static  void tabOnElementWithText(String text) throws InterruptedException {

        List<WebElement> elements = Driver.getDriver().findElements(AppiumBy.className("android.widget.TextView"));

        for (WebElement element : elements) {
            System.out.println("element.getText() = " + element.getText());
            if (element.getText().contains(text)) {
                System.out.println("element.getText()111 = " + element.getText());

                element.click();
                break;
            } else ReusableMethods.scroll(Driver.getDriver(), 1);
            break;
        }

    }




}
