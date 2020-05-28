package Tests;

import Pages.MyHomePage;
import Pages.NotesPage;
import SourceClases.Bot;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Test;

import static com.codeborne.selenide.Selenide.sleep;

public class NoteTest extends BaseTest {
    protected static final Bot BOT = new Bot("TechoBot3", "TechnoPolis19");
    private static final String TEXT = RandomStringUtils.randomAlphabetic(17);

    public NoteTest() {
        super(BOT);
    }

    //TODO logger
    @Test
    public void newNoteTest() {
        final MyHomePage myHomePage = homePage(BOT);
        final NotesPage notePage = myHomePage.openNotes();
        notePage.makeNote(TEXT);
        sleep(4000); //TODO delete sleep
        notePage.checkLastNote(TEXT);
    }
}
