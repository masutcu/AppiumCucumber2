package screens.androidScreen;

import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;

import java.time.Duration;

public class ApiDemosMain {
    public ApiDemosMain(){
            PageFactory.initElements(new AppiumFieldDecorator(Driver.getDriver(), Duration.ofSeconds(30)),this);
        }


}
