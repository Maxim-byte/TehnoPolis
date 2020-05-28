package Tests;

import Pages.UserPage;
import org.junit.Test;

import static SourceClases.NavigateClass.openUserPage;

public class AddFriendTest extends BaseTest {

    @Test
    public void AddFriendAndCheckIt() {
        final UserPage userPage = openUserPage(BOT.getUsername(), BOT.getPassword());
        userPage.addFriend();
        userPage.endFriend();
    }
}
