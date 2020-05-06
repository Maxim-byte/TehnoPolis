package Tests;

import Pages.MyHomePage;
import Pages.MyOptionsPage;
import org.junit.Test;

public class EditInfoTest extends BaseTest {
    private static final String NAME = "Random";
    private static final String SURNAME = "Random";

    @Test
    public void changeInfoTest() {
        final MyHomePage myHomePage = homePage(BOT3);
        final MyOptionsPage myOptionsPage = myHomePage.openInfoPage();
        myOptionsPage.changeNameAndSurname(NAME, SURNAME);
        myOptionsPage.checkNameAndSurname(NAME, SURNAME);
    }
}
