package Tests;

import Pages.MyMainPage;
import org.junit.Test;

public class LikePostTest extends BaseTest{
    @Test
    public void CheckLikePost() {
        final MyMainPage myMainPage = openMyMainPage(BOT3);
        myMainPage.likeRecommendPost();
        myMainPage.checkLike();
    }
}
