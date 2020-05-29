package Tests;

import SourceClases.Bot;
import org.junit.After;
import org.junit.Before;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;

public class BaseTest {
    private static final String BASE_URL = "http://ok.ru";

    protected static final Bot BOT = new Bot("TechoBot3", "TechnoPolis19");

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\config\\chromedriver.exe");
        //System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver");
        System.setProperty("selenide.browser", "Chrome");
        open(BASE_URL);
    }

    @After
    public void closeAll() {
        closeWebDriver();
    }

}
