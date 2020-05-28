package Tests;

import Pages.MyHomePage;
import Pages.NotesPage;
import SourceClases.NavigateClass;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Test;

import static com.codeborne.selenide.Selenide.sleep;

public class NoteTest extends BaseTest {
    private static final String TEXT = RandomStringUtils.randomAlphabetic(17);

    @Test
    public void newNoteTest() {
        final MyHomePage myHomePage = NavigateClass.homePage(BOT.username, BOT.password);
        final NotesPage notePage = myHomePage.openNotes();
        notePage.makeNote(TEXT);
        sleep(4000);
        notePage.checkLastNote(TEXT);
    }
}
