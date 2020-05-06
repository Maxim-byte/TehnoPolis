package Tests;

import Pages.LoginPage;
import Pages.MyHomePage;
import Pages.MyInfoPage;
import Pages.MyMainPage;
import org.junit.Test;

public class EditInfoTest extends BaseTest {
    private static final String NAME = "Random";
    private static final String SURNAME = "Random";

    @Test
    public void changeInfoTest() {
        final MyHomePage myHomePage = homePage(BOT3);
        final MyInfoPage myInfoPage = myHomePage.openInfoPage();
        myInfoPage.checkNameAndSurname(NAME, SURNAME);
    }
}
