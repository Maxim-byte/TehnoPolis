package Pages;

import SourceClases.ElementUtils;
import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.By;

public class MusicPage extends BasePage {

    private static final By MUSIC_ADD_BUTTON = By.xpath("//wm-track-add-button/wm-icon");
    private static final By MUSIC_MY_LIBRARY_BUTTON = By.xpath("//a[contains(@data-l, 't,library')]");
    private static final By MUSIC_HEADLINE_TRACK_TITLE = By.xpath("//wm-player-track//span[contains(@class, 'name')]");
    private static final By MUSIC_HEADLINE_TRACK_ARTIST = By.xpath("//wm-player-track//span[contains(@class, 'artist')]");
    private static final By MUSIC_FIRST_LIBRARY_TRACK_TITLE = By.xpath("//wm-tracks-list/main/wm-track[1]" +
            "//a[contains(@data-l, 't,title')]");
    private static final By MUSIC_FIRST_LIBRARY_TRACK_ARTIST = By.xpath("//wm-tracks-list/main/wm-track[1]" +
            "//a[contains(@class, 'artist')]");

    TRACK trackAdded;
    TRACK trackLibrary;

    public MusicPage() {
        super();
    }

    public void openMyLibrary() {
        ElementUtils.click(MUSIC_MY_LIBRARY_BUTTON);
    }

    public void addTrack() {
        ElementUtils.click(MUSIC_ADD_BUTTON);
        trackAdded = new TRACK(getAddTrackTitle(), getAddTrackArtist());
    }

    public void checkAddTrack(){
        trackLibrary = new TRACK(getLibraryTrackTitle(), getLibraryTrackArtist());
        ElementUtils.checkEqualsWithAssert("The track is not added", trackAdded, trackLibrary);
    }

    @Override
    protected void check() {
        ElementUtils.checkPresentAndVisibility("Button more is not visible or not presented!!!",
                MUSIC_ADD_BUTTON);
        ElementUtils.checkPresentAndVisibility("Button more is not visible or not presented!!!",
                MUSIC_MY_LIBRARY_BUTTON);
    }

    private String getAddTrackTitle() {
        return ElementUtils.getValue(MUSIC_HEADLINE_TRACK_TITLE);
    }

    private String getAddTrackArtist() {
        return ElementUtils.getValue(MUSIC_HEADLINE_TRACK_ARTIST);
    }

    private String getLibraryTrackTitle() {
        return ElementUtils.getValue(MUSIC_FIRST_LIBRARY_TRACK_TITLE);
    }

    private String getLibraryTrackArtist() {
        return ElementUtils.getValue(MUSIC_FIRST_LIBRARY_TRACK_ARTIST);
    }

    private static class TRACK {
        String name;
        String artist;

        TRACK(String name, String artist) {
            this.name = name;
            this.artist = artist;
        }

        public String getName() {
            return name;
        }

        public String getArtist() {
            return artist;
        }

        public boolean equals(@NotNull TRACK obj){
            return ((this.artist.equals(obj.artist)) && (this.name.equals(obj.name)));
        }
    }
}
