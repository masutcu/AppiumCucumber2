package screens.androidScreen;

import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;

import java.time.Duration;

public class MainScreen extends ApiDemosMain {

    @FindBy(xpath = "(//android.widget.ImageView)[1]")
    public WebElement mainScreenTitle;

    @FindBy(xpath = "//android.widget.TextView[@text='API Demos']")
    public WebElement apiDemosButton;

    public boolean isMainDisplayed(){
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return  mainScreenTitle.isDisplayed();
    }
}
