import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.internal.WrapsElement;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static com.codeborne.selenide.Selenide.*;

public class main
{
    @Test
    public void okTest() {
        ChromeDriver driver = new ChromeDriver();
        open("https://ok.ru/");
        $(By.name("st.email")).setValue("+79117703698");
        $(By.name("st.password")).setValue("Gromov12345");
        $(By.cssSelector("input.button-pro.__wide")).pressEnter();
        $(By.cssSelector("div#music_toolbar_button.toolbar_nav_a.toolbar_nav_a__audio.h-mod")).click();
        $(By.cssSelector("div.wm-player-controls_play.__io0ke8.__active")).click();
        sleep(3000);
        $(By.cssSelector("div.wm-player-controls_play.__io0ke8.__active")).click();
        close();
    }
}
