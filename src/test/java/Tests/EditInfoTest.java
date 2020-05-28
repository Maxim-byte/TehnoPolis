package Tests;

import Pages.MyHomePage;
import Pages.MyOptionsPage;
import SourceClases.Bot;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Test;

public class EditInfoTest extends BaseTest {
    protected static final Bot BOT = new Bot("TechoBot3", "TechnoPolis19");
    private static final String NAME = RandomStringUtils.randomAlphabetic(10);
    private static final String SURNAME = RandomStringUtils.randomAlphabetic(10);
    public EditInfoTest() {
        super(BOT);
    }

    @Test
    public void changeInfoTest() {
        final MyHomePage myHomePage = homePage(BOT);
        final MyOptionsPage myOptionsPage = myHomePage.openInfoPage();
        myOptionsPage.changeNameAndSurname(NAME, SURNAME);
        myOptionsPage.checkNameAndSurname(NAME, SURNAME);
    }
}
