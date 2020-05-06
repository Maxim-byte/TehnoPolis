package Pages;

import Pages.WrapperOnInfoChangeAlert.NoteAlertWrapper;
import SourceClases.UtilitiesForElements;
import com.codeborne.selenide.SelenideDriver;
import org.openqa.selenium.By;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class NotesPage extends BasePage {
    private static final By NOTE_ALERT_BUTTON_LOCATOR = By.className("pf-head_itx_a");
    private static final By LAST_NOTE_LOCATOR =
            By.xpath(".//div[contains(@tsid, 'userStatusShares')]//div[contains(@class, 'media-block media-text __full emoji-m __size-1')]");

    public NotesPage(SelenideDriver driver) {
        super(driver);
    }

    @Override
    protected void check() {
        assertTrue("Note alert button invisible!!!", UtilitiesForElements.isElementVisible(driver, NOTE_ALERT_BUTTON_LOCATOR));
    }

    public NotesPage makeNote(String text) {
        assertTrue(UtilitiesForElements.clickIfElementPresentAndVisible(driver, NOTE_ALERT_BUTTON_LOCATOR));
        NoteAlertWrapper newNote = new NoteAlertWrapper(driver);
        newNote.writeNote(text);
        return newNote.exitAndSave();
    }

    public void checkLastNote(String expectedText) {
        assertEquals(expectedText, UtilitiesForElements.find(driver, LAST_NOTE_LOCATOR).text());
    }
}
