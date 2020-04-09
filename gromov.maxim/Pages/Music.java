package Pages;
import com.codeborne.selenide.SelenideDriver;
import com.codeborne.selenide.SelenideElement;

public class Music {
    private SelenideElement music;
    protected SelenideDriver driver;
    private char chr = '3' ;
    public Music(SelenideElement music, SelenideDriver driver) {
        this.music = music;
        this.driver = driver;
    }

    public boolean isMusicShort() {
        return music.text().charAt(1) < chr;
    }
}