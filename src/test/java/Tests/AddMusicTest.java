package Tests;

import Pages.MusicPage;
import org.junit.Test;

public class AddMusicTest extends BaseTest {
    @Test
    public void AddMusicAndCheckIt() {
        final MusicPage musicPage = musicPage(BOT3);
        musicPage.addTrack();
        musicPage.openMyLibrary();
        musicPage.checkAddTrack();
    }
}
