package Tests;

import Pages.GroupPage;
import Pages.MyMainPage;
import SourceClases.NavigateClass;
import org.junit.Test;

public class EnterGroupTest extends BaseTest {
    private static String groupName = "Гонки";
    @Test
    public void newPostTest() {
        final MyMainPage myHomePage = NavigateClass.login(BOT.username, BOT.password);
        final GroupPage groupPage = myHomePage.openGroups();
        groupPage.addNewGroup(groupName);
        groupPage.checkAdding();
    }
}
