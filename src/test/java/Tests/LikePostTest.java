package Tests;

import Pages.MyMainPage;
import SourceClases.NavigateClass;
import org.junit.Test;

public class LikePostTest extends BaseTest {

    @Test
    public void CheckLikePost() {
        final MyMainPage myMainPage = NavigateClass.openMyMainPage(BOT.getUsername(), BOT.getPassword());
        myMainPage.likeRecommendPost();
        myMainPage.checkLike();
    }
}
