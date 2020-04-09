package MusicTest.Pages;

import com.codeborne.selenide.SelenideDriver;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

public class Music {
    private SelenideElement music;
    protected SelenideDriver driver;

    private static final By Time = By.xpath(".//wm-duration[@value]");

    public Music(SelenideElement music, SelenideDriver driver) {
        this.music = music;
        this.driver = driver;
    }

    public boolean isMusicShort() {
        return Integer.parseInt(music.findElement(Time).findElement(Time).getAttribute("@value")) < 180;
    }

}
