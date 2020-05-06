package Pages.WrapperOnInfoChangeAlert;

import Pages.MyInfoPage;
import SourceClases.UtilitiesForElements;
import com.codeborne.selenide.SelenideDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import static org.junit.Assert.assertTrue;

public class InfoAlertWrapper {
    public static final By NAME_TEXT_FIELD_LOCATOR = By.name("fr.surname");
    public static final By SURNAME_TEXT_FIELD_LOCATOR = By.name("fr.name");
    private static final By SAVE_BUTTON_LOCATOR = By.className("ic media-layer_close_ico");
    private static final By CLOSE_CONFIRMING_ALERT_BUTTON_LOCATOR = By.className("layerPanelClose ic ic_close");
    private SelenideDriver driver;

    public InfoAlertWrapper(SelenideDriver driver) {
        this.driver = driver;
        check();
    }

    private void check() {
        assertTrue("Name text field invisible or not presented!!!",
                UtilitiesForElements.isElementVisible(driver, NAME_TEXT_FIELD_LOCATOR));
        assertTrue("Surname text field invisible or not presented!!!",
                UtilitiesForElements.isElementVisible(driver, SURNAME_TEXT_FIELD_LOCATOR));
    }

    private void changeText(String newName, By locator) {
        //delete old name
        final String deleteString = Keys.chord(Keys.CONTROL, "a") + Keys.DELETE;
        assertTrue(UtilitiesForElements.sendKeysIfElementPresentAndVisible(driver, locator, deleteString));
        //send new keys
        assertTrue(UtilitiesForElements.sendKeysIfElementPresentAndVisible(driver, locator, newName));
    }

    public void changeName(String newName) {
        changeText(newName, NAME_TEXT_FIELD_LOCATOR);
    }

    public MyInfoPage exitAndSave() {
        //save new texts
        assertTrue("Save button field invisible or not presented!!!",
                UtilitiesForElements.clickIfElementPresentAndVisible(driver, SAVE_BUTTON_LOCATOR));
        //close confirm alert
        assertTrue("Close confirming alert button invisible or not presented!!!",
                UtilitiesForElements.clickIfElementPresentAndVisible(driver, CLOSE_CONFIRMING_ALERT_BUTTON_LOCATOR));
        return new MyInfoPage(driver);
    }

    public void changeSurname(String newSurname) {
        changeText(newSurname, SURNAME_TEXT_FIELD_LOCATOR);
    }
}
