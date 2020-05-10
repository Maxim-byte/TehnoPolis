package Tests;

import Pages.MyHomePage;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Test;

import static com.codeborne.selenide.Selenide.refresh;

public class StatusChangingTest extends BaseTest {
    private static final String STATUS = RandomStringUtils.randomAlphabetic(15);

    @Test
    public void checkStatusChanging() {
        final MyHomePage myHomePage = homePage(BOT3);
        myHomePage.changeStatus(STATUS);
        refresh();
        myHomePage.checkStatusChanging(STATUS);
    }

}