package Tests;

import Pages.GroupPage;
import Pages.MyGroupPage;
import Pages.MyMainPage;
import org.junit.Test;

import static com.codeborne.selenide.Selenide.refresh;

public class EnterGroupTest extends BaseTest {
private static String groupName = "Смешарики";
    @Test
    public void newPostTest() {
        final MyMainPage myHomePage = login(BOT3);
        final GroupPage groupPage = myHomePage.openGroups();
        groupPage.addNewGroup(groupName);
        groupPage.checkAdding();
    }
}
