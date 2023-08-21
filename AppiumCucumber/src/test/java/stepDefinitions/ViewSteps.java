package stepDefinitions;

import io.appium.java_client.TouchAction;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import screens.Screens;
import screens.androidScreen.DragAndDropScreen;
import utils.Driver;

import static utils.ReusableMethods.*;

public class ViewSteps {

    Screens screens = new Screens();

    @And("kullanici Views butonuna tikladi")
    public void kullaniciViewsButonunaTikladi() {
        tapOn(screens.apiDemosScreen().views);
    }

    @Then("kullanici Views ekraninda")
    public void kullaniciViewsEkraninda() {
        Assert.assertTrue(isElementPresent(screens.viewsScreen().viewsTitle));
    }

    @And("kullanici Drag and Drop butonuna tikladi")
    public void kullaniciDragAndDropButonunaTikladi() {
        tapOn(screens.viewsScreen().dragDropButton);
    }

    @When("kullanici birinci topu ikinci topun üstüne birakti")
    public void kullaniciBirinciTopuIkinciTopunUstuneBirakti() {
        Assert.assertTrue(isElementPresent(screens.dragAndDropScreen().firstDot));
        Assert.assertTrue(isElementPresent(screens.dragAndDropScreen().secondDot));
        Assert.assertTrue(isElementPresent(screens.dragAndDropScreen().thirdDot));
        dragAndDrop(Driver.getDriver(),screens.dragAndDropScreen().firstDot,screens.dragAndDropScreen().secondDot);
    }

    @Then("kullanici dorduncu topu gordu")
    public void kullaniciDorduncuTopuGordu() throws InterruptedException {
        Assert.assertTrue(isElementPresent(screens.dragAndDropScreen().fourthDot));
        Thread.sleep(4000);
    }

    @And("kullanici {int} tiklasin")
    public void kullaniciTiklasin(int saat) {
        tapOn(screens.dateWidgetsScreen().num9);
    }

    @And("kullanici {int} ten {int} e yesil topu kaydirsin")
    public void kullaniciTenEYesilTopuKaydirsin(int dakika1, int dakika2) {
        dragAndDrop(Driver.getDriver(),screens.dateWidgetsScreen().num15, screens.dateWidgetsScreen().num45);
    }

    @And("kullanici {string} butonuna uzun basti")
    public void kullaniciButonunaUzunBasti(String text) {
        longTap(Driver.getDriver(),Driver.getDriver().findElement(By.xpath("//android.widget.TextView[@text='"+ text +"']")));
    }
}
