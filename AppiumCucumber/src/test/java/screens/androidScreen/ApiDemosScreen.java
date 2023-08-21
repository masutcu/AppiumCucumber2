package screens.androidScreen;

import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;

import java.time.Duration;

public class ApiDemosScreen {

    public ApiDemosScreen(){
        PageFactory.initElements(new AppiumFieldDecorator(Driver.getDriver(), Duration.ofSeconds(30)),this);
    }
    @FindBy(xpath = "//android.widget.TextView[@text='API Demos']")
    public WebElement apiDemosTitle;

    @FindBy(xpath = "//android.widget.TextView[@text='Preference']")
    public WebElement preference;

    @FindBy(xpath = "//android.widget.TextView[@text='Views']")
    public WebElement views;

}
