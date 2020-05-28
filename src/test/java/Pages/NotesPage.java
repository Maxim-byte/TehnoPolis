package Pages;

import Pages.WrapperOnInfoChangeAlert.NoteWrapper;
import SourceClases.ElementUtils;
import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.By;

public class NotesPage extends BasePage {
    private static final By NOTE_ALERT_BUTTON_LOCATOR =
            By.xpath(".//div[contains(@data-l, 't,feed.posting.ui.input')]//div[text()= 'Напишите заметку']");

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
        NoteAlertPage newNote = new NoteAlertPage();
        newNote.writeNote(text);
        newNote.exitAndSave();
    }

    public void checkLastNote(final @NotNull String expectedText) {
        NoteWrapper lastNote = new NoteWrapper();
        lastNote.checkLastNote(expectedText);
    }
}
