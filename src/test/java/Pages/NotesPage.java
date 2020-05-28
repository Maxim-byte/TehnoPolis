package Pages;

import Pages.Trasformers.NoteTransformer;
import Pages.Wrappers.NoteCard;
import SourceClases.ElementUtils;
import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.By;

import java.util.List;

import static com.codeborne.selenide.Selenide.$$;

public class NotesPage extends BasePage {
    private static final By NOTE_ALERT_BUTTON_LOCATOR =
            By.xpath(".//div[contains(@data-l, 't,feed.posting.ui.input')]//div[text()= 'Напишите заметку']");
    private static final By NOTES_LIST_LOCATOR =
            By.xpath(".//div[contains(@class, 'media_feed user-statuses')]//div[@class='feed']");

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
        NoteCard lastNoteCard = getAllNotes().get(0);
        lastNoteCard.checkNoteText(expectedText);
    }

    private List<NoteCard> getAllNotes() {
        ElementUtils.checkPresentAndVisibility("Notes not present or visible!!!", NOTES_LIST_LOCATOR);
        return NoteTransformer.wrapNotes($$(NOTES_LIST_LOCATOR));
    }
}
