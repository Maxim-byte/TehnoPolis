package Tests;

import Pages.MyHomePage;
import Pages.NotesPage;
import SourceClases.NavigateClass;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Test;

public class NoteTest extends BaseTest {
    private static final String TEXT = RandomStringUtils.randomAlphabetic(17);

    @Test
    public void newNoteTest() {
        final MyHomePage myHomePage = NavigateClass.openHomePage(BOT.getUsername(), BOT.getPassword());
        final NotesPage notePage = myHomePage.openNotes();
        notePage.makeNote(TEXT);
        notePage.checkLastNote(TEXT);
    }
}
