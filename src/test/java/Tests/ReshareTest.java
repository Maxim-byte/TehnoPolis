package Tests;

import Pages.GroupPage;
import Pages.MyGroupPage;
import Pages.MyMainPage;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Test;
import static com.codeborne.selenide.Selenide.refresh;


public class ReshareTest extends BaseTest {
        @Test
        public void newPostTest() {
            final MyMainPage myHomePage = login(BOT3);
            final GroupPage groupPage = myHomePage.openGroups();
            final MyGroupPage myGroupPage = groupPage.searchGroups("Test");
            myGroupPage.reshare();
            myGroupPage.checkReshare();
        }
}
