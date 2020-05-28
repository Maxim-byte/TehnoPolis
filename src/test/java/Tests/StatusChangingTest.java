package Tests;

import Pages.MyHomePage;
import SourceClases.Bot;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Test;

import static com.codeborne.selenide.Selenide.refresh;

public class StatusChangingTest extends BaseTest {
    protected static final Bot BOT = new Bot("TechoBot3", "TechnoPolis19");
    private static final String STATUS = RandomStringUtils.randomAlphabetic(15);

    public StatusChangingTest() {
        super(BOT);
    }

    @Test
    public void checkStatusChanging() {
        final MyHomePage myHomePage = homePage(BOT);
        myHomePage.changeStatus(STATUS);
        refresh();
        myHomePage.checkStatusChanging(STATUS);
    }

}
