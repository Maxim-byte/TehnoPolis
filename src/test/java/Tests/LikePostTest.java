package Tests;

import Pages.MyMainPage;
import SourceClases.Bot;
import org.junit.Test;

public class LikePostTest extends BaseTest{
    protected static final Bot BOT = new Bot("TechoBot3", "TechnoPolis19");
    public LikePostTest() {
        super(BOT);
    }

    @Test
    public void CheckLikePost() {
        final MyMainPage myMainPage = openMyMainPage(BOT);
        myMainPage.likeRecommendPost();
        myMainPage.checkLike();
    }
}
