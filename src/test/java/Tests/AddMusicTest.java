package Tests;

import Pages.MusicPage;
import SourceClases.NavigateClass;
import org.junit.Test;

public class AddMusicTest extends BaseTest {
    @Test
    public void AddMusicAndCheckIt() {
        final MusicPage musicPage = NavigateClass.openMusicPage(BOT.getUsername(), BOT.getPassword());
        musicPage.addTrack();
        musicPage.openMyLibrary();
        musicPage.checkAddTrack();
    }
}
