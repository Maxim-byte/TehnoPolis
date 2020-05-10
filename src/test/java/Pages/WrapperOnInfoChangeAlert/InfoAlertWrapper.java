package Pages.WrapperOnInfoChangeAlert;

import Pages.MyOptionsPage;
import SourceClases.ElementUtils;
import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.By;

public class InfoAlertWrapper extends BaseAlertWrapper {
    public static final By NAME_TEXT_FIELD_LOCATOR = By.name("fr.surname");
    public static final By SURNAME_TEXT_FIELD_LOCATOR = By.name("fr.name");
    private static final By SAVE_BUTTON_LOCATOR = By.name("button_savePopLayerEditUserProfileNew");
    private static final By CLOSE_CONFIRMING_ALERT_BUTTON_LOCATOR = By.id("buttonId_button_close");

    public InfoAlertWrapper() {
        super();
    }

    @Override
    protected void check() {
        ElementUtils.checkPresentAndVisibility("Name text field invisible or not presented!!!", NAME_TEXT_FIELD_LOCATOR);
        ElementUtils.checkPresentAndVisibility("Surname text field invisible or not presented!!!", SURNAME_TEXT_FIELD_LOCATOR);
    }

    //delete old text and add new
    private void changeText(final @NotNull String newName, By locator) {
        ElementUtils.sendKeysWithDeleteOldValue(locator, newName);
    }

    public void changeName(final @NotNull String newName) {
        changeText(newName, NAME_TEXT_FIELD_LOCATOR);
    }

    //save information and close alert
    public MyOptionsPage exitAndSave() {
        //save new texts
        ElementUtils.click(SAVE_BUTTON_LOCATOR);
        //close confirm alert
        ElementUtils.click(CLOSE_CONFIRMING_ALERT_BUTTON_LOCATOR);
        return new MyOptionsPage();
    }

    public void changeSurname(final @NotNull String newSurname) {
        changeText(newSurname, SURNAME_TEXT_FIELD_LOCATOR);
    }
}