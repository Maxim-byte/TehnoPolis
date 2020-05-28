package Tests;

import Pages.MyMainPage;
import Pages.MyGroupPage;
import Pages.GroupPage;
import SourceClases.NavigateClass;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Test;

import static com.codeborne.selenide.Selenide.refresh;

public class GroupTest extends BaseTest {
    private static final String TEXT = RandomStringUtils.randomAlphabetic(17);

    @Test
    public void newPostTest() {
        final MyMainPage myHomePage = NavigateClass.login(BOT.username, BOT.password);
        final GroupPage groupPage = myHomePage.openGroups();
        final MyGroupPage myGroupPage = groupPage.searchGroups("Test");
        myGroupPage.typePost(TEXT);
        refresh();
        myGroupPage.checkLastPost(TEXT);
    }
}
