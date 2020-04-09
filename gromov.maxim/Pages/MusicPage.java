package Pages;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideDriver;
import com.codeborne.selenide.SelenideElement;
import org.junit.After;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import java.util.Collections;
import java.util.List;

import static com.codeborne.selenide.Selenide.*;

public class MusicPage extends BasePage {

    public MusicPage(SelenideDriver driver) {
        this.driver_ = driver;
        this.musicButton_ = $(By.cssSelector(".toolbar_nav_a__audio.h-mod"));
        this.playButton_ = $(By.cssSelector(".wm-player-controls_play"));
        this.pauseButton_ = $(By.cssSelector("wm-icon[icon = 'pause'][size = '32'"));
        searchButton_ = $(By.cssSelector("input.base-input.__ctxujp"));
        selenideElements_ = $$(".wm-track_time");
    }

    public void playMusic() throws NoSuchElementException {
        musicButton_.click();
        sleep(2000);
        playButton_.click();
        sleep(2000);
        Assert.assertTrue("Music doesn't play!", pauseButton_.exists());
        searchButton_.setValue("Falling  in  Reverse").pressEnter();
        sleep(1000);
    }

    public List<Music> checkAllMusic() {
        if (selenideElements_ == null || selenideElements_.isEmpty()) {
            return Collections.emptyList();
        }
        return TransformerForMusic.musics(selenideElements_, driver_);
    }

    public void counterShortMusic(List<Music> musicList) {
        int counter = 0;
        for (Music music : musicList) {
            if (music.isMusicShort()) {
                counter++;
            }
        }
        Assert.assertTrue("Doesn't exist short tracks", counter > 0);
    }

    @After
    public void endOfTest() {
        close();
    }

    public String getOpen() {
        return driver_.url();
    }

    protected SelenideDriver driver_;
    private SelenideElement musicButton_;
    private SelenideElement playButton_;
    private SelenideElement pauseButton_;
    private SelenideElement searchButton_;
    ElementsCollection selenideElements_;

}