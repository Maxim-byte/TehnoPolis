package Tests;

import Pages.MyHomePage;
import Pages.NotesPage;
import org.junit.Test;

public class NoteTest extends BaseTest {
    private static final String TEXT = "Hello world!!!";

    @Test
    public void newNoteTest() {
        final MyHomePage myHomePage = homePage(BOT3);
        final NotesPage notePage = myHomePage.openNotes();
        notePage.makeNote(TEXT);
        notePage.checkLastNote(TEXT);
    }
}
