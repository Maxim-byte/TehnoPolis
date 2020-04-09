package MusicTest.Pages;

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
        this.driver = driver;
        this.musicButton = $(By.cssSelector(".toolbar_nav_a__audio.h-mod"));
        this.playButton = $(By.cssSelector(".wm-player-controls_play"));
        this.pauseButton = $(By.cssSelector("wm-icon[icon = 'pause'][size = '32'"));
        searchButton = $(By.cssSelector("input.base-input.__ctxujp"));
        selenideElements = $$("wm-track[track]");
    }

    public void playMusic() throws NoSuchElementException {
        musicButton.click();
        sleep(2000);
        playButton.click();
        sleep(2000);
        Assert.assertTrue("Music doesn't play!", pauseButton.exists());
    }

    public List<Music> checkAllMusic() {
        if (selenideElements == null || selenideElements.isEmpty()) {
            return TransformerForMusic.musics(selenideElements, driver);
        }
        return Collections.emptyList();
    }

    public int counterShortMusic(List<Music> musicList) {
        int counter = 0;
        for (Music music : musicList) {
            if (music.isMusicShort()) {
                counter++;
            }
        }
        return counter;
    }

    @After
    public void endOfTest() {
        close();
    }

    public String getOpen() {
        return driver.url();
    }

    protected SelenideDriver driver;
    private SelenideElement musicButton;
    private SelenideElement playButton;
    private SelenideElement pauseButton;
    private SelenideElement searchButton;
    ElementsCollection selenideElements;

}