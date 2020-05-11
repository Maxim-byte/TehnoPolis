package Tests;

import Pages.GroupPage;
import Pages.MyGroupPage;
import Pages.MyMainPage;
import org.junit.Test;

import static com.codeborne.selenide.Selenide.refresh;

public class EnterGroupTest extends BaseTest {
    @Test
    public void newPostTest() {
        final MyMainPage myHomePage = login(BOT3);
        final GroupPage groupPage = myHomePage.openGroups();
        groupPage.addNewGroup("Приколы");
        groupPage.checkAdding();
    }
}
