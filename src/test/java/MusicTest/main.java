package MusicTest;

import MusicTest.Pages.LoginPage;
import MusicTest.Pages.Music;
import MusicTest.Pages.MusicPage;
import com.codeborne.selenide.SelenideDriver;
import org.junit.Test;
import org.openqa.selenium.NoSuchElementException;

import java.util.List;

public class main {
    @Test
    public void login() {
        try {
            LoginPage login = new LoginPage(driver);
            login.login();
        } catch (NoSuchElementException exception) {
            exception.getCause();
        }
    }

    @Test
    public void musicGo() {
        try {
            MusicPage musicPage = new MusicPage(driver);
            musicPage.playMusic();
        } catch (NoSuchElementException exception) {
            exception.getCause();
        }
    }

    @Test
    public void shortsMusic() {
        try {
            MusicPage musicPage = new MusicPage(driver);
            List<Music> musicList = musicPage.checkAllMusic();
            int countShortMusic = musicPage.counterShortMusic(musicList);
        } catch (NoSuchElementException exception) {
            exception.getCause();
        }
    }

    protected SelenideDriver driver;
}