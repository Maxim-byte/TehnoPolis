package Pages;

import SourceClases.ElementUtils;
import Tests.BaseTest;
import org.jetbrains.annotations.NotNull;
import org.junit.Assert;
import org.openqa.selenium.By;

public class MyMainPage extends BasePage {

    private static final By MY_HOME_PAGE_BUTTON_LOCATOR = By.xpath(".//a[contains(@data-l, 't,userPage')]");
    private static  final By GROUPS_TOOLBAR_BUTTON_LOCATOR = By.cssSelector("[data-l='t,userAltGroup']");
    private static final By LAST_POST_LOCATOR = By.cssSelector(".media-link_a");
    private static final By MUSIC_PAGE_BUTTON_LOCATOR = By.cssSelector(".toolbar_nav_a__audio.h-mod");
    private static final By LIKE_FIRST_FEED_BUTTON = By.xpath("//div[@class = 'feed-list']/div[3]" +
            "//div[@class = 'widget  __wide-count']");
    private static final By LIKE_ACTIVE_FIRST_FEED_BUTTON = By.xpath("//div[@class = 'feed-list']/div[3]" +
            "//div[@class = 'widget  __active __wide-count']");

    public MyMainPage() {
        super();
    }

    public void likeRecommendPost() {
        if (!ElementUtils.isDisplayed(LIKE_FIRST_FEED_BUTTON)) {
            ElementUtils.click(LIKE_ACTIVE_FIRST_FEED_BUTTON);
        }
        ElementUtils.click(LIKE_FIRST_FEED_BUTTON);
    }

    public void checkLike() {
        ElementUtils.checkPresentAndVisibility("DON'T LIKE", LIKE_ACTIVE_FIRST_FEED_BUTTON);
    }

    @Override
    protected void check() {
        ElementUtils.checkPresentAndVisibility("My home page button is invisible!!!", MY_HOME_PAGE_BUTTON_LOCATOR);
        ElementUtils.checkPresentAndVisibility("Group button locator is not visible or not presented!!!",GROUPS_TOOLBAR_BUTTON_LOCATOR);
    }

    public MyHomePage openHomePage() {
        ElementUtils.click(MY_HOME_PAGE_BUTTON_LOCATOR);
        return new MyHomePage();
    }
    public void checkLastPost(final @NotNull String expectedText){
        Assert.assertEquals(expectedText, ElementUtils.find(LAST_POST_LOCATOR).text());
    }
    public GroupPage openGroups() {
        ElementUtils.click(GROUPS_TOOLBAR_BUTTON_LOCATOR);
        return new GroupPage();
    }

    public MusicPage openMusicPage() {
        ElementUtils.click(MUSIC_PAGE_BUTTON_LOCATOR);
        return new MusicPage();
    }

    public UserPage openUserPage() {
        return new UserPage();
    }
}