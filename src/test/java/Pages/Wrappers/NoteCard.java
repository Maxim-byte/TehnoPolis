package Pages.Wrappers;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.By;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class NoteCard {
    private static final By TEXT_LOCATOR = By.className("feed_b");

    private SelenideElement selenideElement;

    public NoteCard(@NotNull SelenideElement selenideElement) {
        this.selenideElement = selenideElement;
    }

    public void checkNoteText(final @NotNull String expectedText) {
        assertThat(expectedText,
                equalTo(selenideElement.find(TEXT_LOCATOR).waitUntil(Condition.visible, 5000).text()));
    }

}
