package Pages;

import Pages.WrapperOnInfoChangeAlert.NoteAlertWrapper;
import SourceClases.ElementUtils;
import org.jetbrains.annotations.NotNull;
import org.junit.Assert;
import org.openqa.selenium.By;

public class NotesPage extends BasePage {
    private static final By NOTE_ALERT_BUTTON_LOCATOR =
            By.xpath(".//div[contains(@data-l, 't,feed.posting.ui.input')]//div[text()= 'Напишите заметку']");
    private static final By LAST_NOTE_LOCATOR =
            By.xpath(".//div[contains(@tsid, 'userStatusShares')]//div[contains(@class, 'media-block media-text __full emoji-m __size-1')]");

    public NotesPage() {
        super();
    }

    @Override
    protected void check() {
        ElementUtils.checkPresentAndVisibility("Note alert button invisible!!!", NOTE_ALERT_BUTTON_LOCATOR);
    }

    //make new note with wrapper
    public void makeNote(final @NotNull String text) {
        ElementUtils.click(NOTE_ALERT_BUTTON_LOCATOR);
        NoteAlertWrapper newNote = new NoteAlertWrapper();
        newNote.writeNote(text);
        newNote.exitAndSave();
    }

    public void checkLastNote(final @NotNull String expectedText) {
        Assert.assertEquals(expectedText, ElementUtils.find(LAST_NOTE_LOCATOR).text());
    }
}
