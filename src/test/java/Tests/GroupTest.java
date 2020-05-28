package Tests;

import Pages.MyMainPage;
import Pages.MyGroupPage;
import  Pages.GroupPage;
import SourceClases.Bot;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Test;
import static com.codeborne.selenide.Selenide.refresh;

public class GroupTest extends BaseTest {
    protected static final Bot BOT = new Bot("TechoBot3", "TechnoPolis19");
    private static final String TEXT = RandomStringUtils.randomAlphabetic(17);

    public GroupTest() {
        super(BOT);
    }

    @Test
    public void newPostTest() {
        final MyMainPage myHomePage = login(BOT);
        final GroupPage groupPage = myHomePage.openGroups();
        final MyGroupPage myGroupPage = groupPage.searchGroups("Test");
        myGroupPage.typePost(TEXT);
        refresh();
        myGroupPage.checkLastPost(TEXT);
    }
}
