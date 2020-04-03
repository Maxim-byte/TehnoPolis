package Pages;

import com.codeborne.selenide.SelenideDriver;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import static com.codeborne.selenide.Selenide.*;

public class MainPage extends BasePage
{
    public MainPage(SelenideDriver driver){
        driver_ = driver;
        musicButton_ =  $(By.cssSelector("div#music_toolbar_button.toolbar_nav_a.toolbar_nav_a__audio.h-mod"));
        playButton_ = $(By.cssSelector("div.wm-player-controls_play.__io0ke8.__active"));
    }
    public void playMusic(){
        musicButton_.click();
        playButton_.click();
        sleep(5000);
        playButton_.click();
        sleep(2000);
    }
    public String getOpen(){
        return driver_.url();
    }
    protected SelenideDriver driver_;
    private SelenideElement musicButton_;
    private SelenideElement playButton_;
}
