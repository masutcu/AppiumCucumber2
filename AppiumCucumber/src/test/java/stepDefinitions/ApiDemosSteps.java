package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import screens.Screens;
import screens.androidScreen.ApiDemosScreen;
import screens.androidScreen.MainScreen;
import screens.androidScreen.PreferenceDependenciesScreen;
import screens.androidScreen.PreferenceScreen;
import utils.Driver;
import utils.ReusableMethods;

public class ApiDemosSteps extends ReusableMethods {
    //    MainScreen mainScreen = new MainScreen();
//    ApiDemosScreen apiDemosScreen = new ApiDemosScreen();
//    PreferenceScreen preferenceScreen = new PreferenceScreen();
//    PreferenceDependenciesScreen preferenceDependenciesScreen = new PreferenceDependenciesScreen();

    Screens screens = new Screens();


    @Given("App yuklensin")
    public void app_yuklensin() {
        Driver.getDriver();
    }

    @Given("kullanici ana ekranda")
    public void kullanici_ana_ekranda() {
        Assert.assertTrue(isElementPresent(screens.mainScreen().mainScreenTitle));
    }

    @Given("kullanici API Demos butonuna tikladi")
    public void kullanici_apı_demos_butonuna_tikladi() {
        tapOn(screens.mainScreen().apiDemosButton);
    }

    @Then("kullanici API Demos ekraninda")
    public void kullanici_apı_demos_ekraninda() {
        Assert.assertTrue(isElementPresent(screens.apiDemosScreen().apiDemosTitle));
    }

    @Then("kullanici Preference butonuna tikladi")
    public void kullanici_preference_butonuna_tikladi() {
        tapOn(screens.apiDemosScreen().preference);
    }

    @Then("kullanici Preference ekraninda")
    public void kullanici_preference_ekraninda() {
        isElementPresent(screens.preferenceScreen().preferenceScreenTitle);
    }

    @Then("kullanici Preference dependencies tikladi")
    public void kullanici_preference_dependencies_tikladi() {
        tapOn(screens.preferenceScreen().preferenceDependencies);
    }

    @Then("kullaici WiFi check box secmis olacak")
    public void kullaici_wi_fi_check_box_secmis_olacak() {
        if (screens.preferenceDependenciesScreen().checkBox.getAttribute("checked").equals("false")) {
            tapOn(screens.preferenceDependenciesScreen().checkBox);
        }
    }

    @Then("kullanici WiFi Settings tikladi")
    public void kullanici_wi_fi_settings_tikladi() {
        tapOn(screens.preferenceDependenciesScreen().wifiSettings);
    }

    @Then("WiFi Settings popup geldi")
    public void wi_fi_settings_popup_geldi() {
        Assert.assertTrue(isElementPresent(screens.preferenceDependenciesScreen().cancelButton));
    }

    @Then("kullanici {string} yazdi")
    public void kullanici_yazdi(String text) {
        enterText(screens.preferenceDependenciesScreen().textBox, text);
    }

    @Then("kullanici ok butonuna tikladi")
    public void kullanici_ok_butonuna_tikladi() {
        tapOn(screens.preferenceDependenciesScreen().okButton);
    }

    @And("kullanici Switches tikladi")
    public void kullaniciSwitchesTikladi() {
        tapOn(screens.preferenceScreen().preferenceSwitchButton);
    }

    @And("kullanici check box tikladi")
    public void kullaniciCheckBoxTikladi() {
        tapOn(screens.switchScreen().checkBox);
    }

    @And("switch butonuna tikladi")
    public void switchButonunaTikladi() {
        tapOn(screens.switchScreen().firstSwitch);
    }

    @And("check box secili olmali")
    public void checkBoxSeciliOlmali() {
        if (screens.switchScreen().checkBox.getAttribute("checked").equals("false")){
            tapOn(screens.switchScreen().checkBox);
        }
    }

    @And("ilk switch butonu kapali")
    public void ilkSwitchButonuKapali() {
        if (screens.switchScreen().firstSwitch.getAttribute("checked").equals("true")){
            tapOn(screens.switchScreen().firstSwitch);
        }
    }

    @And("ikinci switch butonu acik")
    public void ikinciSwitchButonuAcik() {
        if (screens.switchScreen().secondSwitch.getAttribute("checked").equals("false")){
            tapOn(screens.switchScreen().secondSwitch);
        }
    }

    @And("kullanici {string} butonuna tikladi")
    public void kullaniciButonunaTikladi(String text) {
        tapOnElementWithText(text);
    }

    @Then("kullanici {string} ekraninda")
    public void kullaniciEkraninda(String text) {
        Assert.assertTrue(isElementPresent(text));
    }
}
