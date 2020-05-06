package Pages.WrapperOnInfoChangeAlert;

import Pages.MyOptionsPage;
import SourceClases.ElementUtils;
import com.codeborne.selenide.SelenideDriver;
import org.jetbrains.annotations.NotNull;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

public class InfoAlertWrapper extends BaseAlertWrapper {
    public static final By NAME_TEXT_FIELD_LOCATOR = By.name("fr.surname");
    public static final By SURNAME_TEXT_FIELD_LOCATOR = By.name("fr.name");
    private static final By SAVE_BUTTON_LOCATOR = By.name("button_savePopLayerEditUserProfileNew");
    private static final By CLOSE_CONFIRMING_ALERT_BUTTON_LOCATOR = By.id("buttonId_button_close");
    private SelenideDriver driver;

    public InfoAlertWrapper() {
        super();
    }

    @Override
    protected void check() {
        Assert.assertTrue("Name text field invisible or not presented!!!",
                ElementUtils.isElementVisible(NAME_TEXT_FIELD_LOCATOR));
        Assert.assertTrue("Surname text field invisible or not presented!!!",
                ElementUtils.isElementVisible(SURNAME_TEXT_FIELD_LOCATOR));
    }

    private void changeText(final @NotNull String newName, By locator) {
        Assert.assertTrue(ElementUtils.sendKeysWithDeleteOldValueIfElementPresentAndVisible(locator, newName));
    }

    public void changeName(final @NotNull String newName) {
        changeText(newName, NAME_TEXT_FIELD_LOCATOR);
    }

    public MyOptionsPage exitAndSave() {
        //save new texts
        Assert.assertTrue("Save button field invisible or not presented!!!",
                ElementUtils.clickIfElementPresentAndVisible(SAVE_BUTTON_LOCATOR));
        //close confirm alert
        Assert.assertTrue("Close confirming alert button invisible or not presented!!!",
                ElementUtils.clickIfElementPresentAndVisible(CLOSE_CONFIRMING_ALERT_BUTTON_LOCATOR));
        return new MyOptionsPage();
    }

    public void changeSurname(final @NotNull String newSurname) {
        changeText(newSurname, SURNAME_TEXT_FIELD_LOCATOR);
    }
}
