import Pages.*;
import com.codeborne.selenide.SelenideDriver;
import org.junit.Test;
import org.openqa.selenium.NoSuchElementException;
import java.util.List;
import org.junit.Assert;

public class main
{
    @Test
    public void login() {
        try{
            LoginPage login = new LoginPage(driver);
            login.login();
        }
        catch (NoSuchElementException exception){
            exception.getCause();
        }
    }
    @Test
    public void musicGo() {
        try {
            MusicPage mainPage = new MusicPage(driver);
            mainPage.playMusic();
        }
        catch (NoSuchElementException exception){
          exception.getCause();
        }
    }
    @Test
    public void shortsMusic() {
        try {
            MusicPage musicPage = new MusicPage(driver);
            List<Music> musicList = musicPage.checkAllMusic();
            musicPage.counterShortMusic(musicList);
        } catch (NoSuchElementException exception) {
            exception.getCause();
        }
    }
    protected SelenideDriver driver;
}
