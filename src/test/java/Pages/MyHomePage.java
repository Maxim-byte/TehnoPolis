package Pages;

import SourceClases.ElementUtils;
import org.jetbrains.annotations.NotNull;
import org.junit.Assert;
import org.openqa.selenium.By;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;

public class MyHomePage extends BasePage {
    private static final By OPTIONS_BUTTON_LOCATOR = By.xpath(".//a[text()= 'Настройки']");
    private static final By NOTES_BUTTON_LOCATOR =
            By.xpath(".//a[contains(@hrefattrs, 'st.cmd=userStatuses&st._aid=NavMenu_User_StatusHistory')]");
    private static final By STATUS_BUTTON_LOCATOR =
            By.xpath(".//div[contains(@data-l, 't,profileBio')]//div[contains(@data-save-url, '/dk?cmd=SaveProfileInfo')]");
    private static final By STATUS_TEXT_FIELD_LOCATOR =
            By.xpath(".//div[contains(@class ,'text-field_cnt')]//textarea[contains(@name, 'long_bio')]");
    private static final By SAVE_STATUS_BUTTON_LOCATOR = By.xpath(".//button[contains(@data-l, 't,textField-save')]");
    private static final By STATUS_TEXT_FIELD_WITH_TEXT_LOCATOR = By.xpath(".//div[contains(@tsid, 'TextFieldText')]");

    public MyHomePage() {
        super();
    }

    @Override
    protected void check() {
        ElementUtils.checkPresentAndVisibility("Button more is not visible or not presented!!!", OPTIONS_BUTTON_LOCATOR);
        ElementUtils.checkPresentAndVisibility("Button notes is not visible or not presented!!!", NOTES_BUTTON_LOCATOR);
        ElementUtils.checkPresentAndVisibility("Status button locator is not visible or not presented!!!", STATUS_BUTTON_LOCATOR);
    }

    public MyOptionsPage openInfoPage() {
        ElementUtils.click(OPTIONS_BUTTON_LOCATOR);
        return new MyOptionsPage();
    }

    public NotesPage openNotes() {
        ElementUtils.click(NOTES_BUTTON_LOCATOR);
        return new NotesPage();
    }


    //delete old status and make new
    public void changeStatus(final @NotNull String text) {
        ElementUtils.click(STATUS_BUTTON_LOCATOR);
        ElementUtils.sendKeysWithDeleteOldValue(STATUS_TEXT_FIELD_LOCATOR, text);
        ElementUtils.click(SAVE_STATUS_BUTTON_LOCATOR);
    }

    public void checkStatusChanging(final @NotNull String expectedText) {
        ElementUtils.checkPresentAndVisibility("Status text field invisible or not present!!!", STATUS_TEXT_FIELD_WITH_TEXT_LOCATOR);
        assertThat(ElementUtils.find(STATUS_TEXT_FIELD_WITH_TEXT_LOCATOR).text(), notNullValue());
        assertThat(expectedText, equalTo(ElementUtils.find(STATUS_TEXT_FIELD_WITH_TEXT_LOCATOR).text()));
    }
}
