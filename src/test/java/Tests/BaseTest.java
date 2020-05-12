package Tests;

import Pages.*;
import SourceClases.Bot;
import org.junit.After;
import org.junit.Before;

import static com.codeborne.selenide.Selenide.closeWebDriver;

import static com.codeborne.selenide.Selenide.open;

public class BaseTest {
    private static final String BASE_URL = "http://ok.ru";
    protected static final Bot BOT3 = new Bot("TechoBot3", "TechnoPolis19");

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "/home/maxim/chromedriver");
        //System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver");
        System.setProperty("selenide.browser", "Chrome");
        open(BASE_URL);
    }

    /**
     * This method do login.
     *
     * @param bot
     */
    protected MyMainPage login(Bot bot) {
        LoginPage loginPage = new LoginPage();
        return loginPage.doLogin(BOT3.username, BOT3.password);
    }

    /**
     * This method do login and open homePage.
     *
     * @param bot
     */
    protected MyHomePage homePage(Bot bot) {
        return login(BOT3).openHomePage();
    }


    protected MusicPage musicPage(Bot bot) {
        return login(BOT3).openMusicPage();
    }

    protected UserPage userPage(Bot bot) {
        return login(BOT3).openUserPage();
    }

    protected MyMainPage openMyMainPage(Bot bot) {
        return login(BOT3);
    }


    @After
    public void closeAll() {
        closeWebDriver();
    }

}