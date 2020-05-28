package Tests;

import Pages.MyHomePage;
import Pages.MyOptionsPage;;
import SourceClases.NavigateClass;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Test;

public class EditInfoTest extends BaseTest {
    private static final String NAME = RandomStringUtils.randomAlphabetic(10);
    private static final String SURNAME = RandomStringUtils.randomAlphabetic(10);

    @Test
    public void changeInfoTest() {
        final MyHomePage myHomePage = NavigateClass.homePage(BOT);
        final MyOptionsPage myOptionsPage = myHomePage.openInfoPage();
        myOptionsPage.changeNameAndSurname(NAME, SURNAME);
        myOptionsPage.checkNameAndSurname(NAME, SURNAME);
    }
}
