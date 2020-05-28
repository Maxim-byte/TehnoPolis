package Pages;

import SourceClases.ElementUtils;
import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;

public class MyGroupPage extends BasePage {
    private static final By POST_TEXT_FIELD_LOCATOR = By.cssSelector(".input_placeholder");
    private static final By POST_TEXT_TYPE_FIELD_LOCATOR = By.cssSelector(".posting_itx");
    private static final By POST_SHARE_BUTTON_LOCATOR = By.cssSelector("[data-save='Сохранить']");
    private static final By LAST_POST_LOCATOR = By.cssSelector(".media-text_cnt_tx");
    private static final By POST_RESHARE_BUTTON_LOCATOR = By.cssSelector("[data-type='RESHARE']");
    private static final By PLACE_TO_RESHARE_LOCATOR = By.cssSelector(".u-menu_li.js-doNotHide");
    private static final By POST_TEXT_LOCATOR = By.cssSelector(".media-text_a");
    private static final By GO_TO_MAIN_PAGE = By.cssSelector("[data-l='t,logo']");

    protected void check() {
        ElementUtils.checkPresentAndVisibility("Post text field more is not visible or not presented!!!", POST_TEXT_FIELD_LOCATOR);
    }

    public void typePost(final @NotNull String text) {
        ElementUtils.click(POST_TEXT_FIELD_LOCATOR);
        $(POST_TEXT_TYPE_FIELD_LOCATOR).setValue(text);
        ElementUtils.checkPresentAndVisibility("Post share button more is not visible or not presented!!!", POST_SHARE_BUTTON_LOCATOR);
        ElementUtils.click(POST_SHARE_BUTTON_LOCATOR);
    }

    public void reshare() {
        ElementUtils.click(POST_RESHARE_BUTTON_LOCATOR);
        ElementUtils.click(PLACE_TO_RESHARE_LOCATOR);
    }

    public void checkReshare() {
        ElementUtils.click(GO_TO_MAIN_PAGE);
        MyMainPage mainPage = new MyMainPage();
        mainPage.checkLastPost(ElementUtils.find(POST_TEXT_LOCATOR).text());
    }

    public void checkLastPost(final @NotNull String expectedText) {
        assertThat(ElementUtils.find(LAST_POST_LOCATOR).text(), notNullValue());
        assertThat(expectedText, equalTo(ElementUtils.find(LAST_POST_LOCATOR).text()));
    }
}
