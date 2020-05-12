package Tests;

import Pages.UserPage;
import org.junit.Test;

public class AddFriendTest extends BaseTest{
    @Test
    public void AddFriendAndCheckIt() {
        final UserPage userPage = userPage(BOT3);
        userPage.addFriend();
        userPage.endFriend();
    }
}
