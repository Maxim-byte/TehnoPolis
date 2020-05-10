package Tests;

import Pages.*;
import SourceClases.Bot;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Test;

import static com.codeborne.selenide.Selenide.refresh;
import static com.codeborne.selenide.Selenide.sleep;

public class GroupTest extends BaseTest {
    private static final String TEXT = RandomStringUtils.randomAlphabetic(17);
    @Test
    public void newPostTest() {
        final MyMainPage myHomePage = login(BOT3);
        final GroupPage groupPage = myHomePage.openGroups();
        final MyGroupPage myGroupPage = groupPage.searchGroups("Test");
        myGroupPage.typePost(TEXT);
        refresh();
        myGroupPage.checkLastPost(TEXT);
    }
}
