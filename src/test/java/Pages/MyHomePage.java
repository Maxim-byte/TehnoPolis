package Pages;

import SourceClases.ElementUtils;
import org.jetbrains.annotations.NotNull;
import org.junit.Assert;
import org.openqa.selenium.By;

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
        Assert.assertTrue("Button more is not visible or not presented!!!",
                ElementUtils.isElementVisible(OPTIONS_BUTTON_LOCATOR));
        Assert.assertTrue("Button notes is not visible or not presented!!!",
                ElementUtils.isElementVisible(NOTES_BUTTON_LOCATOR));
        Assert.assertTrue("Status button locator is not visible or not presented!!!",
                ElementUtils.isElementVisible(STATUS_BUTTON_LOCATOR));
    }

    public MyOptionsPage openInfoPage() {
        Assert.assertTrue(ElementUtils.clickIfElementPresentAndVisible(OPTIONS_BUTTON_LOCATOR));
        return new MyOptionsPage();
    }

    public NotesPage openNotes() {
        Assert.assertTrue(ElementUtils.clickIfElementPresentAndVisible(NOTES_BUTTON_LOCATOR));
        return new NotesPage();
    }

    public void changeStatus(final @NotNull String text) {
        Assert.assertTrue(ElementUtils.clickIfElementPresentAndVisible(STATUS_BUTTON_LOCATOR));
        Assert.assertTrue("Status text field is not visible or not presented!!!",
                ElementUtils.sendKeysWithDeleteOldValueIfElementPresentAndVisible(STATUS_TEXT_FIELD_LOCATOR, text));
        Assert.assertTrue("Status changing button invisible or not presented!!!",
                ElementUtils.clickIfElementPresentAndVisible(SAVE_STATUS_BUTTON_LOCATOR));
    }

    public void checkStatusChanging(final @NotNull String expectedText) {
        Assert.assertTrue("Status text field invisible or not present!!!",
                ElementUtils.isElementVisible(STATUS_TEXT_FIELD_WITH_TEXT_LOCATOR));
        Assert.assertEquals(expectedText, ElementUtils.find(STATUS_TEXT_FIELD_WITH_TEXT_LOCATOR).text());
    }
}
