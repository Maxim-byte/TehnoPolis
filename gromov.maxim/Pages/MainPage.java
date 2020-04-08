package Pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideDriver;
import com.codeborne.selenide.SelenideElement;
import org.junit.After;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$$;

public class MainPage extends BasePage
{
    public MainPage(SelenideDriver driver){
        driver_ = driver;
        musicButton_ =  $(By.cssSelector(".toolbar_nav_a__audio.h-mod"));
        playButton_ = $(By.cssSelector(".wm-player-controls_play"));
        pauseButton_ = $(By.cssSelector("wm-icon[icon = 'pause'][size = '32'"));
        searchButton_ = $(By.cssSelector("input.base-input.__ctxujp"));
        selenideElements = $$("wm-track[track]");
    }
    public void playMusic() throws NoSuchElementException{
        musicButton_.click();
        sleep(2000);
        playButton_.click();
        sleep(2000);
        Assert.assertTrue("Music doesnt play!",pauseButton_.exists());
        searchButton_.setValue("Falling  in  Reverse").pressEnter();
        sleep(1000);
        selenideElements.shouldHaveSize(33);
    }
    @After
    public void endOfTest()
    {
        close();
    }
    public String getOpen(){
        return driver_.url();
    }
    protected SelenideDriver driver_;
    private SelenideElement musicButton_;
    private SelenideElement playButton_;
    private SelenideElement pauseButton_;
    private SelenideElement searchButton_;
    ElementsCollection selenideElements;
}