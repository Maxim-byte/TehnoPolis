package Tests;

import Pages.UserPage;
import org.junit.Test;

import static SourceClases.NavigateClass.userPage;

public class AddFriendTest extends BaseTest {

    @Test
    public void AddFriendAndCheckIt() {
        final UserPage userPage = userPage(BOT.username, BOT.password);
        userPage.addFriend();
        userPage.endFriend();
    }
}
