package Tests;

import Pages.UserPage;
import SourceClases.Bot;
import org.junit.Test;
import SourceClases.NavigateClass;

public class AddFriendTest extends BaseTest{
    protected static final Bot BOT = new Bot("TechoBot3", "TechnoPolis19");

    public AddFriendTest() {
        super(BOT);
    }

    @Test
    public void AddFriendAndCheckIt() {
        final UserPage userPage = userPage(BOT);
        userPage.addFriend();
        userPage.endFriend();
    }
}
