package Pages.WrapperOnInfoChangeAlert;

import SourceClases.ElementUtils;
import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.By;

public class NoteAlertWrapper extends BaseAlertWrapper {
    private static final By WRITE_NOTE_TEXT_FIELD_LOCATOR =
            By.xpath(".//div[contains(@class, 'posting_itx emoji-tx h-mod js-ok-e js-posting-itx ok-posting-handler')]");
    private static final By SAVE_BUTTON_LOCATOR = By.xpath(".//div[contains(@data-save, 'Сохранить')]");

    public NoteAlertWrapper() {
        super();
    }

    @Override
    protected void check() {
        ElementUtils.checkPresentAndVisibility("Write note text field invisible!!!", WRITE_NOTE_TEXT_FIELD_LOCATOR);
    }

    //write new note
    public void writeNote(final @NotNull String text) {
        ElementUtils.sendKeys(WRITE_NOTE_TEXT_FIELD_LOCATOR, text);
    }

    //save new note and close alert
    public void exitAndSave() {
        ElementUtils.checkPresentAndVisibility("Save button invisible!!!",
                SAVE_BUTTON_LOCATOR);
        ElementUtils.click(SAVE_BUTTON_LOCATOR);
    }
}
