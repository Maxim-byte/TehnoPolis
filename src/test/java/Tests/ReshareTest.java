package Tests;

import Pages.GroupPage;
import Pages.MyGroupPage;
import Pages.MyMainPage;
import SourceClases.Bot;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Test;
import static com.codeborne.selenide.Selenide.refresh;


public class ReshareTest extends BaseTest {
    protected static final Bot BOT = new Bot("TechoBot3", "TechnoPolis19");
    public ReshareTest() {
        super(BOT);
    }

    @Test
    public void newPostTest() {
        final MyMainPage myHomePage = login(BOT);
        final GroupPage groupPage = myHomePage.openGroups();
        final MyGroupPage myGroupPage = groupPage.searchGroups("Test");
        myGroupPage.reshare();
        myGroupPage.checkReshare();
    }
}
