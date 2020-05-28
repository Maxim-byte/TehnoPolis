package Pages.WrapperOnInfoChangeAlert;

import SourceClases.ElementUtils;
import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.By;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;

public class NoteWrapper {
    private static final By LAST_NOTE_LOCATOR =
            By.xpath(".//div[contains(@tsid, 'userStatusShares')]//div[contains(@class, 'media-block media-text __full emoji-m __size-1')]");

    public NoteWrapper() {
        ElementUtils.checkPresentAndVisibility("Last note don't visible or present!!!", LAST_NOTE_LOCATOR);
    }

    public void checkLastNote(final @NotNull String expectedText) {
        assertThat(ElementUtils.find(LAST_NOTE_LOCATOR).text(), notNullValue());
        assertThat(expectedText, equalTo(ElementUtils.find(LAST_NOTE_LOCATOR).text()));
    }

}
