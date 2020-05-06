package Tests;

import Pages.LoginPage;
import Pages.MyHomePage;
import Pages.MyMainPage;
import SourceClases.Bot;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideDriver;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class BaseTest {
    private static final String BASE_URL = "http://ok.ru";
    protected static final Bot BOT3 = new Bot("TechoBot3", "TechnoPolis19");

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\config\\chromedriver.exe");
        System.setProperty("selenide.browser", "Chrome");
        Selenide.open(BASE_URL);
    }

    @Test
    public void doLoginTest() {
        login(BOT3);
    }

    protected MyMainPage login(Bot bot) {
        LoginPage loginPage = new LoginPage();
        return loginPage.doLogin(BOT3.username, BOT3.password);
    }

    protected MyHomePage homePage(Bot bot) {
        return login(BOT3).openHomePage();
    }

    @After
    public void closeAll() {
        Selenide.closeWebDriver();
    }

}
