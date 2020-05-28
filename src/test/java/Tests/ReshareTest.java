package Tests;

import Pages.GroupPage;
import Pages.MyGroupPage;
import Pages.MyMainPage;
import SourceClases.NavigateClass;
import org.junit.Test;

public class ReshareTest extends BaseTest {

    @Test
    public void newPostTest() {
        final MyMainPage myHomePage = NavigateClass.doLogin(BOT.getUsername(), BOT.getPassword());
        final GroupPage groupPage = myHomePage.openGroups();
        final MyGroupPage myGroupPage = groupPage.searchGroups("Test");
        myGroupPage.reshare();
        myGroupPage.checkReshare();
    }
}
