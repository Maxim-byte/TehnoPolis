package Tests;

import Pages.MyHomePage;
import SourceClases.NavigateClass;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Test;

import static com.codeborne.selenide.Selenide.refresh;

public class StatusChangingTest extends BaseTest {
    private static final String STATUS = RandomStringUtils.randomAlphabetic(15);

    @Test
    public void checkStatusChanging() {
        final MyHomePage myHomePage = NavigateClass.homePage(BOT.getUsername(), BOT.getPassword());
        myHomePage.changeStatus(STATUS);
        refresh();
        myHomePage.checkStatusChanging(STATUS);
    }

}
