package Tests;

import Pages.MusicPage;
import SourceClases.Bot;
import org.junit.Test;

public class AddMusicTest extends BaseTest {
    protected static final Bot BOT = new Bot("TechoBot3", "TechnoPolis19");
    public AddMusicTest() {
        super(BOT);
    }

    @Test
    public void AddMusicAndCheckIt() {
        final MusicPage musicPage = musicPage(BOT);
        musicPage.addTrack();
        musicPage.openMyLibrary();
        musicPage.checkAddTrack();
    }
}
