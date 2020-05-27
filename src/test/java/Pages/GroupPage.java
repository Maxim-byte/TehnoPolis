package Pages;

import SourceClases.ElementUtils;
import org.jetbrains.annotations.NotNull;
import org.junit.Assert;
import org.openqa.selenium.By;


import static com.codeborne.selenide.Selenide.sleep;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.*;

public class GroupPage extends BasePage
{
    private static final By GROUP_SEARCH_RESULT = By.cssSelector(".it[name='st.query']");
    private static final By CURRENT_GROUP_BUTTON =By.cssSelector(".o[data-l='t,visit']");
    private static final By ALL_GROUP_LOCATOR = By.cssSelector(".portlet_h_ac.al");
    private static final By ENTER_GROUP_LOCATOR = By.cssSelector("[data-l='t,join']");
    private static final By COUNT_GROUP_LOCATOR = By.cssSelector("[data-l='groupCard,null']");
    private static final By GO_TO_SEARCH_GROUP_LOCATOR = By.cssSelector(".mctc_navMenuActiveSec");
    private static int countOwnGroup = 0;

    @Override
    protected void check() {
        ElementUtils.checkPresentAndVisibility("Search field more is not visible or not presented!!!",GROUP_SEARCH_RESULT);
        ElementUtils.checkPresentAndVisibility("Groups is not visible or not presented!!!",ALL_GROUP_LOCATOR);
    }

    public MyGroupPage searchGroups(final @NotNull String groupName) {
        ElementUtils.click(GROUP_SEARCH_RESULT);
        $(GROUP_SEARCH_RESULT).setValue(groupName).pressEnter();
        sleep(1500);
        ElementUtils.click(CURRENT_GROUP_BUTTON);
        return new MyGroupPage();
    }

    public void addNewGroup(final @NotNull String groupName) {
        ElementUtils.click(ALL_GROUP_LOCATOR);
        sleep(1500);
        countOwnGroup = $$(COUNT_GROUP_LOCATOR).size();
        ElementUtils.click(GO_TO_SEARCH_GROUP_LOCATOR);
        ElementUtils.click(GROUP_SEARCH_RESULT);
        $(GROUP_SEARCH_RESULT).setValue(groupName).pressEnter();
        sleep(1500);
        ElementUtils.click(ENTER_GROUP_LOCATOR);
    }

    public void checkAdding() {
        ElementUtils.click(ALL_GROUP_LOCATOR);
        sleep(1500);
        Assert.assertEquals($$(COUNT_GROUP_LOCATOR).size(),countOwnGroup + 1);
    }

}
