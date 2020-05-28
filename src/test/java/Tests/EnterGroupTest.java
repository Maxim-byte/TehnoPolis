package Tests;

import Pages.GroupPage;
import Pages.MyGroupPage;
import Pages.MyMainPage;
import SourceClases.Bot;
import org.junit.Test;

import static com.codeborne.selenide.Selenide.refresh;

public class EnterGroupTest extends BaseTest {
    protected static final Bot BOT = new Bot("TechoBot3", "TechnoPolis19");

    private static String groupName = "Бокс";

    public EnterGroupTest() {
        super(BOT);
    }

    @Test
    public void newPostTest() {
        final MyMainPage myHomePage = login(BOT);
        final GroupPage groupPage = myHomePage.openGroups();
        groupPage.addNewGroup(groupName);
        groupPage.checkAdding();
    }
}
