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

    public MyMainPage() {
        super();
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
}