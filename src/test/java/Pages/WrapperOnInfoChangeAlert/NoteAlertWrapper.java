package Pages.WrapperOnInfoChangeAlert;

import Pages.NotesPage;
import SourceClases.ElementUtils;
import com.codeborne.selenide.SelenideDriver;
import org.jetbrains.annotations.NotNull;
import org.junit.Assert;
import org.openqa.selenium.By;

public class NoteAlertWrapper extends BaseAlertWrapper {
    private SelenideDriver driver;
    private static final By WRITE_NOTE_TEXT_FIELD_LOCATOR =
            By.xpath(".//div[contains(@class, 'posting_itx emoji-tx h-mod js-ok-e js-posting-itx ok-posting-handler')]");
    private static final By SAVE_BUTTON_LOCATOR = By.xpath(".//div[contains(@data-save, 'Сохранить')]");

    public NoteAlertWrapper() {
        super();
    }
    @Override
    protected void check() {
        Assert.assertTrue("Write note text field invisible!!!",
                ElementUtils.isElementVisible(WRITE_NOTE_TEXT_FIELD_LOCATOR));
    }

    public void writeNote(final @NotNull String text) {
        Assert.assertTrue(ElementUtils.sendKeysIfElementPresentAndVisible(WRITE_NOTE_TEXT_FIELD_LOCATOR, text));
    }

    public void exitAndSave() {
        Assert.assertTrue("Save button invisible!!!",
                ElementUtils.isElementVisible(SAVE_BUTTON_LOCATOR));
        Assert.assertTrue(ElementUtils.clickIfElementPresentAndVisible(SAVE_BUTTON_LOCATOR));
    }
}
