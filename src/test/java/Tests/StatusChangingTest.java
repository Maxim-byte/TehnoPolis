package Tests;

import Pages.MyHomePage;
import com.codeborne.selenide.Selenide;
import org.junit.Test;

public class StatusChangingTest extends BaseTest {
    private static final String STATUS = "I like programming!!!";

    @Test
    public void checkStatusChanging() {
        final MyHomePage myHomePage = homePage(BOT3);
        myHomePage.changeStatus(STATUS);
        Selenide.refresh();
        myHomePage.checkStatusChanging(STATUS);
    }

}
